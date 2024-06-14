package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cart;
import model.UserDAO;


@WebServlet("/addToCart")
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		
		String userId = (String)session.getAttribute("loggedId");
		
		String productId = request.getParameter("productId");
			
		Cart cart=new Cart(userId, productId); 
		
		String msg=new UserDAO().addToCart(cart);
		
		session.setAttribute("message", msg);
		
		response.sendRedirect("homepage");
		
	}

}
