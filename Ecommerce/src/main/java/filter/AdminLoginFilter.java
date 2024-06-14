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

@WebFilter(value = { "/showOrders", "/updateProduct", "/viewProductList", "/editProduct", "/deleteProduct",
		"/addProduct","/ProductList.jsp" })
public class AdminLoginFilter implements Filter {
	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest) request).getSession();
		if (session != null && session.getAttribute("loggedAdminId") != null) {
			chain.doFilter(request, response);
		} else {
			session.setAttribute("adminLoginError", "Login first!");
			((HttpServletResponse) response)
					.sendRedirect(((HttpServletRequest) request).getContextPath() + "/view/JSP/AdminLogin.jsp");
		}

	}

	public void init(FilterConfig filterConfig) throws ServletException {

	}
}
