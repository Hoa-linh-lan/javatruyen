package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.CTHDbo;
import dao.CTHDdao;
import dao.coso;

/**
 * Servlet implementation class adminxacnhancontroller
 */
@WebServlet("/adminxacnhancontroller")
public class adminxacnhancontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminxacnhancontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			// lấy về mact
			String maCTHD = request.getParameter("mact");
			CTHDbo cthd = new CTHDbo();
			if(maCTHD !=null) {
				cthd.Sua(Long.parseLong(maCTHD));		
			}
			request.setAttribute("ds", cthd.getxacnhan());
			RequestDispatcher rd =
					request.getRequestDispatcher("admin.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			
			e.printStackTrace();//là răng hèo m muốn hiện thị cái danh sách hóa đơn như bên sách hả
			// umk , như bên sách rứa mfa phần chi tiết hóa đơn với hóa đơn ko them vào được sql nên nó báo lỗi
			//để t hiện lỗi cho 
			// rứa ak, nó báo bên sql nữa :))
			
			
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
