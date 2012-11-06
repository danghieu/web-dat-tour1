package dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectionService {

    public static Connection getConnection() throws Exception {
        /*String url = "jdbc:mysql://localhost:3306/user";
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, "root", "ndk1991");
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");*/
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
        String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
   "databaseName=UserLogin;user=sa;password=ndk1991;";
Connection con = DriverManager.getConnection(connectionUrl);
        return con;
    }
}
