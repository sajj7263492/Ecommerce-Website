package controller;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserDAO;
@SuppressWarnings("serial")
@WebServlet("/deleteCartItem")
public class DeleteCartItem extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productId=request.getParameter("productId");
		String msg=new UserDAO().deleteCartItem(productId);
		
		HttpSession session=request.getSession();
		
		session.setAttribute("deleteMessage", msg);
		
		System.out.println(msg);
		
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/JSP/ViewCart.jsp");
//        dispatcher.forward(request, response);
		response.sendRedirect("viewCart");
	}
}