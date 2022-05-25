package bai_tap_nop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static bai_tap_nop.constant.Constant.*;

@SuppressWarnings("serial")
@WebServlet("/welcome")
public class WelcomeController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("welcome.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		var session = req.getSession();
		session.removeAttribute(SESSION_LOGIN);
		resp.sendRedirect(req.getContextPath() + "/login");
	}
}
