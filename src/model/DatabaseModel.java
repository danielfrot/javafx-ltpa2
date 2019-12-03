package model;

import java.sql.Connection;
import helper.Database;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class DatabaseModel {

    Connection connection;
    public DatabaseModel() {
    
        connection = Database.getInstance().getConnection();
        
        if(connection == null){
        
            System.out.println("Banco de dados nao encontrado");
            System.exit(0);
        }
        
    }

    
      
    
     
    
}
