package com.inno.servlet;

import com.inno.dao.UserDao;
import com.inno.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/showuser")
public class ShowUser extends HttpServlet {
    private UserDao userDao;

    @Override
    public void init() throws ServletException {
        userDao = (UserDao) getServletContext().getAttribute("userDao");
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("id");
        if (userId == null) {
            throw new ServletException("Missing parameter id");
        }
        User user = userDao.getUserById(Integer.valueOf(userId));
        if (user == null) {
            resp.setStatus(404);
            req.getRequestDispatcher("/notfound.jsp").forward(req, resp);
            return;
        }
        req.setAttribute("user", user);
        req.setAttribute("PageTitle", user.getLogin());
        req.setAttribute("PageBody", "showuser.jsp");
        req.getRequestDispatcher("/layout.jsp").forward(req, resp);
    }
}
