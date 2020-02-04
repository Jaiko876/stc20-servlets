package com.inno.servlet;

import com.inno.dao.UserDao;
import com.inno.pojo.User;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
        private UserDao userDao;

        @Override
        public void init() throws ServletException {
            userDao = (UserDao) getServletContext().getAttribute("userDao");
            super.init();
        }

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.setAttribute("PageTitle", "Login");
            req.setAttribute("PageBody", "loginform.jsp");
            req.getRequestDispatcher("/layout.jsp")
                    .forward(req, resp);
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
            String login = req.getParameter("login");
            byte[] bytes = DigestUtils.md5(req.getParameter("password"));
            String password = new String(bytes);
            if (loginExists(login)) {
                User user = userDao.getUserByLogin(login);
                if (user.getPassword().equals(password)) {
                    req.getSession().setAttribute("CURRENT_USER", user);
                    resp.sendRedirect(req.getContextPath() + "/mobiles");
                }
            } else {
                resp.sendRedirect(req.getContextPath() + "/login");
            }
        }

        private boolean loginExists(String login) {
            return userDao.getUserByLogin(login) != null;
        }
}
