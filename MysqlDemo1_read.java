/*
Show data from MySQL
 */
package mysqldemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.sql.ResultSet;
import java.sql.Statement;



public class MysqlDemo1_read {

    public static void main(String[] args) throws Exception {
        try { 
            
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://edu-mysql.du.se:3306/db-yli", "yli", "vmqNxUkHR4vttV3h");
            
            String sqlSelect = "SELECT * FROM tb1";     //WHERE ADDRESS = 'Falun'
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sqlSelect);
           
            
            /*
            String sqlSelect_para = "SELECT * FROM tb1 WHERE ADDRESS = ?";
            PreparedStatement prestmt =  con.prepareStatement(sqlSelect_para);
            prestmt.setString(1, "Falun");
            ResultSet rs = prestmt.executeQuery();
             */
            
            // result set 
            
            while (rs.next()) {
                System.out.println(rs.getInt("ID")     + ", " +
                                   rs.getString("NAME")   + ", " + 
                                   rs.getString("ADDRESS")+ ", " + 
                                   rs.getString("PHONE"));
              
            }
            
            rs.close();
            stmt.close();
            //prestmt.close();
            con.close();
        }catch(SQLException ex) {
           System.out.println(ex.getMessage());
        }
        
    }

}
    

