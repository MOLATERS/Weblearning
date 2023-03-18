package com.lab2.lab2.DB;

import java.sql.*;

public class DBUtil {
    private final Connection con;
    private final Statement stmt;

    public DBUtil() {
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost/hit", "postgres", "0305");
            stmt = con.createStatement();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void close() throws SQLException {
        if (!stmt.isClosed()) {
            stmt.close();
        }
        if (!con.isClosed()) {
            con.close();
        }
    }

    public ResultSet executeQuery(String sql) {
        try {
            return stmt.executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void executeUpdate(String sql) {
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
