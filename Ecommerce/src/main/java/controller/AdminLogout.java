package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/adminLogout")
public class AdminLogout extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
	    if (session != null) {
	    	session.removeAttribute("loggedAdminId");
	    }
	    response.sendRedirect(request.getContextPath() + "/view/JSP/AdminLogin.jsp");
	}
	
}
