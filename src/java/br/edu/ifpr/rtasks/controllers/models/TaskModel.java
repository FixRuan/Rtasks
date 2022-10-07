package br.edu.ifpr.rtasks.controllers.models;

import br.edu.ifpr.rtasks.controllers.DAOs.TaskDAO;
import br.edu.ifpr.rtasks.controllers.entities.Task;
import java.sql.SQLException;

public class TaskModel {
    
    public String addTask(Task t)throws SQLException{
        TaskDAO dao = new TaskDAO();
        dao.register(t);
        return "Cadastro realizado";
    };
}
