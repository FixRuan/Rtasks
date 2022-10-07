package br.edu.ifpr.rtasks.controllers.DAOs;

import br.edu.ifpr.rtasks.controllers.entities.Task;
import br.edu.ifpr.rtasks.controllers.factories.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TaskDAO {
    public void register(Task t) throws SQLException{
     String sql = "INSERT INTO TASKS (NAME, USER_ID,IMAGE_TYPE, IMAGE_CONTENT)"+" VALUES (?, ?, ?, ?)";
     
     Connection connection = (Connection) new ConnectionFactory().getConnection();
     PreparedStatement stmt = connection.prepareStatement(sql);
     
     stmt.setString(1, t.getName());
     stmt.setInt(2, t.getUser_id());
     stmt.setString(3, t.getImage_type());
     stmt.setBytes(4, t.getImage_content());
     
     stmt.execute();
     stmt.close();
     connection.close();
    }
    
    public ArrayList<Task> listAll(int id)throws SQLException{
        String sql = "SELECT ID, USER_ID, NAME,IMAGE_TYPE, IMAGE_CONTENT FROM TASKS WHERE USER_ID = "+id;

     Connection connection = (Connection) new ConnectionFactory().getConnection();
     PreparedStatement stmt = connection.prepareStatement(sql);
     ResultSet rs = stmt.executeQuery();
     
     ArrayList<Task> tasks = new ArrayList();
     
     while(rs.next()) {
        int taskId = rs.getInt("ID");
        String name = rs.getString("NAME");
        int user_id = rs.getInt("USER_ID");
        String image_type = rs.getString("IMAGE_TYPE");
        byte[] image_content = rs.getBytes("IMAGE_CONTENT");
   
        Task t = new Task(taskId, name, user_id, image_content, image_type);
        tasks.add(t);
     }
        
     return tasks;
    }
}
