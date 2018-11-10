/*
Insert data into MySQL
 */
package mysqldemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


/**
 *
 * @author Yujiao
 */
public class MysqlDemo2_insert {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
       
        Connection con = DriverManager.getConnection("jdbc:mysql://edu-mysql.du.se:3306/db-yli","yli","vmqNxUkHR4vttV3h");
        
        String insertCarSQL = "INSERT INTO tb1 (ID, NAME, ADDRESS, PHONE) VALUES (?,?,?,?)";

        PreparedStatement preparedStatement = con.prepareStatement(insertCarSQL);
        
        
        preparedStatement.setInt(1, 8);
        preparedStatement.setString(2, "JamesBond");
        preparedStatement.setString(3, "USA"); 
        preparedStatement.setString(4, "0722336356"); 
        preparedStatement.executeUpdate();
        
        /*
        preparedStatement.setInt(1, 49);
        preparedStatement.setString(2, "JamesBond");
        preparedStatement.setString(3, "USA"); 
        preparedStatement.setString(4, "0722336356"); 
        preparedStatement.executeUpdate();
        */
        
        preparedStatement.close();
        con.close();

        
    }
    
}
