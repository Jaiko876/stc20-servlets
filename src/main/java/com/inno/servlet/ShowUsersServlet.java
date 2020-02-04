package com.inno.servlet;

import com.inno.dao.UserDao;
import com.inno.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@WebServlet("/users")
public class ShowUsersServlet extends UserValidate {
    private UserDao userDao;
    @Override
    public void init() throws ServletException {
        userDao = (UserDao) getServletContext().getAttribute("userDao");
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("CURRENT_USER") == null) {
            validate(req,resp);
        } else {
            Collection<User> users = userDao.showUsers();
            req.setAttribute("users", users);
            req.setAttribute("PageTitle", "Users");
            req.setAttribute("PageBody", "users.jsp");
            req.getRequestDispatcher("/layout.jsp").forward(req,resp);
        }

    }
}
