package servlets_person;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class SignupController2 extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException {

		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		long phone = Long.parseLong(req.getParameter("phone"));
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		Person p = new Person();
		p.setId(id);
		p.setName(name);
		p.setPhone(phone);
		p.setEmail(email);
		p.setPassword(password);

		PersonCrud crud = new PersonCrud();
		try {
			int result = crud.signUp(p);
			// PrintWriter pw=res.getWriter();
			if (result!=0) {
				RequestDispatcher rd = req.getRequestDispatcher("login.html");
				rd.forward(req, res);
			}

		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

}
