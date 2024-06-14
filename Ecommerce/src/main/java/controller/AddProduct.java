package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;


import model.Product;
import model.UserDAO;

@SuppressWarnings("serial")
@MultipartConfig
@WebServlet("/addProduct")
public class AddProduct extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("productId");
		String name=request.getParameter("productName");
		String price=request.getParameter("productPrice");
		String brand=request.getParameter("productBrand");
		String imagePath="product-images/"+id+".png";
		
		HttpSession session=request.getSession();
		
		Product product=new Product(id, name, price, brand, imagePath);
		String msg=new UserDAO().addProduct(product);
		
		Part productImage=request.getPart("productImage");
		
		session.setAttribute("addStatus", msg);
				
		if (msg.equals("Product added successfully!") && productImage!=null && productImage.getInputStream().available()>0) {
			String path=getServletContext().getInitParameter("photoPath");
			String fullPath=path+imagePath;
			productImage.write(fullPath);
		}
		response.sendRedirect("viewProductList");
	}

}
