package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    static Connection con;

    public static Connection createConnection() {
        try {
            // ✅ Use the new MySQL driver (cj)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // ✅ Database details
            String user = "root";  // change if your MySQL username is different
            String pass = "root";  // change if your MySQL password is different
            String url = "jdbc:mysql://localhost:3306/student?autoReconnect=true&useSSL=false";

            // ✅ Create connection
            con = DriverManager.getConnection(url, user, pass);
            System.out.println("✅ Database connected successfully!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return con;
    }
}
