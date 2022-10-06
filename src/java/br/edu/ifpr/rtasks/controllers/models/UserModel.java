
package br.edu.ifpr.rtasks.controllers.models;

import br.edu.ifpr.rtasks.controllers.DAOs.UserDAO;
import br.edu.ifpr.rtasks.controllers.entities.User;
import java.sql.SQLException;

public class UserModel {
    
    public boolean confirmPassword(String password, String confirmPassword){
        return password.equals(confirmPassword);
    }
    
    public String addUser(User u)throws SQLException{
        UserDAO dao = new UserDAO();
        dao.register(u);
        return "Cadastro realizado";
    };
}
