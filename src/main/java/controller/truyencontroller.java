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
 * Servlet implementation class truyencontroller
 */
@WebServlet("/truyencontroller")
public class truyencontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public truyencontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			coso cs = new coso();
			cs.ketnoi();
			response.setCharacterEncoding("utf-8");
			request.setCharacterEncoding("utf-8"); 
			truyenbo tbo= new truyenbo();
			ArrayList<truyenbean> ds;
			ds = tbo.gettruyen();
			String ml= request.getParameter("ml");
			String key= request.getParameter("txttim");
			if(ml!=null)
			{
				ds=tbo.timma(ml);		
			}
			else if(key!=null)
				{
					ds=tbo.tim(key);		
				}
			loaibo lbo = new loaibo();
			ArrayList<loaibean> dsloai = lbo.getloai();
			request.setAttribute("ds", ds);
			request.setAttribute("dsloai", dsloai);
			RequestDispatcher rd= request.getRequestDispatcher("menu.jsp");
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
