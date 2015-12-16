package com.Empl.web;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Empl.vo.User;
import com.emp.dao.DaoI;
import com.emp.dao.DaoImpl;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession ses = request.getSession(false);
		if (ses != null)
			ses.invalidate();
		System.out.println("asdasD");
		String uri = response.encodeURL("Home.jsp");
		RequestDispatcher rd = request.getRequestDispatcher(uri);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		DaoI daoI = DaoImpl.getInstance();
		int id = Integer.parseInt(request.getParameter("utext"));
		String pass = request.getParameter("upass");
		User user = daoI.getLogin(id, pass);
		String view="Home.jsp";
		
		HttpSession ses = request.getSession();
		
		if (user != null) {
			System.out.println("Login successfully ");
			view ="Home.jsp";
			ses.setAttribute("user",user);
		}else{
			request.setAttribute("msg", "Please Enter Correct userName and password");
			view="Login.jsp";
		}
		String uri = response.encodeURL(view);
		RequestDispatcher rd = request.getRequestDispatcher(uri);
		rd.forward(request, response);

	}

}
