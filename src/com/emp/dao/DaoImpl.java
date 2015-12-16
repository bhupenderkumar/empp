package com.emp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.Empl.vo.Employee;
import com.Empl.vo.Project;
import com.Empl.vo.User;

public class DaoImpl extends AbsDao implements DaoI {

	private static DaoI dao;

	private DaoImpl() {

	}

	// singleton - creates only one instance through out application
	public static DaoI getInstance() {
		if (dao == null)
			dao = new HibImpl();
		return dao;
	}

	@Override
	public List<Employee> getEmployee() {
		Connection conn = null;
		PreparedStatement st = null;
		List<Employee> lst = new ArrayList<Employee>();
		Employee empl = null;
		try {
			conn = getConn();
			String sql = "select * from employee";
			st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				empl = new Employee();
				empl.setEid(rs.getInt("eid"));
				empl.setEname(rs.getString("ename"));
				empl.setEimg(rs.getString("eimage"));
				empl.setSalary(rs.getString("salary"));
				lst.add(empl);
			}
			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}finally {
			closeConn((com.mysql.jdbc.Connection) conn);
		}
		return lst;
	}

	@Override
	public Employee getEmployee(int pid) {
		Configuration cfg = new Configuration();
		cfg = cfg.configure();
		SessionFactory sesf = cfg.buildSessionFactory();
		Session ses = sesf.openSession();
		Employee empl =(Employee) ses.get(Employee.class, pid);
		return empl;
	}

	@Override
	public Set<String> getDept() {
		Connection conn = null;
		System.out.println("sad");
		PreparedStatement st = null;
		Set<String> set = new HashSet<String>();
		try {
			conn = getConn();
			String sql = "select * from test.employee";
			System.out.println(sql);
			st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				set.add(rs.getString("dept"));
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}finally {
			closeConn((com.mysql.jdbc.Connection) conn);
		}

		return set;
	}

	@Override
	public int addEmployee(Employee empl) {
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = getConn();
			String sql = "insert into employee values (?,?,?,?,?,?)";
			st = conn.prepareStatement(sql);
			st.setInt(1, empl.getEid());
			st.setString(2, empl.getDept());
			st.setString(3, empl.getPassword());
			st.setString(4, empl.getEimg());
			st.setString(5, empl.getEname());
			st.setString(6, empl.getSalary());
			int rs = st.executeUpdate();
			return rs;
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}finally {
			closeConn((com.mysql.jdbc.Connection) conn);
		}

		return 0;
	}

	@Override
	public User getLogin(int id, String pass) {
		Connection conn = null;
		PreparedStatement st = null;
		User user = null;
		try {
			conn = getConn();
			String sql = "select * from test.login where id=? and password=? ";
			st = conn.prepareStatement(sql);
			st.setInt(1, id);
			st.setString(2, pass);
			System.out.println(st);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				user = new User();
				user.setUid(rs.getString("id"));
				user.setUname(rs.getString("name"));
				user.setUpass(rs.getString("password"));
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}finally {
			closeConn((com.mysql.jdbc.Connection) conn);
		}
		return user;
	}

	@Override
	public int markInOut(Date d, int id,int mo) {
		Connection con = null;
		java.sql.Date d1 = new java.sql.Date(d.getTime());
		int i=0;
		try {
			con = getConn();
			String sql = "insert into markinout(dts,oi,id) values(?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setDate(1, d1);
			ps.setInt(2, mo);
			ps.setInt(3, id);
			 i = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConn((com.mysql.jdbc.Connection) con);
		}

		return i;
	}

	@Override
	public List getAttendace(int id) {

		List atten= new ArrayList<String>();
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=getConn();

			String sql="select * from markinout where id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				atten.add(rs.getString("timee"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConn((com.mysql.jdbc.Connection) con);
		}

		
		return atten;
	}

	@Override
	public List projectList(int id) {
		Connection conn=null;

		Project[] proj=new Project[10];
		List<Project> list;
		list=new ArrayList<Project>();
		String sql=" select name,description from project inner join description on eid=id inner join assignedProject  e on project.eid=e.eid where project.eid=?";
		try {
			conn=getConn();
			PreparedStatement pstm=conn.prepareStatement(sql);
			pstm.setInt(1, id);
			ResultSet rs=pstm.executeQuery();
			int i=0;
			while(rs.next()){
			proj[i]=new Project();
			proj[i].setDesc(rs.getString("description"));
			proj[i].setName(rs.getString("name"));
			System.out.println(rs.getString("description"));
			list.add(proj[i]);
			i++;
			
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeConn((com.mysql.jdbc.Connection) conn);
		}

		return list;
	}

	@Override
	public int insertProject(int id, int proje) {
           
		
		
		return 0;
	}
	

}
