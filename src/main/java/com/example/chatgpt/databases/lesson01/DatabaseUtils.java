package com.example.chatgpt.databases.lesson01;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

@Slf4j
public class DatabaseUtils {

    private static final String APPLICATION_PROPERTIES_FILE = "src/main/java/com/example/chatgpt/databases/lesson01/application.properties";

    public static Connection getConnection() throws SQLException {
        Properties properties = new Properties();
        try (InputStream is = new FileInputStream(APPLICATION_PROPERTIES_FILE)) {
            properties.load(is);
        } catch (IOException ex) {
            log.error(ex.getMessage(), ex);
        }
        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        return DriverManager.getConnection(url, username, password);
    }

    public static void main(String[] args) {
        try (
                Connection connection = getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM bank_account")
        ) {
            while (resultSet.next()) {
                String accountId = resultSet.getString("accountId");
                String name = resultSet.getString("name");
                BigDecimal balance = resultSet.getBigDecimal("balance");
                System.out.printf("Account: %s, name: %s, balance: %s%n", accountId, name, balance);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
