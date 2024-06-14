package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(value = {"/addToCart","/view/JSP/ViewCart.jsp","/editProfile","/viewProfile"})
public class LoginFilter implements Filter{

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpSession session=((HttpServletRequest)request).getSession();
		 if (session != null && session.getAttribute("isLoggedIn") != null && (Boolean) session.getAttribute("isLoggedIn")){
			chain.doFilter(request, response);
		}
		else {
			session.setAttribute("loginError","Do login first!");
			((HttpServletResponse) response).sendRedirect(((HttpServletRequest) request).getContextPath() + "/view/JSP/UserLogin.jsp");
		}
		
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		
	}
	

}
