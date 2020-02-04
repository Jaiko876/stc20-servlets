package com.inno.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserValidate extends HttpServlet {
     protected static void validate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         if (request.getSession().getAttribute("CURRENT_USER") == null) {
             String error = "You have to login first";
             request.setAttribute("error", error);
             request.getRequestDispatcher("/mobiles")
                     .forward(request, response);
         }
     }
}
