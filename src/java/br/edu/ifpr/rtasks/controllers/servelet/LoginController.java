/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.edu.ifpr.rtasks.controllers.servelet;

import br.edu.ifpr.rtasks.controllers.entities.User;
import br.edu.ifpr.rtasks.controllers.models.UserModel;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        
        if(session != null && session.getAttribute("authenticated") != null){
            request.getRequestDispatcher("WEB-INF/home.jsp").forward(request, response);
        } else{
            Cookie[] cookies = request.getCookies();
            
            if(cookies != null){
                for(Cookie cookie: cookies){
                    if("logged".equals(cookie.getName())){
                        String email = cookie.getValue();
                        
                        session = request.getSession(true);
                        session.setAttribute("authenticated", email);
                        
                        request.getRequestDispatcher("WEB-INF/home.jsp").forward(request, response);
                        break;
                    }
                }
            }
        }
        
        request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        UserModel model = new UserModel();
        
        try {
            User user = model.findUserByEmail(email);
            
            if(user != null && user.getPassword().equals(password)){
                HttpSession session = request.getSession(true);
                session.setAttribute("authenticated", user.getEmail());
                
                Cookie cookie = new Cookie("logged", user.getEmail());
                cookie.setMaxAge(60 * 60 * 24 * 30); //calculo referente a 30 dias
                response.addCookie(cookie);
                
                request.getRequestDispatcher("WEB-INF/home.jsp").forward(request, response);
            }else{
                //error
                request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
