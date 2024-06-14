package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product;
import model.UserDAO;

@WebServlet("/editProduct")
public class EditProduct extends HttpServlet{
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("productId");
		Product product=new UserDAO().fetchProductById(id);
		request.setAttribute("product",product);
		RequestDispatcher rd=request.getRequestDispatcher("view/JSP/EditProduct.jsp");
		rd.forward(request,response);
	}

}
