package ViewSubsystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import PersonalCollection.PersonalCollection;
import PersonalCollection.PersonalCollectionItems;
import main.Comic;
import main.ConsoleColors;
import main.User;

public class PersonalCollectionView implements SystemViews {
    
    static String PCFile = "main/personalCollections.csv";
    private boolean view = true;
    private PersonalCollection allPC = new PersonalCollection();
    private User user;
    private PersonalCollection userPC;

    public PersonalCollectionView( User user ) {
        this.user = user;
        userPC = new PersonalCollection( user.getId() );
        allPC = getAllPC();
    }

    private PersonalCollection getAllPC() {
        try (BufferedReader reader = new BufferedReader(new FileReader(PCFile))) {
            String line;
            boolean isFirstLine = true; // Skip the header line
            PersonalCollection newPC = new PersonalCollection();
            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                String[] fields = line.split(",");
                int uID = Integer.parseInt(fields[0]);
                Comic comic = new Comic( fields[1], fields[2], fields[3], fields[4], fields[5], fields[6], fields[7], fields[8] );
               
                newPC.addTo(uID, comic);
                
            }
            return newPC;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* Get a users specific personal collection by matching the current id with the personal collection id */
    private PersonalCollection getUserPC() {
        PersonalCollection newPC = new PersonalCollection();
        for( PersonalCollectionItems item : allPC.getPC() ) {
            if( item.getId() == user.getId() ) {
                newPC.addTo( user.getId(), item.getComic() );
            }
        }
        return newPC;
    }

    /* Print Command Menu */
    public void printMainMenu() {
        System.out.println("Personal Collection View \n" +
                "   Do you want to view Personal Collections? Type 'PC' \n" +
                "   Do you want to execute a Command? Type 'C' \n" +
                "   OR press enter to view all personal collections");
    }

    /* Print Personal Collection view Menu */
    public void printPCMenu() {
        System.out.println("Personal Collection View \n" +
                "   Do you want to view your personal collection or all personal collections? \n" +
                "   Enter 'P' for your personal collection \n" +
                "   OR press enter to view all personal collections");
    }

    /* Handle Personal Collection user interaction */
    public void handlePC() {
        printPCMenu();
        String userInput = getUserInput();
        if( userInput.equals("P") ) {
            if( user.isLoggedIn == false ) {
                System.out.println("You must be logged in to view your own personal collection");
            } else {
                // view the user's personal collection
                try {
                    int totalComics = 0;
                    for( PersonalCollectionItems item : userPC.getPC() ) {
                        System.out.println(item);
                        totalComics++;
                    }
                    System.out.println(ConsoleColors.BLACK_BACKGROUND+ConsoleColors.WHITE+ "Total Comics in your collection: " + totalComics + ConsoleColors.RESET);
                } catch (Exception e) {
                    System.out.println("Oops! Something went wrong! \n Please restart the application and try again.");
                }
            }
        }
        else {
            // view all the personal collections
            try {
                for( PersonalCollectionItems item : allPC.getPC() ) {
                    System.out.println(item);
                }
            } catch (Exception e) {
                System.out.println("Oops! Something went wrong! \n Please restart the application and try again.");
            }
        }
    }

    /* Print the available commands for a user */
    public void printCommands() {
        System.out.println("Commands \n" +
                "   Add a comic to your own collection? Type 'AD <Issue Number'\n" +
                "   Remove a comic from your own collection? Type 'RM <Issue Number'\n" +
                "   Modify a comic value to be signed? Type 'SI <Issue Number'\n" +
                "   Modify a comic value to be authenticated? Type 'AU <Issue Number'\n" +
                "   Modify a comic value to be graded? Type 'GR <Issue Number'\n" +
                "   Praise a comic value? Type 'PR <Issue Number'\n" +
                "   Undo the last command? Type 'UNDO'\n" +
                "   Redo the last command? Type 'REDO'\n" +
                "   OR press enter to return to the main menu");
    }

    /** Displays the personal collection view and acts as a "main" */
    public boolean view() {
        // get all the personal collections
       
        while( view ) {
            allPC = getAllPC();
            userPC = getUserPC();
            printMainMenu();
            String userInput = getUserInput();
            switch( userInput ) {
                case "PC" -> {
                    handlePC();
                }
                case "C" -> {
                    System.out.println("Command handling here");
                }
                default -> {
                    System.out.println("Invalid input");
                    printMainMenu();
                }
            }
        }
        return false;
    }
}