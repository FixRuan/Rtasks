package br.edu.ifpr.rtasks.controllers.models;

import br.edu.ifpr.rtasks.controllers.DAOs.TaskDAO;
import br.edu.ifpr.rtasks.controllers.entities.Task;
import java.sql.SQLException;
import java.util.ArrayList;

public class TaskModel {
    TaskDAO dao = new TaskDAO();
    
    public String addTask(Task t)throws SQLException{
        TaskDAO dao = new TaskDAO();
        dao.register(t);
        return "Cadastro realizado";
    };
    
    public ArrayList<Task> listAll(int id) throws SQLException {
        ArrayList<Task> tasks = dao.listAll(id);
        return tasks;
    }
}
