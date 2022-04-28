package com.techelevator.tenmo.services;

import com.techelevator.tenmo.model.AuthenticatedUser;
import com.techelevator.tenmo.model.User;
import com.techelevator.tenmo.model.UserCredentials;
import com.techelevator.tenmo.ui.UserInput;
import com.techelevator.tenmo.ui.UserOutput;

import java.math.BigDecimal;

public class UIServices {

    private static final String API_BASE_URL = "http://localhost:8080/";

    private final AuthenticationService authenticationService = new AuthenticationService(API_BASE_URL);
    private final AccountServices accountServices = new AccountServices();
    private final UserServices userServices = new UserServices();
    private final TransferServices transferServices = new TransferServices();

    private AuthenticatedUser currentUser;

    public void run() {
        UserOutput.printGreeting();
        loginMenu();
        if (currentUser != null) {
            mainMenu();
        }
    }
    private void loginMenu() {
        int menuSelection = -1;
        while (menuSelection != 0 && currentUser == null) {
            menuSelection = UserInput.printLoginMenu();
            if (menuSelection == 1) {
                handleRegister();
            } else if (menuSelection == 2) {
                handleLogin();
            } else if (menuSelection != 0) {
                UserOutput.printInvalidSelection();
                UserInput.pause();
            }
        }
    }

    private void handleRegister() {
        UserOutput.newUserWelcome();
        UserCredentials credentials = UserInput.promptForCredentials();
        if (authenticationService.register(credentials)) {
            UserOutput.printSuccess();
        } else {
            UserOutput.printErrorMessage();
        }
    }

    private void handleLogin() {
        UserOutput.returningUserWelcome();
        UserCredentials credentials = UserInput.promptForCredentials();
        currentUser = authenticationService.login(credentials);
        if (currentUser == null) {
            UserOutput.printErrorMessage();
        } else {
            accountServices.setAuthToken(currentUser.getToken());
        }
    }

    private void mainMenu() {
        int menuSelection = -1;
        while (menuSelection != 0) {
            UserOutput.printMainMenu();
            menuSelection = UserInput.mainMenuSelection();
            switch (menuSelection) {
                case 1:
                    viewCurrentBalance();
                    break;
                case 2:
                    viewTransferHistory();
                    break;
                case 3:
                    viewPendingRequests();
                    break;
                case 4:
//                    sendBucks();
                    UserOutput.displayAllUsers(userServices.listUsers());
                    break;
                case 5:
                    requestBucks();
                    break;
                case 0:
                    continue;
                default:
                    UserOutput.printInvalidSelection();
                    UserInput.pause();
            }
        }
    }

    private void viewCurrentBalance()
    {
        UserOutput.showBalance();
        System.out.println(accountServices.getBalance());
    }

    private void viewTransferHistory() {
        // TODO Auto-generated method stub

    }

    private void viewPendingRequests() {
        // TODO Auto-generated method stub

    }

/*    private void sendBucks() {
        UserOutput.displayAllUsers(userServices.listUsers());
        long memberToSendToId = UserInput.sendBuckUserPicker();
        BigDecimal amountToSend = UserInput.amountToSend();
        transferServices.sendBucks(memberToSendToId, amountToSend);
        // TODO Auto-generated method stub

    }*/

    private void requestBucks() {
        UserOutput.displayAllUsers(userServices.listUsers());
        // TODO Auto-generated method stub

    }
}
