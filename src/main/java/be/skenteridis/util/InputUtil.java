package be.skenteridis.util;

import java.util.Scanner;

public class InputUtil {
    private final Scanner scanner;
    
    public InputUtil() {
        scanner = new Scanner(System.in);
    }
    public String getValidString(String prompt) {
        String s;
        while (true) {
            System.out.print(prompt + ": ");
            s = scanner.nextLine();
            if(s.isEmpty()) System.out.println("Valid value required!");
            else break;
        }
        return s;
    }
    public double getDouble(String prompt) {
        double n;
        while (true) {
            try {
                n = Double.parseDouble(getValidString(prompt));
                if(n <= 0) System.out.println("Must be a positive number!");
                else break;
            } catch (NumberFormatException e) {
                System.out.println("Please input a valid number!");
            }
        }
        return n;
    }
    public int getInt(String prompt) {
        int n;
        while (true) {
            try {
                n = Integer.parseInt(getValidString(prompt));
                if(n <= 0) System.out.println("Must be a positive number!");
                else break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid whole number!");
            }
        }
        return n;
    }
    public void close() {
        scanner.close();
    }
}