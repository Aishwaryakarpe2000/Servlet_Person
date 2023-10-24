package servlets_person;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class LoginController extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		String email=req.getParameter("email"); 
		String password=req.getParameter("password");
		
		Person e=new Person();
		
		e.setEmail(email);
		e.setPassword(password);
		
		PersonCrud crud=new PersonCrud();
		try
		{
			String dbpassword=crud.login(email);
			PrintWriter pw=res.getWriter();
			if(password.equals(dbpassword))
			{
				//pw.print("login success");
				
				RequestDispatcher rd=req.getRequestDispatcher("success.html");
				rd.forward(req, res);	//sends the request
				
			}
			else
			{
				//pw.print("login failed");
				
				RequestDispatcher rd=req.getRequestDispatcher("login.html");
				rd.include(req, res);	//sends back response
			}
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
		}
	}

}


