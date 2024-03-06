package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class kqController
 */
@WebServlet("/kqController")
public class kqController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public kqController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String txta = request.getParameter("a");
		String txtb = request.getParameter("b");
		if(txta==null && txtb==null)
		{
			RequestDispatcher rd= request.getRequestDispatcher("Maytinh.jsp");
			rd.forward(request, response);
		}
		else
		{
			int a= Integer.parseInt(txta);
			int b= Integer.parseInt(txtb);
			float c=0;
			if(request.getParameter("cong")!=null) c=a+b; 
			else if(request.getParameter("tru")!=null) c=a-b;
			else if(request.getParameter("nhan")!=null) c=a*b;
			else if(request.getParameter("chia")!=null) c=a/b;
			request.setAttribute("a", a);
			request.setAttribute("b", b);
			request.setAttribute("c", c);
			RequestDispatcher rd= request.getRequestDispatcher("Maytinh.jsp");
			rd.forward(request, response);
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
