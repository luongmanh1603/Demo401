package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connecter {
    private final static String connectionString = "jdbc:mysql://localhost:3306/p401_jp";
    private final static String user = "root";
    private final static String pwd = "";

    private Connection conn;
    public Connecter() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        this.conn = DriverManager.getConnection(connectionString,user,pwd);
    }
    public Connection getConn(){
        return conn;
    }
}
