package Databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBkoneksi {
    public static final String USERNAME = "root";
    public static final String PASSWORD = "";
    private static final String URL = "jdbc:mysql://localhost/restauran";

    public static Connection getKoneksi(){
        Connection connection;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            System.out.println("Terhubung ke Database");
        }catch (ClassNotFoundException EX){
            EX.printStackTrace();
            return null;
        }catch (SQLException E){
            E.printStackTrace();
            return null;
        }
        return connection;
    }
}
