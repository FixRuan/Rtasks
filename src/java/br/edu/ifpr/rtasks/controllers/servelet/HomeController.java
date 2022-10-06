/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.edu.ifpr.rtasks.controllers.servelet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Nappy
 */
@WebServlet(name = "HomeController", urlPatterns = {"/HomeController"})
public class HomeController extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        
        if (session != null && session.getAttribute("authenticated") != null) {       
            request.getRequestDispatcher("WEB-INF/home.jsp").forward(request, response);
        } else {
            Cookie[] cookies = request.getCookies();

            if (cookies != null) {
                for (Cookie cookie: cookies) {
                    if ("logged".equals(cookie.getName())) {
                        String email = cookie.getValue();
                            
                        session = request.getSession(true);
                        session.setAttribute("authenticated", email);
                         
                        request.getRequestDispatcher("WEB-INF/home.jsp").forward(request, response);
                        break;
                    }
                }
            }
            
            request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        session.invalidate();
        
        Cookie[] cookies = req.getCookies();

        if (cookies != null) {
            for (Cookie cookie: cookies) {
                if ("logged".equals(cookie.getName())) {
                    cookie.setMaxAge(0);
                    resp.addCookie(cookie);
                         
                    resp.sendRedirect("LoginController");
                    break;
                }
            }
        }
    }
    
    
}
