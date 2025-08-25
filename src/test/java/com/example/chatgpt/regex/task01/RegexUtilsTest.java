package com.example.chatgpt.regex.task01;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RegexUtilsTest {

    @Nested
    @DisplayName("isValidEmail")
    class EmailValidation {

        @ParameterizedTest
        @ValueSource(strings = {
                "user@example.com",
                "USER+tag@GMAIL.COM",
                "john.doe@sub.domain.org",
                "a_b.c-d%e+f@host.co"
        })
        void validEmails(String email) {
            assertTrue(RegexUtils.isValidEmail(email));
        }

        @ParameterizedTest
        @NullAndEmptySource
        @ValueSource(strings = {
                "   ",             // blank
                "no-at-symbol.com",
                "user@nodot",      // no TLD dot
                "user@.com",       // leading dot in domain
                "@domain.com",     // missing local part
                "user@domain.c",   // TLD too short
                "user@@domain.com"
        })
        void invalidEmails(String email) {
            assertFalse(RegexUtils.isValidEmail(email));
        }
    }

    @Nested
    @DisplayName("extractIntegers")
    class ExtractIntegers {

        @Test
        void extractsInOrderWithNegatives() {
            List<Integer> nums = RegexUtils.extractIntegers("A -7 b 0 c 12 d -345");
            assertEquals(List.of(-7, 0, 12, -345), nums);
        }

        @Test
        void returnsEmptyWhenNoNumbers() {
            assertTrue(RegexUtils.extractIntegers("no numbers here").isEmpty());
        }

        @Test
        void nullReturnsEmptyList() {
            assertTrue(RegexUtils.extractIntegers(null).isEmpty());
        }

        @Test
        void skipsOutOfRangeValues() {
            String s = "small 42 big 9999999999999 min " + ((long) Integer.MIN_VALUE - 1) + " ok 123";
            List<Integer> nums = RegexUtils.extractIntegers(s);
            assertEquals(List.of(42, 123), nums);
        }
    }

    @Test
    void testSimpleReplace() {
        String input = "Hello World";
        String expected = "Hello_World";
        assertEquals(expected, RegexUtils.replaceSpaces(input));
    }

    @Test
    void testMultipleSpaces() {
        String input = "a   b c";
        String expected = "a_b_c";
        assertEquals(expected, RegexUtils.replaceSpaces(input));
    }

    @Test
    void testEmptyString() {
        String input = "";
        String expected = "";
        assertEquals(expected, RegexUtils.replaceSpaces(input));
    }

    @Test
    void testNullInput() {
        assertNull(RegexUtils.replaceSpaces(null));
    }

    @Test
    void testTabsAndNewLines() {
        String input = "line1\tline2\nline3";
        String expected = "line1_line2_line3";
        assertEquals(expected, RegexUtils.replaceSpaces(input));
    }

}