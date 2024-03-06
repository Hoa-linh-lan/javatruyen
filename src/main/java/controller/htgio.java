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
import bo.loaibo;

import bo.truyenbo;

/**
 * Servlet implementation class htgio
 */
@WebServlet("/htgio")
public class htgio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public htgio() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			HttpSession session = request.getSession();
			loaibo lbo = new loaibo();
			ArrayList<loaibean> dsloai = lbo.getloai();
			request.setAttribute("dsloai", dsloai);
			giohangbo gh = new giohangbo();
			if(session.getAttribute("gh")!=null){
			gh=(giohangbo)session.getAttribute("gh");
			truyenbo tbo = new truyenbo();
			ArrayList<truyenbean> dstruyen =tbo.gettruyen();
			int a=0;
			if(gh.ds != null) a=gh.ds.size();	
			request.setAttribute("tongtien",(Long)gh.Tongtien());
			request.setAttribute("a", (Integer)a);
			request.setAttribute("ds", gh.ds);	
			request.setAttribute("truyen", dstruyen);
			}
			RequestDispatcher rd= request.getRequestDispatcher("gio.jsp");
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
