
package model;

import helper.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CRUD {
    ObservableList<Funcionario> funcionarios = null;
    Connection connection = null;
    public CRUD() {
        funcionarios = FXCollections.observableArrayList();
        connection = Database.getInstance().getConnection();
        
        if(connection == null){
            System.out.println("Banco de dados nao encontrado");
            System.exit(0);
        }
    }
    
    public boolean login(String cpf,String senha) throws SQLException{
        Database database = Database.getInstance();
        database.open();
        PreparedStatement ps =null;
        ResultSet rs = null;
        String sql = "select * from usuarios where cpf=? and senha=?";
           
        try{
            ps = connection.prepareStatement(sql);
            ps.setString(1,"admin");
            ps.setString(2,"123");
            rs = ps.executeQuery();
            
            if(rs.next()){
            return true;
            }
        }catch(Exception ex){
            
            System.out.println(ex.getMessage());
            return false;
        }finally{
            Database.getInstance().closeConnection();
            ps.close();
            rs.close();
        };
        return false;
    }
    
    public ObservableList<Funcionario> SELCT() throws SQLException{

        Database database = Database.getInstance();
        database.open();
        connection = Database.getInstance().getConnection();
        
        PreparedStatement ps =null;
        ResultSet rs = null;
        String sql = "select * from funcionario";
           
        try{
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Funcionario funcionario = new Funcionario();
               funcionario.setIdFuncionario(rs.getInt("idFuncionario"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setRg(rs.getString("rg"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setNascimento(rs.getString("nascimento"));
                funcionario.setTelefone(rs.getString("telefone"));
                funcionario.setSexo(rs.getString("sexo"));
                funcionario.setEstadoCivil(rs.getString("estadoCivil"));
                funcionario.setRua(rs.getString("rua"));
                funcionario.setNumCasa(rs.getString("numCasa"));
                funcionario.setBairro(rs.getString("bairro"));
                funcionario.setCidade(rs.getString("cidade"));
                funcionario.setMatricula(rs.getString("matricula"));
                funcionario.setCargo(rs.getString("cargo"));
                funcionario.setSetor(rs.getString("setor"));
               funcionarios.add(funcionario);
            }
        }catch(Exception ex){
            
            System.out.println(ex.getMessage());
           
        }finally{
            Database.getInstance().closeConnection();
            ps.close();
            rs.close();
        
        };
        
       
        
        return funcionarios;
    
    
    }
    
    
    public void INSERT(Funcionario funcionario) throws SQLException{
    
        Database database = Database.getInstance();
        database.open();
        try {
		PreparedStatement stat = connection.prepareStatement(
				"insert into funcionario values(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		
		
		stat.setString(1, funcionario.getNome());
                stat.setString(2, funcionario.getRg());
                stat.setString(3, funcionario.getCpf());
                stat.setString(4, funcionario.getNascimento());
                stat.setString(5, funcionario.getTelefone());
                stat.setString(6, funcionario.getSexo());
                stat.setString(7, funcionario.getEstadoCivil());
                stat.setString(8, funcionario.getRua());
                stat.setString(9, funcionario.getNumCasa());
                stat.setString(10, funcionario.getBairro());
                stat.setString(11, funcionario.getCidade());
                stat.setString(12, funcionario.getMatricula());
                stat.setString(13, funcionario.getCargo());
                stat.setString(14, funcionario.getSetor());
		
                stat.executeUpdate();
		
		stat.close();
        } catch (SQLException ex) {
            System.out.println("FALHA OCORREU AQUI NO INSERT DO CRUD");
            //Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            connection.close();
        }
    }
    
    public boolean DELET(int id) throws SQLException{
    Database database = Database.getInstance();
        database.open();
        connection = Database.getInstance().getConnection();
        Statement stat;
        try {
            stat = connection.createStatement();
            stat.executeUpdate("delete from funcionario where idFuncionario = " + id );
		stat.close();
                connection.close();
                return true;
               
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            connection.close();
            return  false;
        }
		
        
    
    }
    
    
    public void UPDATE(Funcionario funcionario){
    
    Database database = Database.getInstance();
        database.open();
		
        try {
            Statement stat = connection.createStatement();
            stat.executeUpdate("update funcionario set nome = '" + funcionario.getNome() + "' " 
                    +",rg  = '" + funcionario.getRg() +"' " +
                    ",cpf = '" + funcionario.getCpf() +"' " +
                    ",nascimento = '" + funcionario.getNascimento() +"' " +
                    ",telefone = '" + funcionario.getTelefone() +"' " +
                    ",sexo = '" + funcionario.getSexo() +"' " +
                    ",estadoCivil = '" + funcionario.getEstadoCivil() +"' " +
                    ",rua = '" + funcionario.getRua() +"' " +
                    ",numCasa = '" + funcionario.getNumCasa() +"' " +
                    ",bairro = '" + funcionario.getBairro() +"' " +
                    ",cidade = '" + funcionario.getCidade() +"' " +
                    ",matricula = '" + funcionario.getMatricula() +"' " +
                    ",cargo = '" + funcionario.getCargo()+"' " +
                    ",setor = '" + funcionario.getSetor() +"' " +
                    " where idFuncionario = " + funcionario.getIdFuncionario());
            
            
            stat.close();
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
