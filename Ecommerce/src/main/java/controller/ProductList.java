package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product;
import model.UserDAO;

@WebServlet("/viewProductList")
@SuppressWarnings("serial")
public class ProductList extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Product> productList = new UserDAO().fetchProducts();
		request.setAttribute("productList", productList);
		request.getRequestDispatcher("/view/JSP/ProductList.jsp").forward(request,response);

	}
}
