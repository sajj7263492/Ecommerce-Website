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
@WebServlet("/updateProduct")
public class UpdateProduct extends HttpServlet{
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("productId");
		String name=request.getParameter("productName");
		String price=request.getParameter("productPrice");
		String brand=request.getParameter("productBrand");
		String imagePath="product-images/"+id+".png";
		
		Product product=new Product(id, name, price, brand, imagePath);
		String message=new UserDAO().updateProduct(product);
		
		Part userImage=request.getPart("productImage");
		
		HttpSession session=request.getSession();
		session.setAttribute("updateStatus", message);
		
		if ((message.equals("Product updated successfully!")) && userImage!=null && userImage.getInputStream().available()>0){		
			String path=getServletContext().getInitParameter("photoPath");
			String fullPath=path+imagePath;
			userImage.write(fullPath);
		}
		response.sendRedirect("viewProductList");
	}

	
}
