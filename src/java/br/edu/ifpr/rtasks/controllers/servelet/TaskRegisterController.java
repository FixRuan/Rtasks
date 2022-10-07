package br.edu.ifpr.rtasks.controllers.servelet;

import br.edu.ifpr.rtasks.controllers.DAOs.UserDAO;
import br.edu.ifpr.rtasks.controllers.entities.Task;
import br.edu.ifpr.rtasks.controllers.entities.User;
import br.edu.ifpr.rtasks.controllers.models.TaskModel;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(name = "TaskRegisterController", urlPatterns = {"/TaskRegisterController"})
@MultipartConfig(maxFileSize = 8 * 1024 * 1024 * 5/*5MB*/)
public class TaskRegisterController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        req.getRequestDispatcher("WEB-INF/createTask.jsp").forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");   
        Cookie[] cookies = req.getCookies();
        String email = null;
        
        for (Cookie cookie: cookies) {
            if ("logged".equals(cookie.getName())) {
                email = cookie.getValue();
                break;
            }
        }
        
        UserDAO userDao = new UserDAO();

        String task = req.getParameter("task");
        
        Part part = req.getPart("image");
        String contentType = part.getContentType();
        
        byte[] image = new byte[part.getInputStream().available()];
        part.getInputStream().read(image);
        
        
        TaskModel model = new TaskModel();
        
        try {
            User u = userDao.findUserByEmail(email);
            Task t = new Task(task, u.getId(),image, contentType);
            
            model.addTask(t);
            resp.sendRedirect("HomeController");
        } catch (SQLException ex) {
            System.out.print(ex);
            Logger.getLogger(TaskRegisterController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
