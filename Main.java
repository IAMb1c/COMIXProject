package COMIXProject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String userName;
    static String id;
    static String userFile = "users.csv";
    
    // helper method to retrieve the user's input 
    private static String getUserInput() {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try {
          return input.readLine();
        }
        catch (Exception e) {
          System.out.println("Something went wrong!");
          return null;
        }
    }

    // prints out helpful information for the user
    private static void printMenu() {
        String userInput = "";
        System.out.println("Welcome to COMIX!\nPlease enter your name or GUEST to continue:");
        userInput = getUserInput();

        if( findUser(userInput) ) {
            System.out.println("Welcome back " + userName + "!");
        } else {
            System.out.println("Welcome!");
        }
        System.out.println("Please select an option:");
        printInfo();
    }

    private static void printInfo() {
        System.out.println("""
            "COMIX" - go to the COMIX database view \n
            "VIEW" - go to the personal collection view \n
            "EXIT - exit the program
                """);
    }

    private static boolean findUser( String userInput ) {
        String line = "";
        // get a user from the user csv file and set the user's name and id to the matching row in the file
        try( BufferedReader br = new BufferedReader( new FileReader( userFile ) ) ) {
            while( ( line = br.readLine() ) != null ) {
                String[] user = line.split(",");
                if( user[1].contains(userInput) ) {
                    userName = user[0];
                    id = user[1];
                    return true;
                } else {
                    return false;
                }
            }
        }
        catch( IOException e ) {
            System.out.println( "Error reading file: " + e.getMessage() );
        }
        return false;
    }
    
    public static void main(String[] args) {
        boolean exit = false;
        
        printMenu();

        while( !exit ) {
            String userInput = getUserInput();
            switch( userInput ) {
                case "COMIX" -> {
                    System.out.println("COMIX");
                    printInfo();
                }
                case "VIEW" -> {
                    System.out.println("VIEW");
                    printInfo();
                }
                case "EXIT" -> {
                    System.out.println("EXIT");
                    exit = true;
                }
                default -> {
                    System.out.println("Invalid input");
                    printInfo();
                }
            }
            // get user input
            // process user input
            // display results
        }
    }
}