package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.OrderDetails;
import model.UserDAO;
@WebServlet("/showOrders")
public class ShowOrders extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<OrderDetails> orderList=new UserDAO().fetchOrderDetails();
		request.setAttribute("orderList", orderList);
		request.getRequestDispatcher("/view/JSP/OrderList.jsp").forward(request,response);
	}
}
