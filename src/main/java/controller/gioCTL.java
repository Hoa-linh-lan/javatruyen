package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.giohangbo;

/**
 * Servlet implementation class gioCTL
 */
@WebServlet("/gioCTL")
public class gioCTL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public gioCTL() {
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
			String mt= request.getParameter("mt");
			String tt= request.getParameter("tt");
			String gia= request.getParameter("gia");			
			if(mt!=null&&tt!=null&&gia!=null){
				giohangbo g= new giohangbo();
				//Neu mua hang lan dau
				if(session.getAttribute("gh")==null){
					session.setAttribute("gh", g);//Tao gio
				}
				//Gian session: gh vao bien: g
				g=(giohangbo)session.getAttribute("gh");
				//Them hang vao bien: g
				g.Them(mt,Long.parseLong(gia),1);
				//Luu bien vao session
				session.setAttribute("gh", g);
				}
			response.sendRedirect("htgio");
			
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
