package com.example.chatgpt.regex.task02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RegexUtilsTest {

    @Test
    void testValidPassword() {
        assertTrue(RegexUtils.isValidPassword("Abcdef1!"));
    }

    @Test
    void testTooShort() {
        assertFalse(RegexUtils.isValidPassword("Ab1!"));
    }

    @Test
    void testNoUppercase() {
        assertFalse(RegexUtils.isValidPassword("abcdef1!"));
    }

    @Test
    void testNoLowercase() {
        assertFalse(RegexUtils.isValidPassword("ABCDEF1!"));
    }

    @Test
    void testNoDigit() {
        assertFalse(RegexUtils.isValidPassword("Abcdefgh!"));
    }

    @Test
    void testNoSpecialChar() {
        assertFalse(RegexUtils.isValidPassword("Abcdefg1"));
    }

    @Test
    void testNullInput() {
        assertFalse(RegexUtils.isValidPassword(null));
    }

    @Test
    void validUsernames() {
        assertTrue(RegexUtils.isValidUsername("user_1"));
        assertTrue(RegexUtils.isValidUsername("JohnDoe99"));
        assertTrue(RegexUtils.isValidUsername("abcde"));
    }

    @Test
    void invalidUsernames() {
        assertFalse(RegexUtils.isValidUsername("123user")); // начинается с цифры
        assertFalse(RegexUtils.isValidUsername("ab")); // слишком короткое
        assertFalse(RegexUtils.isValidUsername("tooloooooooooooooooooongusername")); // слишком длинное
        assertFalse(RegexUtils.isValidUsername("user!name")); // недопустимый символ
        assertFalse(RegexUtils.isValidUsername("12345")); // нет буквы
        assertFalse(RegexUtils.isValidUsername("1Andrew"));  // начинается с буквы
        assertFalse(RegexUtils.isValidUsername("_1234")); // нет буквы
    }
}
