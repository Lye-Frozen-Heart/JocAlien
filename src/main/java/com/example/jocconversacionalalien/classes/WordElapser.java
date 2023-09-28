package com.example.jocconversacionalalien.classes;

public class WordElapser {
    public static void writeWordWithTimeDelay(String word, int timeDelayInMillis) {
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);

            // Output the current character to the console
            System.out.print(currentChar);

            // Introduce a time delay
            try {
                Thread.sleep(timeDelayInMillis);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Print a new line at the end
        System.out.println();

    }
}
