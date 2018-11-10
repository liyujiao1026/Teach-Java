/*
Delete data in MySQL
 */
package mysqldemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MysqlDemo4_delete {

    public static void main(String[] args) throws Exception {
    
        Connection con = DriverManager.getConnection("jdbc:mysql://edu-mysql.du.se:3306/db-yli", "yli", "vmqNxUkHR4vttV3h");

        String deleteSQL = "DELETE FROM tb1 WHERE ID = ? AND  NAME= ?";
        PreparedStatement preparedStatement = con.prepareStatement(deleteSQL);
        preparedStatement.setInt(1, 8);
        preparedStatement.setString(2, "JamesBond");
         
        preparedStatement.executeUpdate();
         
        preparedStatement.close();
        con.close();

        
    }
    
}
