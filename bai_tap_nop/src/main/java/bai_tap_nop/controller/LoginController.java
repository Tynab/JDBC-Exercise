package bai_tap_nop.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bai_tap_nop.model.UserModel;

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
			resp.sendRedirect("https://divine-quest-265303.uc.r.appspot.com");
		} else {
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
