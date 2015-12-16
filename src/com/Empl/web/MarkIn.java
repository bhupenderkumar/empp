package com.Empl.web;

import java.io.IOException;
import java.util.Date;

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
 * Servlet implementation class MarkIn
 */
public class MarkIn extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MarkIn() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str=request.getServletPath();
		RequestDispatcher rd;
		String view="Login.jsp";
		Date d=new Date();
		HttpSession ses=request.getSession(false);
		User user=(User) ses.getAttribute("user");
		DaoI dao=DaoImpl.getInstance();
		if(str.equals("/markin")){
		view="Login.jsp";
		ses.removeAttribute("markout");
	    if(user!=null){
	    	view="Home.jsp";
	    int id=Integer.parseInt(user.getUid());
	    int i=dao.markInOut(d, id,1);
	    ses.setAttribute("markin",d);
	    System.out.println(i);
	    }
		}else if(str.equals("/markout")){
			ses.removeAttribute("markin");
		    if(user!=null){
		    int id=Integer.parseInt(user.getUid());
		    int i=dao.markInOut(d, id,2);
		    ses.setAttribute("markout",d);
		    view="Home.jsp";			
		}
	    }
		String st=response.encodeRedirectURL(view);
		rd=request.getRequestDispatcher(st);
		rd.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
