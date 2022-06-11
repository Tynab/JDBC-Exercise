package bai_tap_nop.filter;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import static bai_tap_nop.constant.Constant.*;

@WebFilter("/login")
public class CustomFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		var req = (HttpServletRequest) request;
		var resp = (HttpServletResponse) response;
		var session = req.getSession();
		var valSession = (String) session.getAttribute(SESSION_LOGIN);
		var isExistUser = valSession != null;
		if (isExistUser) {
			resp.sendRedirect(req.getContextPath() + "/welcome");
		} else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
}
