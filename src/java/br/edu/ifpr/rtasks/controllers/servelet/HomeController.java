package br.edu.ifpr.rtasks.controllers.servelet;

import br.edu.ifpr.rtasks.controllers.DAOs.TaskDAO;
import br.edu.ifpr.rtasks.controllers.DAOs.UserDAO;
import br.edu.ifpr.rtasks.controllers.entities.Task;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "HomeController", urlPatterns = {"/HomeController"})
public class HomeController extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        ArrayList<Task> tasks = null;
        
        if (session != null && session.getAttribute("authenticated") != null) {       
            request.getRequestDispatcher("WEB-INF/home.jsp").forward(request, response);
        } else {
            Cookie[] cookies = request.getCookies();

            if (cookies != null) {
                for (Cookie cookie: cookies) {
                    if ("logged".equals(cookie.getName())) {
                        String email = cookie.getValue();
                        
                        UserDAO userDAO = new UserDAO();
                        TaskDAO taskDAO = new TaskDAO();
                        
                        try {
                            tasks = taskDAO.listAll(userDAO.findUserByEmail(email).getId());
                        } catch (SQLException ex) {
                            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                            
                        session = request.getSession(true);
                        session.setAttribute("authenticated", email);
                        session.setAttribute("tasks", tasks);

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
