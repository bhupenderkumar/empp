package com.emp.dao;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.Empl.vo.Employee;
import com.Empl.vo.User;

public class HibImpl implements DaoI{
	private static SessionFactory sfac;
    static{
    	 Configuration  cfg = new Configuration().configure();
		 sfac=cfg.buildSessionFactory();
    }
    
	@Override
	public List<Employee> getEmployee() {
		Session ses=sfac.openSession();
		String hbm="from Employee ";
		Query quer=ses.createQuery(hbm);
		List<Employee> list=quer.list();
		return list;
	}

	@Override
	public Employee getEmployee(int pid) {
		Session ses=sfac.openSession();
		String hbm="from Employee  where eid =?";
		Query quer=ses.createQuery(hbm);
		quer.setInteger(0, pid);
		Employee emp=(Employee)quer.uniqueResult();
		return emp;
	}

	@Override
	public Set<String> getDept() {
		Session ses=sfac.openSession();
		String hbm=" select dept from Employee  ";
		Query quer=ses.createQuery(hbm);
		List<String> list=quer.list();
		Set<String> set=new HashSet<String>();
		set.addAll(list);
		return set;
	}

	@Override
	public int addEmployee(Employee empl) {
		Session ses=sfac.openSession();
		Transaction tb=null;
		try{
			tb=ses.beginTransaction();
			ses.save(empl);
			return 1;
		}catch(HibernateException hb){
			if(tb!=null)
				tb.rollback();
			System.out.println(hb.getMessage());
		}finally{
			ses.close();
		}
      return -1;
	}

	@Override
	public User getLogin(int id, String pass) {
		Session ses=sfac.openSession();
		String hbm=" from User where uid=? and upass=?  ";
		Query quer=ses.createQuery(hbm);
		quer.setInteger(0, id);
		quer.setString(1, pass);
		User list=(User) quer.uniqueResult();
		return list;
	}

	@Override
	public int markInOut(Date d, int id, int mo) {
		
		return 0;
	}

	@Override
	public List getAttendace(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List projectList(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertProject(int id, int proje) {
		// TODO Auto-generated method stub
		return 0;
	}

}
