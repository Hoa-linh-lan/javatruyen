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
import bo.khachhangbo;
import bo.loaibo;
import bo.truyenbo;

/**
 * Servlet implementation class dangkyCTL
 */
@WebServlet("/dangkyCTL")
public class dangkyCTL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dangkyCTL() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			response.setCharacterEncoding("utf-8");
			request.setCharacterEncoding("utf-8"); 
			truyenbo tbo= new truyenbo();
			ArrayList<truyenbean> ds;
			String ml= request.getParameter("ml");
			ds = tbo.gettruyen();
			if(ml!=null)
			{
				ds=tbo.timma(ml);		
			}
			loaibo lbo = new loaibo();
			ArrayList<loaibean> dsloai = lbo.getloai();
			request.setAttribute("ds", ds);
			request.setAttribute("dsloai", dsloai);
			String un=request.getParameter("txtun");	
			String pass=request.getParameter("txtpass");
			String pass1=request.getParameter("txtpass1");
			String hoten=request.getParameter("txthoten");	
			String diachi=request.getParameter("txtdiachi");
			String sodt=request.getParameter("txtsdt");
			String email=request.getParameter("txtemail");
			khachhangbo khbo = new khachhangbo();		
			if(un!=null && pass!=null && pass1!=null && hoten!=null && diachi!=null && sodt!=null && email!=null)
			{
				int kt=khbo.dangky(hoten, diachi, sodt, email, un, pass, pass1);
				if(kt==1)
				{
					RequestDispatcher rd= request.getRequestDispatcher("dangky.jsp?kt=1");
					rd.forward(request, response);
				}
				else if(kt==2) 
				{
					RequestDispatcher rd= request.getRequestDispatcher("dangky.jsp?kt=2");
					rd.forward(request, response);
				}
				else if(kt==0) 
				{
					RequestDispatcher rd= request.getRequestDispatcher("dangky.jsp?kt=0");
					rd.forward(request, response);
				}
			} 
			else
			{
				RequestDispatcher rd= request.getRequestDispatcher("dangky.jsp");
				rd.forward(request, response);
			}
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
