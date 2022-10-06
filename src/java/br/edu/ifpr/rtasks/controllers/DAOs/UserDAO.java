package br.edu.ifpr.rtasks.controllers.DAOs;

import br.edu.ifpr.rtasks.controllers.entities.User;
import br.edu.ifpr.rtasks.controllers.factories.ConnectionFactory;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserDAO {
    public void register(User u) throws SQLException{
        String sql = "INSERT INTO USERS (NAME, EMAIL, PASSWORD)"+" VALUES (?, ?, ?)";
        
        Connection connection = (Connection) new ConnectionFactory().getConnection();
        
        PreparedStatement stmt = connection.prepareStatement(sql);    
        stmt.setString(1, u.getName());
        stmt.setString(2, u.getEmail());
        stmt.setString(3, u.getPassword());
        
        stmt.execute();
        stmt.close();
        connection.close();
    }
}
