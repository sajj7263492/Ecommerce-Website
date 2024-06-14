package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserDAO;


@SuppressWarnings("serial")
@WebServlet("/userlogin")
public class UserLogin extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String id=request.getParameter("email");
		String password=request.getParameter("password");
		System.out.println(id+password);
		
		HttpSession session=request.getSession();
		
		boolean status=new UserDAO().validateLogin(id,password);
		
		if (status==true) {
			session.setAttribute("loggedId",id);
			session.setAttribute("isLoggedIn", true);
			response.sendRedirect("homepage");
			System.out.println("LoggedIn");
		}
		else {
			session.setAttribute("loginError","Enter Correct Id and Password!");
			System.out.println("Login Error");
			response.sendRedirect(request.getContextPath() + "/view/JSP/UserLogin.jsp");
		}
}
}

