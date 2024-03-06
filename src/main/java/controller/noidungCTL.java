package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import bean.loaibean;
import bean.truyenbean;

import bo.loaibo;
import bo.truyenbo;
import dao.coso;


/**
 * Servlet implementation class noidungCTL
 */
@WebServlet("/noidungCTL")
public class noidungCTL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public noidungCTL() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			coso kn= new coso();
			kn.ketnoi();
			
			// Dat cau hinh gui len vaf lay ve= UTF-8
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");

			// sai loaibo lay ve danh sach loai
			loaibo lbo = new loaibo();
			ArrayList<loaibean> dsloai = lbo.getloai();

			// lấy về ml và txttim tu htsach gui len
			String ml = request.getParameter("ml");
			String nd = request.getParameter("nd");

			// sai sach bo lay ve dssach
			truyenbo tbo = new truyenbo();
			ArrayList<truyenbean> dstruyen = tbo.gettruyen();
			
			
			// nếu ml!= null thi goi ham timma
			// neu key != null gọi ham tim

			if (ml != null) {
				dstruyen = tbo.timma(ml);
			} else {
				if (nd != null) {
					dstruyen = tbo.ND(nd);
					
				}
			}

			// chuyen dslaoi và dssach vè htsach
			request.setAttribute("dsloai", dsloai);
			request.setAttribute("dstruyen", dstruyen);
			

			RequestDispatcher rd = request.getRequestDispatcher("noidung.jsp");
			rd.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
