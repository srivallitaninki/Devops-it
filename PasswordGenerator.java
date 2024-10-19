package com.Project.Maven_apply;

import java.util.Random;

public class App {

    // Define possible characters for the password
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SYMBOLS = "!@#$%^&*()-_=+<>?";

    // Method to generate a random password
    public static String generatePassword(int length) {
        String allChars = UPPERCASE + LOWERCASE + DIGITS + SYMBOLS;  // Pool of characters
        Random random = new Random();
        StringBuilder password = new StringBuilder();

        // Ensure the password contains at least one uppercase, one lowercase, one digit, and one symbol
        password.append(UPPERCASE.charAt(random.nextInt(UPPERCASE.length())));
        password.append(LOWERCASE.charAt(random.nextInt(LOWERCASE.length())));
        password.append(DIGITS.charAt(random.nextInt(DIGITS.length())));
        password.append(SYMBOLS.charAt(random.nextInt(SYMBOLS.length())));

        // Generate the remaining characters randomly from the pool
        for (int i = 4; i < length; i++) {
            password.append(allChars.charAt(random.nextInt(allChars.length())));
        }

        // Shuffle the characters for better randomness
        return shufflePassword(password.toString());
    }

    // Method to shuffle the characters in the password for randomness
    private static String shufflePassword(String password) {
        char[] chars = password.toCharArray();
        Random random = new Random();
        for (int i = 0; i < chars.length; i++) {
            int j = random.nextInt(chars.length);
            // Swap characters at i and j
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        // Specify the desired password length
        int passwordLength = 12;  // Example: 12 characters long

        // Generate and display the random password
        String password = generatePassword(passwordLength);
        System.out.println("Generated password: " + password);
    }
}
