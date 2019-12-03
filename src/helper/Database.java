
package helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static Database instance = null;
    private  Connection connection = null;
    
    private Database() {
    
         try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:teste.db");
        } catch (Exception ex) {
            System.out.println("JDBC nao instalado"+ex.getMessage());  
        }     
    }
    
    public static Database getInstance() {
		
		if (instance == null) {
			instance = new Database();
		}	
		return instance;
	}
    
     public  void open(){
    
    try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:teste.db");
        } catch (Exception ex) {
            System.out.println("JDBC nao instalado"+ex.getMessage());  
        } 
    }
    
     public boolean isConnected(){
    
        try{
            return !connection.isClosed();
        
        }catch(Exception ex){

            System.out.println(ex.getMessage());
            return false;
        }    
    }
    
    public Connection getConnection(){
    
	return this.connection;
    }
    
    public void closeConnection() throws SQLException{
        
        this.connection.close();
    }
}
