package learn.foraging.ui;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ConsoleIOTest {

    @Test
    void print() {
    }

    @Test
    void println() {
    }

    @Test
    void printf() {
    }

    @Test
    void readString() {
    }

    @Test
    void readRequiredStringSpaces() {
        boolean isWord = false;
        isWord = "brian hacker logan".matches("[a-zA-Z ]+");
        assertTrue(isWord);
    }
    @Test
    void readRequiredStringPunctuation() {
        boolean isWord = false;
        isWord = "brian , logan".matches("[a-zA-Z ]+");
        assertFalse(isWord);
    }
    @Test
    void readRequiredStringNumbers() {
        boolean isWord = false;
        isWord = "brian 3 logan".matches("[a-zA-Z ]+");
        assertFalse(isWord);
    }
    @Test
    void readRequiredStringBlank() {
        boolean isWord = false;
        isWord = "".matches("[a-zA-Z ]+");
        assertFalse(isWord);
    }

    @Test
    void readDouble() {
    }

    @Test
    void testReadDouble() {
    }

    @Test
    void readInt() {
    }

    @Test
    void testReadInt() {
    }

    @Test
    void readBoolean() {
    }

    @Test
    void readLocalDate() {
    }

    @Test
    void readBigDecimal() {
    }

    @Test
    void testReadBigDecimal() {
    }
}