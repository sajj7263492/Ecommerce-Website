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
@WebServlet("/deleteProduct")
public class DeleteProduct extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productId = request.getParameter("productId");
		String msg = new UserDAO().deleteProduct(productId);
		HttpSession session = request.getSession();

		if(msg!="Successfully Deleted!")
		session.setAttribute("deleteStatus", "This product is ordered. So, it cannot be deleted!");
		
		else {
			session.setAttribute("deleteStatus", msg);
		}
		response.sendRedirect("viewProductList");
	}

}
