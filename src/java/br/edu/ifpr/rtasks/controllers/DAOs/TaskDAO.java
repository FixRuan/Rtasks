package br.edu.ifpr.rtasks.controllers.DAOs;

import br.edu.ifpr.rtasks.controllers.entities.Task;
import br.edu.ifpr.rtasks.controllers.factories.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
