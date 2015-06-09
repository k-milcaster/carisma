package carismaserver.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.UnknownHostException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author K-MiL Caster
 */
public class DatabaseConnection {

    private static Connection connection;
    private String host;
    private int port;
    private String nama;
    private String user;
    private String pass;

    public DatabaseConnection(String host, int port, String nama, String user, String pass) {
        this.host = host;
        this.port = port;
        this.nama = nama;
        this.user = user;
        this.pass = pass;
    }
    
    public boolean testConnection() {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            connection = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+nama+"", user, pass);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public static Connection getConnection() {
        Scanner s = null;
        try {
            s = new Scanner(new File("D:/carismaserverconfig"));
        } catch (FileNotFoundException ex) {
        }
        ArrayList<String> list = new ArrayList<String>();
        while (s.hasNext()) {
            list.add(s.next());
        }
        s.close();
        if (connection == null) {
            try {
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                if(list.get(4).equals("null")){
                    connection = DriverManager.getConnection("jdbc:mysql://"+list.get(0)+":"+list.get(1)+"/"+list.get(2)+"", list.get(3), "");
                }
                else{
                    connection = DriverManager.getConnection("jdbc:mysql://"+list.get(0)+":"+list.get(1)+"/"+list.get(2)+"", list.get(3), list.get(4));
                }
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("kenak deh");
            }
        }
        return connection;
    }
}
