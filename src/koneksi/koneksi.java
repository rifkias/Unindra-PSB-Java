/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksi;
import java.sql.*;

/**
 *
 * @author ammar
 */
public class koneksi {
    private Connection mysqlconfig;
    public Connection connect (){
        try{
            String URI = "jdbc:mysql://localhost/psb_java";
            String user = "root";
            String password = "";
            
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            
            mysqlconfig = DriverManager.getConnection(URI,user,password);
        }catch(Exception e){
            System.err.println("Error Koneksi"+e.getMessage());
        }
        
        return mysqlconfig;
    }
}
