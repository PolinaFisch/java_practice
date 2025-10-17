package com.example.chatgpt.databases.lesson01;

import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class DatabaseUtilsTest {

    @Test
    void testConnectionNotNull() throws Exception {
        try (Connection conn = DatabaseUtils.getConnection()) {
            assertNotNull(conn, "Соединение с БД не должно быть null");
            assertFalse(conn.isClosed(), "Соединение должно быть открытым");
        }
    }
}
