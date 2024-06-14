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
@WebServlet("/admin")
public class AdminLogin extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("email");
		String pass = request.getParameter("password");
		
		boolean status=new UserDAO().validateAdminLogin(id, pass);
		
		HttpSession session=request.getSession();
		
		if (status==true) {
			session.setAttribute("loggedAdminId",id);
			response.sendRedirect("showOrders");
			System.out.println("LoggedIn");
		}
		else {
			session.setAttribute("adminLoginError","Enter Correct Id and Password!");
			System.out.println("Login Error");
			response.sendRedirect(request.getContextPath() + "/view/JSP/AdminLogin.jsp");
		}
	}

}
