package com.seanshubin.mysql.connect.test;

import java.sql.*;

public class EntryPoint {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String host = args[0];
        String user = args[1];
        String password = args[2];
        String url = String.format("jdbc:mysql://%s?serverTimezone=UTC", host);
        String command = "show databases";
        Class.forName("com.mysql.jdbc.Driver");
        try (
                Connection connection = DriverManager.getConnection(url, user, password);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(command);
        ) {
            System.out.println(url);
            System.out.println(command);
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));
            }
        }
    }
}
