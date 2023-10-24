package servlets_person;

	import java.io.PrintWriter;

	import javax.servlet.RequestDispatcher;
	import javax.servlet.ServletException;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	public class LoginController2 extends HttpServlet{

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException{
			
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
					
//					RequestDispatcher rd=req.getRequestDispatcher("success.html");
//					rd.forward(req, res);	//sends the request
					
					res.sendRedirect("https://www.facebook.com/");
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

