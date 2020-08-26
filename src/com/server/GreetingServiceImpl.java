package com.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.client.GreetingService;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.shared.Entity;
import com.shared.Obean;
import com.shared.Obean1;
import com.shared.Studentmcq;
import com.shared.user;

@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements GreetingService {
	Connection con = null;
	PreparedStatement pt1 = null;
	PreparedStatement pt2 = null;
	PreparedStatement pt3 = null;
	PreparedStatement pt4 = null;
	Statement st = null;
	Studentmcq e[]=new Studentmcq[100];
	ResultSet re=null;
	PreparedStatement ev=null;
	int i;

	public void init() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
		}
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3308/kalu", "root", "root");
			pt3=con.prepareStatement("insert into bhalu values(?,?,?,?,?)");
			pt1 = con.prepareStatement("insert into tt values(?,?,?,?,?,?,?)");
			pt2 = con.prepareStatement("insert into question2 values(?,?,?,?,?,?)");
			st = con.createStatement();
		} catch (SQLException e) {
		}
	}

	@Override
	public String Login(String s1, String s2) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		init();
		String ss = "not found";
		ResultSet rs = null;
		try {
			rs = st.executeQuery("select * from bhalu where email='" + s1 + "' and password='" + s2 + "'");
			if (rs.next()) {
				ss = "yes";

			}
		} catch (SQLException e) {

		}
		return ss;
	}
	
	@Override
	public String Login1(String s1, String s2) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		init();
		String ss = "not found";
		ResultSet rs = null;
		try {
			rs = st.executeQuery("select * from halu where email='" + s1 + "' and password='" + s2 + "'");
			if (rs.next()) {
				ss = "yes";

			}
		} catch (SQLException e) {

		}
		return ss;
	}

	@Override
	public Entity qb(Entity eee) throws IllegalArgumentException {

		init();

		String s1 = eee.getQue();
		String s2 = eee.getAns1();
		String s3 = eee.getAns2();
		String s4 = eee.getAns3();
		String s5 = eee.getAns4();
		String s6 = eee.getCans();
		String s7=eee.getTeachid();


		try {
			pt1.setString(1, s7);
			pt1.setString(2, s1);
			pt1.setString(3, s2);
			pt1.setString(4, s3);
			pt1.setString(5, s4);
			pt1.setString(6, s5);
			pt1.setString(7, s6);
			pt1.executeUpdate();
		} catch (Exception ee) {
			ee.printStackTrace();
		}

		return eee;
	}

	@Override
	public Entity qq(Entity eee) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		init();

		String s1 = eee.getQue();
		String s2 = eee.getAns1();
		String s3 = eee.getAns2();
		String s4 = eee.getAns3();
		String s5 = eee.getAns4();
		String s6 = eee.getCans();
		
		try {
			pt2.setString(1, s1);
			pt2.setString(2, s2);
			pt2.setString(3, s3);
			pt2.setString(4, s4);
			pt2.setString(5, s5);
			pt2.setString(6, s6);
			
			
			pt2.executeUpdate();
		} catch (Exception ee) {
			ee.printStackTrace();
		}

		return eee;

	}

		@Override
	public Obean[] fetch(String ff) throws IllegalArgumentException {
		
		ResultSet rs = null;
		int count = 0;
		try
		{
			rs = st.executeQuery("select * from tt where quizid='"+ff+"'");
			while(rs.next())
			{
				count += 1;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		Obean bb[] = new Obean[count];
		int i;
		try {
			rs = st.executeQuery("select * from tt where quizid='"+ff+"'");
			i = 0;
			while (rs.next())

			{
				bb[i] = new Obean();
				
				bb[i].setQuestion(rs.getString("question"));
				bb[i].setAns1(rs.getString("ans1"));
				bb[i].setAns2(rs.getString("ans2"));
				bb[i].setAns3(rs.getString("ans3"));
				bb[i].setAns4(rs.getString("ans4"));
				bb[i].setCans(rs.getString("cans"));
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bb;
	}

	@Override
	public Obean1[] fetch1(String name) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
		ResultSet rs = null;
		int count = 0;
		try
		{
			rs = st.executeQuery("select * from que1");
			while(rs.next())
			{
				count += 1;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		int i;
		Obean1 bb[] = new Obean1[count];
		try {
			rs = st.executeQuery("select * from que1");
			i = 0;
			while (rs.next())
			
			{
				bb[i] = new Obean1();
				bb[i].setQid(rs.getInt("qid"));
				bb[i].setQuestion(rs.getString("question"));
				bb[i].setAns1(rs.getString("ans1"));
				bb[i].setAns2(rs.getString("ans2"));
				bb[i].setAns3(rs.getString("ans3"));
				bb[i].setAns4(rs.getString("ans4"));
				bb[i].setCans(rs.getString("cans"));
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bb;
	
	}

	@Override
	public user Brainpopp(user u) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		init();
		
		String s1 = u.getFirstname();
		String s2 = u.getLastname();
		String s3 = u.getEmail();
		String s4 = u.getPassword();
		String s5 = u.getConfirmpassword();
		try
		{
			pt3.setString(1,s1);
			pt3.setString(2,s2);
			pt3.setString(3,s3);
			pt3.setString(4,s4);
			pt3.setString(5,s5);
			pt3.executeUpdate();
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
		
		return u;
	}

	@Override
	public String qui(Studentmcq a) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		String ss="NO";
		init();
		String s1=a.getTeacherid();
		String s2=a.getTeachername();
		String s3=a.getSubname();
		int k=0;
		try
		{
				k=st.executeUpdate("insert into teachname values('"+s1+"','"+s2+"','"+s3+"')");
				if(k!=0) {
					ss="YES";
				}
		}
		catch(SQLException ee)
		{
			ee.printStackTrace();
		}
		
	
		return ss;
	}

	@Override
	public Studentmcq[] tname(String s) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		init();
		try {
			ev=con.prepareStatement("select * from teachname");
			re=ev.executeQuery();
			i=0;
			while(re.next())
			{
				e[i]=new Studentmcq();
				e[i].setTeacherid(re.getString("id"));
				e[i].setTeachername(re.getString("Name"));
				e[i].setSubname(re.getString("Subject"));
				i++;
			}
			
		}catch(Exception e)
		
		{
			
		}
		return e;
	}


}
