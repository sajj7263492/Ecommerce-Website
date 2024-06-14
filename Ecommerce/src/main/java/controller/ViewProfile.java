package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import model.UserDAO;
@WebServlet("/viewProfile")
public class ViewProfile extends HttpServlet {
	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		String userId=(String)session.getAttribute("loggedId");
		System.out.println(userId);
		User user=new UserDAO().fetchUserDetails(userId);
		session.setAttribute("user", user);
		RequestDispatcher rd=req.getRequestDispatcher("view/JSP/ViewProfile.jsp");
		rd.forward(req,resp);
		
		
		
	}

}
