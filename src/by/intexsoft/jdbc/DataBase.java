package by.intexsoft.jdbc;

import java.sql.*;

/**
 * Created by Admin on 24.07.2015.
 */
public class DataBase {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/";

    static final String USER = "root";
    static final String PASS = "123456";

    public static void createDB() {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            stmt.execute("CREATE DATABASE IF NOT EXISTS javaTest");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public static void table(String name){
        Connection conn = null;
        Statement stmt = null;
        PreparedStatement p = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection("jdbc:mysql://localhost/javaTest", USER, PASS);
            stmt = conn.createStatement();
            String table = "CREATE TABLE IF NOT EXISTS " + name +
                    "(id INTEGER NOT NULL, " +
                    " first VARCHAR(255), " +
                    " last VARCHAR(255), " +
                    " age INTEGER, " +
                    " PRIMARY KEY ( id ))";
            stmt.execute(table);
            String insert = "INSERT INTO " + name +
                    "(id, first, last, age) VALUES"+
                    "(?,?,?,?)";
            p = conn.prepareStatement(insert);
            p.setInt(1,1);
            p.setString(2, "aaaaa");
            p.setString(3, "bbbbb");
            p.setInt(4,5);
            p.executeUpdate();

            String data = "SELECT id, first, last, age FROM " + name;
            ResultSet rs = stmt.executeQuery(data);

            while(rs.next()){
                int id  = rs.getInt("id");
                String first = rs.getString("first");
                String last = rs.getString("last");
                int age = rs.getInt("age");

                System.out.print("ID: " + id);
                System.out.print(", First: " + first);
                System.out.print(", Last: " + last);
                System.out.println(", Age: " + age);
                System.out.print(System.lineSeparator());
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
