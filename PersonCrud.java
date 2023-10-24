package servlets_person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PersonCrud {

	public Connection getConnection() throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/perservdb","root","root");
		return con;
	}
	
	public int signUp(Person p) throws Exception
	{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("insert into person values(?,?,?,?,?)");
		ps.setInt(1, p.getId());
		ps.setString(2, p.getName());
		ps.setLong(3, p.getPhone());
		ps.setString(4, p.getEmail());
		ps.setString(5, p.getPassword());
		
		int count=ps.executeUpdate();
		con.close();
		return count;
	}

	public String login(String email) throws Exception {
		
		Connection con = getConnection();

		PreparedStatement ps = con.prepareStatement("select password from person where email=?");
		ps.setString(1, email);
		
		ResultSet rs = ps.executeQuery();
		String password=null;
		while(rs.next())
		{
			password=rs.getString("password");
		}
		con.close();
		return password;
	}
}
