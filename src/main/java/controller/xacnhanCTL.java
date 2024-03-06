package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.giohangbean;
import bean.khachhangbean;
import bo.CTHDbo;
import bo.giohangbo;
import bo.hoadonbo;


/**
 * Servlet implementation class xacnhanCTL
 */
@WebServlet("/xacnhanCTL")
public class xacnhanCTL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public xacnhanCTL() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//kt dang nhap
				try {
					HttpSession session = request.getSession();
					khachhangbean kh = (khachhangbean)session.getAttribute("dn");
					if(kh==null)
					{
						RequestDispatcher rd= request.getRequestDispatcher("truyencontroller");
						rd.forward(request, response);
					}
					else {
						giohangbo gh =(giohangbo)session.getAttribute("gh");
						if(gh!=null)
						{
							hoadonbo hdbo = new hoadonbo();
							hdbo.them(kh.getMakh());
							long mahd=hdbo.getmaxhd();
							CTHDbo cthdbo = new CTHDbo();
							for(giohangbean gio :gh.ds)
							{
								cthdbo.them(gio.getMatruyen(), (int)gio.getSoluong(), mahd);
							}
							RequestDispatcher rd= request.getRequestDispatcher("thanhtoanCTL");
							rd.forward(request, response);
						}
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
