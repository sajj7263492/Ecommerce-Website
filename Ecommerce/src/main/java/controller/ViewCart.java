package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Product;
import model.UserDAO;

@SuppressWarnings("serial")
@WebServlet("/viewCart")
public class ViewCart extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String userId=(String)session.getAttribute("loggedId");
		ArrayList<Product> cartList=new UserDAO().fetchCartDetails(userId);
		session.setAttribute("cartItems", cartList);
		response.sendRedirect(request.getContextPath() + "/view/JSP/ViewCart.jsp");
	}

}
