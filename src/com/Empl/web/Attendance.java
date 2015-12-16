package com.Empl.web;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class Attendance
 */
public class Attendance extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Attendance() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoI dao=DaoImpl.getInstance();
		String view="Home.jsp";
		RequestDispatcher rd;
		int id=0;
		int falg=0;
		HttpSession ses=request.getSession(false);
		if(request.getParameter("id")!=null){
			id=Integer.parseInt(request.getParameter("id"));
			falg=1;
		}
		if(ses!=null){
		User user=(User) ses.getAttribute("user");	
		if(user!=null){
			String i=user.getUid();
			if(falg==0){
			 id=Integer.parseInt(i);
			}
			List str=dao.getAttendace(id);
			request.setAttribute("atten", str);
			view="Attendance.jsp";
			if(str.size()==0){
				request.setAttribute("msg", " no attendance recored");
			}
			System.out.println(str);
		}
		}
		view=response.encodeRedirectURL(view);
		rd=request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
