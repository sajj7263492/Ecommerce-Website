package controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.x.protobuf.MysqlxCrud.Order;

import model.Orders;
import model.UserDAO;


@WebServlet("/makeOrder")
public class MakeOrder extends HttpServlet {
	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		
		
		
		 LocalDateTime currentDateTime = LocalDateTime.now();
	     DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	     DateTimeFormatter timeformat = DateTimeFormatter.ofPattern("HH:mm");
	     DateTimeFormatter orderIdFormat = DateTimeFormatter.ofPattern("HH-mm-ss");
	     
	    String userId=(String)session.getAttribute("loggedId");
		String productId=req.getParameter("productId"); 
        String orderDate = currentDateTime.format(dateformat);
        String orderTime = currentDateTime.format(timeformat);
        String orderId = "U-"+currentDateTime.format(orderIdFormat);
        
        Orders order=new Orders(orderId, productId, userId, orderDate, orderTime);
        String msg=new UserDAO().makeOrder(order);
        
        
        if (msg.equals("Order successful!")) {
        	session.setAttribute("orderStatus", msg);
        	new UserDAO().deleteCartItem(productId);
        	resp.sendRedirect("viewCart");
        	
        }		
		
	}
	
	
	
	
	
	
}
    
