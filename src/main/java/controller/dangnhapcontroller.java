package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.khachhangbean;
import bo.khachhangbo;

/**
 * Servlet implementation class dangnhapcontroller
 */
@WebServlet("/dangnhapcontroller")
public class dangnhapcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dangnhapcontroller() {
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
			String un=request.getParameter("txtun");	
			String pass=request.getParameter("txtpass");
			khachhangbo khbo = new khachhangbo();
			khachhangbean kh ;
			if(un!=null && pass!=null)
			{
				kh=khbo.dangnhap(un, pass);
				if(kh!=null) 
				{			
					if(session.getAttribute("dn")==null)
						session.setAttribute("dn", kh);
					RequestDispatcher rd= request.getRequestDispatcher("truyencontroller");
					rd.forward(request, response);
				}
				else  
				{
					RequestDispatcher rd= request.getRequestDispatcher("truyencontroller?kt=1");
					rd.forward(request, response);
				}
			} 
			else
			{
				RequestDispatcher rd= request.getRequestDispatcher("truyencontroller");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			// TODO: handle exception
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
