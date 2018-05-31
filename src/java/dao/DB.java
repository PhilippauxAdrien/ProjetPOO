package dao;
import java.sql.*;
public class DB {
    
        static String driverClass = "com.mysql.jdbc.Driver"; 
        static String urlDatabase = "jdbc:mysql://localhost:3306/projetpoo"; 
        static String user = "root";
        static String pwd = "root";
        
public static Connection getCon(){
      
	Connection con=null;
	try{
                Class.forName(driverClass);
		con = DriverManager.getConnection(urlDatabase, user, pwd);
	}catch(Exception ex){
            System.out.println("Erreur de connexion : " + ex.getMessage());
        }
	return con;
}
}
