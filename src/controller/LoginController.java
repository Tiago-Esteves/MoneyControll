package controller;
/**
 * @author tiago
 */

import java.sql.SQLException;
import java.sql.Connection;
import util.ConnectionFactory;
import java.sql.PreparedStatement;
import model.Login;

public class LoginController {
    public void save(Login login){
        String sql = "INSERT INTO usuario(Login, Senha) VALUES (?, ?)";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            
            statement.setString(1,login.getLogin());
            statement.setString(2, login.getSenha());
            statement.execute();
            
        } catch(SQLException ex){
            throw new RuntimeException ("Erro ao criar a conta ", ex);
        } finally{
            ConnectionFactory.closeConnection(connection, statement);
        }
    }
}
