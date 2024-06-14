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
import model.AESEncryption;
import model.User;
import model.UserDAO;
import controller.UserRegistration;

@SuppressWarnings("serial")
@MultipartConfig
@WebServlet("/register")
public class UserRegistration extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		String fullName=req.getParameter("userName");
		String email=req.getParameter("userEmail");
		String phoneNum=req.getParameter("userNumber");
		String address=req.getParameter("userAddress");
		String photoPath="user-images/"+email+".png";
		String gender=req.getParameter("gender");
		String password=req.getParameter("userPassword");
		String encPassword=AESEncryption.encrypt(password);
		
		Part userPhoto=req.getPart("userPhoto");	
		
		User user=new User(fullName, email, phoneNum, address, photoPath, encPassword, gender);
		String message=new UserDAO().registerUser(user);
		
		HttpSession session=req.getSession();
		session.setAttribute("userRegistrationStatus", message+"Login Now");
		
		if (message.equals("Registration Successful!")&& userPhoto!=null && userPhoto.getInputStream().available()>0){
		String path=getServletContext().getInitParameter("photoPath");
		String fullPath=path+photoPath;
		userPhoto.write(fullPath);
		}
		
		res.sendRedirect(req.getContextPath() + "/view/JSP/UserLogin.jsp");
		
	}
	

}
