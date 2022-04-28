package com.techelevator.tenmo.ui;

import com.techelevator.tenmo.model.UserCredentials;

import java.math.BigDecimal;
import java.util.Scanner;

public class UserInput {

    private static Scanner scanner = new Scanner(System.in);

    public static int printLoginMenu() {
        System.out.println();
        System.out.println("1: Register");
        System.out.println("2: Login");
        System.out.println("0: Exit");
        System.out.println();
        int loginChoice = promptForInt("Please choose an option: ");
        return loginChoice;
    }

    public static int mainMenuSelection() {
        int userOption = promptForInt("Please choose an option: ");
        return userOption;
    }

    public static UserCredentials promptForCredentials() {
        System.out.println("Please register a new account.");
        String username = promptForString("Username: ");
        String password = promptForString("Password: ");
        return new UserCredentials(username, password);
    }

    public static long sendBuckUserPicker(){
        int userId = promptForInt("Who would you like to send TE Bucks to?");
        return (long) userId;
    }

    public static BigDecimal amountToSend(){
        BigDecimal amountToSend = promptForBigDecimal("How much would you like to send? $");
        return amountToSend;
    }

    public static int promptForInt(String prompt) {
        System.out.print(prompt);
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
            }
        }
    }

    public static BigDecimal promptForBigDecimal(String prompt) {
        System.out.print(prompt);
        while (true) {
            try {
                return new BigDecimal(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a decimal number.");
            }
        }
    }

    public static void pause() {
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }

    public static String promptForString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

}

