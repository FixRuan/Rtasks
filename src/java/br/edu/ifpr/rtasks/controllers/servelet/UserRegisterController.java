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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nappy
 */
@WebServlet(name = "UserRegisterController", urlPatterns = {"/UserRegisterController"})
public class UserRegisterController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       req.setCharacterEncoding("UTF-8");
       req.getRequestDispatcher("WEB-INF/userRegister.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");
        
        User u = new User(name, email, password);
        UserModel userModel = new UserModel();
        
        try {
            if(userModel.confirmPassword(password, confirmPassword)){
                userModel.addUser(u);
                resp.sendRedirect("LoginController");
            }
        } catch (SQLException ex) {
            System.err.println(ex);
            Logger.getLogger(UserRegisterController.class.getName()).log(Level.SEVERE, null, ex); 
        } 
    }
}
