package carismajadwaldokter.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author K-MiL Caster
 */
public class DatabaseConnection {
    private static Connection connection;
    public static Connection getConnection(String host, int port, String user, String pass) {
       if(connection == null){
            try {
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                connection = DriverManager.getConnection("jdbc:mysql://"+host+":3306/carisma",""+user+"",""+pass+"");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Username or Password not valid \n Can't Connect to server");           
            }
       }
        return connection;
    }
}
