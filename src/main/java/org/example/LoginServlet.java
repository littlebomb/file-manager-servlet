package org.example;

import org.example.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws IOException, ServletException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        if (login != null && password != null) {
            UserService user = db.userRepository.getUserByLogin(login);
            if (user != null && user.getPassword().equals(password)) {
                resp.addCookie(new Cookie("login", user.getLogin()));
                resp.addCookie(new Cookie("password", user.getPassword()));
                resp.addCookie(new Cookie("email", user.getEmail()));
                resp.sendRedirect("./");
            }
            else resp.sendRedirect("./login");
        }
    }
}
