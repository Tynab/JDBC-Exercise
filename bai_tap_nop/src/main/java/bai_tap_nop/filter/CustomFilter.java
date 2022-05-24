package bai_tap_nop.filter;

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
			resp.sendRedirect("https://divine-quest-265303.uc.r.appspot.com");
		} else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
}
