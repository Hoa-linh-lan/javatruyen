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

import bean.khachhangbean;
import bean.lichsuMHbean;
import bean.loaibean;
import bean.truyenbean;
import bo.lichsuMHbo;
import bo.loaibo;
import bo.truyenbo;

/**
 * Servlet implementation class lichsuMHCTL
 */
@WebServlet("/lichsuMHCTL")
public class lichsuMHCTL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public lichsuMHCTL() {
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
			truyenbo tbo= new truyenbo();
			ArrayList<truyenbean> ds;
			ds = tbo.gettruyen();
			String ml= request.getParameter("ml");
			if(ml!=null)
			{
				ds=tbo.timma(ml);		
			}
			loaibo lbo = new loaibo();
			ArrayList<loaibean> dsloai = lbo.getloai();
			request.setAttribute("ds", ds);
			request.setAttribute("dsloai", dsloai);
			
			HttpSession session = request.getSession();
			khachhangbean kh = (khachhangbean)session.getAttribute("dn");
			if(kh==null)
			{
				RequestDispatcher rd= request.getRequestDispatcher("lichsuMH.jsp");
				rd.forward(request, response);
			}
			else {
				lichsuMHbo lichsu = new lichsuMHbo();
				request.setAttribute("ds", lichsu.getlichsu(kh.getMakh()));
				RequestDispatcher rd= request.getRequestDispatcher("lichsuMH.jsp");
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
