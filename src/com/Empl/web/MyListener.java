package com.Empl.web;

import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.emp.dao.DaoI;
import com.emp.dao.DaoImpl;

/**
 * Servlet implementation class MyListener
 */
public class MyListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent stx) {
		System.out.println("context destroyed");

	}

	@Override
	public void contextInitialized(ServletContextEvent stx) {
		System.out.println("Context Initialized");
			DaoI dao = DaoImpl.getInstance();
			Set<String> lst=dao.getDept();
			ServletContext scx=stx.getServletContext();
			scx.setAttribute("dept", lst);
		
	}
}