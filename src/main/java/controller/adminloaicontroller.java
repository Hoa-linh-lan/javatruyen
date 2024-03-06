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
import bo.loaibo;

/**
 * Servlet implementation class adminloaicontroller
 */
@WebServlet("/adminloaicontroller")
public class adminloaicontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminloaicontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setCharacterEncoding("utf-8");
			request.setCharacterEncoding("utf-8"); 
			loaibo lbo = new loaibo();
			String bt= request.getParameter("bt");
			String ml= request.getParameter("ml");
			String tl= request.getParameter("tl");
				if(bt!=null&&bt.equals("xoa")) {
					lbo.xoa(ml);
				}
				else
				if(request.getParameter("sua")!=null) {		
					lbo.sua(ml, tl);
				}
				else if(request.getParameter("them")!=null) {
					if(lbo.them(ml, tl)==0) {
						ArrayList<loaibean> dsloai = lbo.getloai();
						request.setAttribute("dsloai", dsloai);
						RequestDispatcher rd= request.getRequestDispatcher("adminloai.jsp?ktthem=1");
						rd.forward(request, response);
					}
				}
				else if(bt!=null&&bt.equals("chon")) {
					request.setAttribute("ml", ml);
					request.setAttribute("tl", tl);
				}
			ArrayList<loaibean> dsloai = lbo.getloai();
			request.setAttribute("dsloai", dsloai);
			RequestDispatcher rd= request.getRequestDispatcher("adminloai.jsp");
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
