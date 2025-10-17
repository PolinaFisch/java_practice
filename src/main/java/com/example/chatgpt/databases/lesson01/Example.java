package com.example.chatgpt.databases.lesson01;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Example {

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/testdb", "postgres", "postgres");
        Statement statement = connection.createStatement();
        int rowsAffected = statement.executeUpdate("""
                INSERT INTO public.bank_account("accountId", name, balance)
                	VALUES ('1111222233335555', 'Sara', 100000.0);
                """);
        System.out.println("Rows affected: " + rowsAffected);
        ResultSet resultSet = statement.executeQuery("SELECT * FROM bank_account");
        while (resultSet.next()) {
            String accountId = resultSet.getString("accountId");
            String name = resultSet.getString("name");
            BigDecimal balance = resultSet.getBigDecimal("balance");
            System.out.printf("Account: %s, name: %s, balance: %s%n", accountId, name, balance);
        }
        statement.close();
        connection.close();
    }
}
