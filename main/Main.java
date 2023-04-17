package main;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import PersonalCollection.PersonalCollection;
import ViewSubsystem.ComixDatabaseView;
import ViewSubsystem.PersonalCollectionView;

public class Main {

    static User user = new User();
    static String userFile = "main/users.csv";    
    static PersonalCollectionView pcv;
    static ComixDatabaseView cdv;
    
    /** Helper Method to grab the user's input */
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

    /** Prints the starting greeting for the user */
    private static void printMenu() {
        String userInput = "";
        System.out.println("Welcome to COMIX!\nPlease enter your name:");
        userInput = getUserInput();
        String temp = userInput;

        if( findUser( userInput ) && !userInput.equals("") ) {
            // handle the user's password
            while( true ) {
                System.out.println("Please enter your password:");
                userInput = getUserInput();
                if( userInput.equals( user.getPassword().substring(1, user.getPassword().length()-1) ) ) {
                    System.out.println("Password accepted");
                    user.isLoggedIn = true;
                    break;
                } else {
                    System.out.println("Password incorrect");
                }
            }
            System.out.println("Welcome back " + user.getName() + "!");
        } else {
            System.out.println("Welcome! \n Would You Like to Create an Account?: Y \n OR press enter to continue as a guest");
            userInput = getUserInput();
            if( userInput.equals("Y") ) {
                createNewUser();
            } else {
                System.out.println("Welcome Guest!");
                user.setUser(0, temp, " ");
                user.isLoggedIn = false;
            }
        }
        System.out.println("Please select an option:");
        printInfo();
    }

    /** Creates a new user and adds them to the user csv file */
    private static void createNewUser() {
        String userInput = "";
        String newUserName = "";
        String newPassword = "";
        String namingConventionsAreGood1 = "";

        // for getting the username
        while( true ) { 
            System.out.println("Please enter a username:");
            userInput = getUserInput();
            if( findUser( userInput ) ) {
                System.out.println("Username already exists");
            } else {
                System.out.println("Username created");
                newUserName = userInput;
                break;
            }
        } 
        // for getting the password 
        while( true ) {
            System.out.println("Please enter a password:");
            userInput = getUserInput();
            System.out.println("Please confirm your password:");
            String userInput2 = getUserInput();
            if( userInput.equals(userInput2) ) {
                System.out.println("Password created");
                newPassword = userInput2;
                user.isLoggedIn = true;
                break;
            } else {
                System.out.println("Passwords do not match");
            }
        }
        // grab the last id from the last row of the user csv file and add 1 to it for the new user
        try( BufferedReader br = new BufferedReader( new FileReader( userFile ) ) ) {
            String line = "";
            while( ( line = br.readLine() ) != null ) {
                String[] user = line.split(",");
                namingConventionsAreGood1 = user[0];
            }
            // ignore this really ugly code, I do not like quotes
            namingConventionsAreGood1 = namingConventionsAreGood1.substring(1, namingConventionsAreGood1.length()-1);
            namingConventionsAreGood1 = Integer.toString(Integer.parseInt(namingConventionsAreGood1) + 1);
        }
        catch( IOException e ) {
            System.out.println( "Error reading file: " + e.getMessage() );
        }
        // write the new user to the user csv file with the new id, username, and password
        try( BufferedWriter bw = new BufferedWriter( new FileWriter( userFile, true ) ) ) {
            user.setUser(Integer.parseInt(namingConventionsAreGood1), newUserName, newPassword);
            namingConventionsAreGood1 = "\"" + namingConventionsAreGood1 + "\"";
            newUserName = "\"" + newUserName + "\"";
            newPassword = "\"" + newPassword + "\"";
            bw.write( namingConventionsAreGood1 + "," + newUserName + "," + newPassword + "\n" );
            bw.close();
            user.isLoggedIn = true;
        }
        catch( IOException e ) {
            System.out.println( "Error writing to file: " + e.getMessage() );
        }
    }

    /** Prints the navigational items for the user */
    private static void printInfo() {
        System.out.println("'COMIX' - go to the COMIX database view \n 'VIEW' - go to the personal collection view \n 'EXIT' - exit the program");
    }

    /**
     * @param userInput The user's inputted username
     * @return true if the user is found and false otherwise
     * Searches the user csv file for the user's name and sets the user's name and id to the matching row in the file
     */
    private static boolean findUser( String userInput ) {
        String line = "";
        // get a user from the user csv file and set the user's name and id to the matching row in the file
        try( BufferedReader br = new BufferedReader( new FileReader( userFile ) ) ) {
            while( ( line = br.readLine() ) != null ) {
                String[] words = line.split(",");
                if( words[1].contains(userInput) ) {
                    user.setUser( Integer.parseInt(words[0].substring(1,words[0].length()-1)), words[1], words[2] );
                    return true;
                }
            }
        }
        catch( IOException e ) {
            System.out.println( "Error reading file: " + e.getMessage() );
        }
        return false;
    }
    
    /** The main method for the program */
    public static void main(String[] args) {
        boolean running = true;
        // for testing purposes so its easier to restart app
        while( running  ) { // remove this later
            boolean exit = false;
            
            printMenu();

            while( !exit ) {
                String userInput = getUserInput();
                switch( userInput ) {
                    case "COMIX" -> {
                        System.out.println("COMIX");
                        cdv = new ComixDatabaseView( user );
                        while( cdv.view() );
                    }
                    case "VIEW" -> {
                        System.out.println("VIEW");
                        pcv = new PersonalCollectionView( user );
                        while( pcv.view() );
                        continue;
                    }
                    case "EXIT" -> {
                        System.out.println("EXIT");
                        exit = true;
                        running = false; // remove this line later
                    }
                    case "R" -> { // remove this case later
                        System.out.println("R");
                        printInfo();
                        exit = true;
                    }

                    default -> {
                        System.out.println("Invalid input");
                        printInfo();
                    }
                }
            }
        }
    }
}