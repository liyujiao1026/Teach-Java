/*
Update data in MySQL
 */
package mysqldemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class MysqlDemo3_update {

    public static void main(String[] args) throws Exception {
        
        Connection con = DriverManager.getConnection("jdbc:mysql://edu-mysql.du.se:3306/db-yli", "yli", "vmqNxUkHR4vttV3h");

        String updateCarSQL = "UPDATE tb1 SET NAME=?, ADDRESS=?, PHONE =? WHERE ID=?";
        
        PreparedStatement preparedStatement = con.prepareStatement(updateCarSQL);
        
        preparedStatement.setString(1, "Yujiao");
        preparedStatement.setString(2, "China");
        preparedStatement.setString(3, "0722336356"); 
        preparedStatement.setString(4, "1"); 
        
        preparedStatement.executeUpdate();
        
        preparedStatement.close();
        con.close();

        
    }
    
}
