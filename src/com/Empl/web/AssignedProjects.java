package com.Empl.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Empl.vo.Project;
import com.Empl.vo.User;
import com.emp.dao.DaoI;
import com.emp.dao.DaoImpl;

/**
 * Servlet implementation class AssignedProjects
 */
public class AssignedProjects extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssignedProjects() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoI dao=DaoImpl.getInstance();
		RequestDispatcher rd;
		int id;
		User user;
		HttpSession ses;
		if(request.getParameter("id")!=null)
		 id=Integer.parseInt(request.getParameter("id"));
		else{
			  ses=request.getSession(false);
		user=(User) ses.getAttribute("user");
		id=Integer.parseInt(user.getUid());
		}
		List list=dao.projectList(id);
		request.setAttribute("project", list);
		for(Object proj:list){
			System.out.println(proj);
		}
		rd=request.getRequestDispatcher("Projects.jsp");
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
