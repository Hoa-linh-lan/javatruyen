package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.loaibean;
import bean.truyenbean;
import bo.giohangbo;
import bo.hoadonbo;
import bo.loaibo;
import bo.truyenbo;


/**
 * Servlet implementation class thanhtoanCTL
 */
@WebServlet("/thanhtoanCTL")
public class thanhtoanCTL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public thanhtoanCTL() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			int tt=1;
			String a=request.getParameter("tt");
			if(a!=null) tt=Integer.parseInt(a);	
			hoadonbo hdbo = new hoadonbo();
			long mahd=hdbo.getmaxhd();
			giohangbo gh = new giohangbo();
			truyenbo tbo = new truyenbo();
			loaibo lbo = new loaibo();
			ArrayList<loaibean> dsloai = lbo.getloai();
			ArrayList<truyenbean> dstruyen =tbo.gettruyen();
			gh=(giohangbo)session.getAttribute("gh");
			request.setAttribute("tongtien",(Long)gh.Tongtien());
			request.setAttribute("dsloai", dsloai);
			request.setAttribute("mahd", (long)mahd);
			request.setAttribute("tt", (int)tt);	
			request.setAttribute("ds", gh.ds);	
			request.setAttribute("truyen", dstruyen);
			RequestDispatcher rd= request.getRequestDispatcher("thanhtoan.jsp");
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
