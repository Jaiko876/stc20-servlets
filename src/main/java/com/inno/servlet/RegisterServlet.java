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

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private UserDao userDao;

    @Override
    public void init() throws ServletException {
        userDao = (UserDao) getServletContext().getAttribute("userDao");
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("PageTitle", "Registration");
        req.setAttribute("PageBody", "registerform.jsp");
        req.getRequestDispatcher("/layout.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        byte[] bytes = DigestUtils.md5(req.getParameter("password"));
        String password = new String(bytes);
        if (loginAvailable(login) && emailAvailable(email)) {
            User user = new User(123, req.getParameter("login"), password,
                    email, req.getParameter("phone"));
            userDao.addUser(user);
            resp.sendRedirect(req.getContextPath() + "/login");
        } else {
            resp.sendRedirect(req.getContextPath() + "/register");
        }
    }

    private boolean loginAvailable(String login) {
        return userDao.getUserByLogin(login) == null;
    }

    private boolean emailAvailable(String email) {
        return userDao.getUserByEmail(email) == null;
    }
}
