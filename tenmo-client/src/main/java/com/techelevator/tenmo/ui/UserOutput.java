package com.techelevator.tenmo.ui;
import com.techelevator.tenmo.styles.*;
import com.techelevator.tenmo.model.User;

public class UserOutput {

    public static void printGreeting() {
        System.out.println("*********************");
        System.out.println("* Welcome to TEnmo! *");
        System.out.println("*********************");
    }

    public static void printMainMenu() {
        System.out.println();
        System.out.println(Colors.RED_BOLD_BRIGHT + "1:" + Colors.RESET + " View your current balance");
        System.out.println(Colors.RED_BOLD_BRIGHT + "2:" + Colors.RESET + " View your past transfers");
        System.out.println(Colors.RED_BOLD_BRIGHT + "3:" + Colors.RESET + " View your pending requests");
        System.out.println(Colors.RED_BOLD_BRIGHT + "4:" + Colors.RESET + " Send TE bucks");
        System.out.println(Colors.RED_BOLD_BRIGHT + "5:" + Colors.RESET + " Request TE bucks");
        System.out.println(Colors.RED_BOLD_BRIGHT + "0:" + Colors.RESET + " " + Colors.RED_UNDERLINED + "Exit" + Colors.RESET);
        System.out.println();
    }

    public static void printInvalidSelection(){
        System.out.println("Invalid Selection");
    }

    public static void printSuccess(){
        System.out.println("Registration successful. You can now login.");
    }

    public static void printErrorMessage() {
        System.out.println("An error occurred. Check the log for details.");
    }

    public static void showBalance(){
        System.out.print("Your current balance is: " + Colors.GREEN + "$");
    }

    public static void printUser(User user){
        String template = "%-20s\n" +
                "%5f";

        System.out.printf(template
                ,user.getUsername()
                ,user.getId());
    }

    public static void displayAllUsers(User[] users){
        for(User user: users){
            printUser(user);
        }
    }



}
