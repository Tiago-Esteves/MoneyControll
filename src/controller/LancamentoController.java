package controller;
/**
 *
 * @author tiago
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import model.Lancamento;
import util.ConnectionFactory;

public class LancamentoController {
    
    public void save(Lancamento lancamento){
        String sql = "INSERT INTO lancamento (ideUsuario, ideTipo, Descricao, DatLancamento, QtdLancamento) VALUES (?, ?, ?, ?, ?)";
                    
        Connection connection = null;
        PreparedStatement statement = null;
        
        try{
            //Estabelecendo conexão 
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            
            statement.setInt(1, lancamento.getIdeUsuario());
            statement.setInt(2, lancamento.getIdeTipo());
            statement.setString(3, lancamento.getDescricao());
            statement.setDate(4, new Date(lancamento.getData().getTime()));
            statement.setFloat(5, lancamento.getValor());
            statement.execute();
            
        } catch(SQLException ex){
            throw new RuntimeException ("Erro ao realizar o lançamento", ex);
        } finally{
            ConnectionFactory.closeConnection(connection, statement);
        }
    }
    
    public void update (Lancamento lancamento){
        String sql = "UPDATE lancamento SET ideTipo = ?, Descricao = ?, QtdLancamento";
        Connection connection = null;
        PreparedStatement statement = null;
        
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            
            statement.setInt(1, lancamento.getIdeTipo());
            statement.setString(2, lancamento.getDescricao());
            statement.setFloat(3, lancamento.getValor());
                    
        } 
        catch(SQLException ex){
            throw new RuntimeException ("Erro ao atualizar o lançamento", ex);
                    } 
        finally{ConnectionFactory.closeConnection(connection, statement);
        }
    }
    
    public void delete (int ideObjeto){
        String sql = "DELETE FROM lancamento WHERE ideObjeto = ?" ;
        Connection connection = null;
        PreparedStatement statement = null;
        
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            
            statement.setInt(1, ideObjeto);
        } catch(SQLException ex){
            throw new RuntimeException("Erro ao deletar lançamento" + ex.getMessage(), ex);
        } finally{
            ConnectionFactory.closeConnection(connection);
        }
    }
    
    public List<Lancamento> getAll(){
        String sql = "SELECT * FROM lancamento";
        List<Lancamento> lancamentos = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            
            while(resultSet.next()){
                Lancamento lancamento = new Lancamento();
                lancamento.setIdeUsuario(resultSet.getInt("ideUsuario"));
                lancamento.setIdeObjeto(resultSet.getInt("ideObjeto"));
                lancamento.setDescricao(resultSet.getString("Descricao"));
                lancamento.setData(resultSet.getDate("DatLancamento"));
                lancamento.setIdeTipo(resultSet.getInt("ideTipo"));
                lancamento.setValor(resultSet.getFloat("QtdLancamento"));
                
                
                lancamentos.add(lancamento);
            }
            
        } catch(SQLException ex){
            throw new RuntimeException("Erro ao buscar lançamentos" + ex.getMessage(), ex);
        } finally{
            ConnectionFactory.closeConnection(connection, statement, resultSet);
        }

        return lancamentos;
        }
    
    
}
