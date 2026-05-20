package poe2iprg5121;

import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * Main application class for QuickChat.
 * 
 * @author lab_services_student
 */
public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Login login = new Login();

        ArrayList<Message> sentMessages = new ArrayList<>();

        // =========================
        // REGISTRATION
        // =========================

        System.out.print("Enter first name: ");
        String firstName = input.nextLine();

        System.out.print("Enter last name: ");
        String lastName = input.nextLine();

        // Username Validation
        boolean validUsername = false;

        while (!validUsername) {

            System.out.print("Enter username: ");
            String username = input.nextLine();

            login.setUsername(username);

            if (login.checkUserName()) {

                System.out.println("Username successfully captured.");
                validUsername = true;

            } else {

                System.out.println("""
                        Username is not correctly formatted;
                        please ensure that your username contains
                        an underscore and is no more than five
                        characters in length.
                        """);
            }
        }

        // Password Validation
        boolean validPassword = false;

        while (!validPassword) {

            System.out.print("Enter password: ");
            String password = input.nextLine();

            login.setPassword(password);

            if (login.checkPasswordComplexity()) {

                System.out.println("Password successfully captured.");
                validPassword = true;

            } else {

                System.out.println("""
                        Password is not correctly formatted;
                        please ensure that the password contains
                        at least eight characters, a capital letter,
                        a number, and a special character.
                        """);
            }
        }

        // Cellphone Validation
        boolean validPhone = false;

        while (!validPhone) {

            System.out.print("Enter cellphone number: ");
            String phone = input.nextLine();

            login.setCellPhone(phone);

            if (login.checkCellPhoneNumber()) {

                System.out.println("Cell phone number successfully added.");
                validPhone = true;

            } else {

                System.out.println("""
                        Cell phone number incorrectly formatted
                        or does not contain international code.
                        """);
            }
        }

        // Registration Status
        System.out.println("\n" + login.registerUser());

        // =========================
        // LOGIN
        // =========================

        boolean loggedIn = false;

        while (!loggedIn) {

            System.out.println("\n===== LOGIN =====");

            System.out.print("Enter username: ");
            String enteredUsername = input.nextLine();

            System.out.print("Enter password: ");
            String enteredPassword = input.nextLine();

            loggedIn = login.loginUser(
                    enteredUsername,
                    enteredPassword
            );

            System.out.println(
                    login.returnLoginStatus(
                            firstName,
                            lastName,
                            loggedIn
                    )
            );
        }

        // =========================
        // QUICKCHAT STARTS HERE
        // =========================

        JOptionPane.showMessageDialog(
                null,
                "Welcome to QuickChat."
        );

        int totalMessages = Integer.parseInt(
                JOptionPane.showInputDialog(
                        "How many messages would you like to send?"
                )
        );

        // =========================
        // MENU LOOP
        // =========================

        for (int i = 0; i < totalMessages;) {

            String menu = JOptionPane.showInputDialog("""
                    
                    MENU
                    
                    1. Send Messages
                    2. Show recently sent messages
                    3. Quit
                    """);

            switch (menu) {

                case "1":

                    Message msg = new Message();

                    msg.enterDetails(i);

                    String action = msg.sentMessage();

                    if (action.equals("send")) {

                        sentMessages.add(msg);

                        JOptionPane.showMessageDialog(
                                null,
                                msg.printMessages()
                        );

                        i++;

                    } else if (action.equals("store")) {

                        MessageStore.storeMessage(msg);

                        JOptionPane.showMessageDialog(
                                null,
                                "Message stored successfully."
                        );

                        i++;
                    }

                    break;

                case "2":

                    JOptionPane.showMessageDialog(
                            null,
                            "Coming Soon."
                    );

                    break;

                case "3":

                    JOptionPane.showMessageDialog(
                            null,
                            "Goodbye."
                    );

                    System.exit(0);

                    break;

                default:

                    JOptionPane.showMessageDialog(
                            null,
                            "Invalid option."
                    );
            }
        }

        JOptionPane.showMessageDialog(
                null,
                "Total messages sent: "
                + sentMessages.size()
        );
    }
}