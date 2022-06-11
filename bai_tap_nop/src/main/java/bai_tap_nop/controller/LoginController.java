package bai_tap_nop.controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import bai_tap_nop.model.*;

import static bai_tap_nop.constant.Constant.*;

@SuppressWarnings("serial")
@WebServlet("/login")
public class LoginController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		var userName = req.getParameter("username");
		var password = req.getParameter("password");
		var user = new UserModel().getUser(userName, password);
		if (user != null) {
			AddSession(req, SESSION_LOGIN, userName, 60);
			resp.sendRedirect(req.getContextPath() + "/welcome");
		} else {
			req.setAttribute("checkLogin", "failed");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
	}

	// add session
	private void AddSession(HttpServletRequest req, String name, String value, int interval) {
		var session = req.getSession();
		session.setAttribute(name, value);
		session.setMaxInactiveInterval(interval);
	}
}
