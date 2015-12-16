package com.Empl.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Empl.vo.Employee;
import com.emp.dao.DaoI;
import com.emp.dao.DaoImpl;

/**
 * Servlet implementation class MainController
 */
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MainController() {
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

		DaoI daoI = DaoImpl.getInstance();
		String url = request.getServletPath();
		HttpSession ses = request.getSession(false);
		if (url.equalsIgnoreCase("/login")) {
			// login and session
					}
		if (ses != null) {
			
			if (url.equals("/insert")) {
				// for insertion
				int eid = Integer.parseInt(request.getParameter("ueid"));
				String email = request.getParameter("uemail");
				String dept = request.getParameter("udept");
				String pass = request.getParameter("upass");
				String sal=request.getParameter("esal");
				String eimg = request.getParameter("uimg");
				String ename = request.getParameter("uname");
				Employee empl = new Employee();
				empl.setEid(eid);
				empl.setEmail(email);
				empl.setDept(dept);
				empl.setSalary(sal);
				empl.setPassword(pass);
				empl.setEimg(eimg);
				empl.setEname(ename);
				daoI.addEmployee(empl);
				String uri = response.encodeURL("Home.jsp");
				RequestDispatcher rd = request.getRequestDispatcher(uri);
				rd.forward(request, response);
				// response.sendRedirect(uri);
			}
			if (url.equals("/viewall")) {
				System.out.println(url);
				List<Employee> list = daoI.getEmployee();
				request.setAttribute("empList", list);
				String uri = response.encodeURL("ViewAllEmployee.jsp");
				RequestDispatcher rd = request.getRequestDispatcher(uri);
				rd.forward(request, response);

			}
			if (url.equals("/viewbyid")) {
				System.out.println(url);
				int id = Integer.parseInt(request.getParameter("txtid"));
				Employee empl = daoI.getEmployee(id);
				if(empl==null)
					request.setAttribute("msg1", "no employee exist with "+id+" id ");
				request.setAttribute("empl", empl);
				String uri = response.encodeURL("ViewById.jsp");
				RequestDispatcher rd = request.getRequestDispatcher(uri);
				rd.forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
