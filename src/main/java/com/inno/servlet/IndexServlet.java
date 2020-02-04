package com.inno.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/mobiles"})
public class IndexServlet extends UserValidate {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.getSession().getAttribute("CURRENT_USER");
        } catch (Exception e) {
            req.getSession().setAttribute("CURRENT_USER", null);
        }
        req.getRequestDispatcher("/index.jsp").forward(req,resp);
    }
}
