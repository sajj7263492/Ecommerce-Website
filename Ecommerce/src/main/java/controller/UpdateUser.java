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

@SuppressWarnings("serial")
@MultipartConfig
@WebServlet("/updateUser")
public class UpdateUser extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fullName = req.getParameter("userName");
		String email = req.getParameter("userEmail");
		String phoneNum = req.getParameter("userNumber");
		String address = req.getParameter("userAddress");
		String photoPath = "user-images/" + email + ".png";
		String gender = req.getParameter("gender");
		String password = req.getParameter("userPassword");
		String encPassword = AESEncryption.encrypt(password);

		User user = new User(fullName, email, phoneNum, address, photoPath, encPassword, gender);
		String msg = new UserDAO().updateUser(user);

		Part userImage = req.getPart("userPhoto");

		HttpSession session = req.getSession();
		session.setAttribute("profileUpdateStatus", msg);

		if ((msg.equals("Profile updated successfully!")) && userImage != null
				&& userImage.getInputStream().available() > 0) {
			String path = getServletContext().getInitParameter("photoPath");
			String fullPath = path + photoPath;
			userImage.write(fullPath);
		}
		resp.sendRedirect("viewProfile");
	}
}