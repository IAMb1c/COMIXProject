package ViewSubsystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import PersonalCollection.PersonalCollection;
import PersonalCollection.PersonalCollectionItems;
import PersonalCollectionController.ModifyComicValueAuthenticated;
import PersonalCollectionController.ModifyComicValueGraded;
import PersonalCollectionController.ModifyComicValueSigned;
import PersonalCollectionController.ModifyComicValueUserDefined;
import PersonalCollectionController.ModifyCommand;
import PersonalCollectionController.ModifyPersonalCollection;
import PersonalCollectionController.RedoAction;
import PersonalCollectionController.RedoCommand;
import PersonalCollectionController.RemoveComicFromCollection;
import PersonalCollectionController.UndoAction;
import PersonalCollectionController.UndoCommand;
import main.Comic;
import main.ConsoleColors;
import main.User;

public class PersonalCollectionView implements SystemViews {
    
    static String PCFile = "main/personalCollections.csv";
    private boolean view = true;
    public PersonalCollection allPC = new PersonalCollection();
    private User user;
    public PersonalCollection userPC;
    private List<ModifyCommand> undoStack;
    private List<ModifyCommand> redoStack;
    public ModifyPersonalCollection modifyInvoker;
    private RedoAction redoInvoker;
    private UndoAction undoInvoker;

    public PersonalCollectionView( User user ) {
        this.user = user;
        userPC = new PersonalCollection( user.getId() );
        allPC = getAllPC();
        undoStack = new java.util.Stack<ModifyCommand>();
        redoStack = new java.util.Stack<ModifyCommand>();
        modifyInvoker = new ModifyPersonalCollection( undoStack, userPC );
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
                String[] fields = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
                int uID = Integer.parseInt(fields[0]);
                Comic comic = new Comic( fields[1], fields[2],fields[3], fields[4], fields[5], fields[6], fields[7], fields[8], fields[9] );
               
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
                "   OR press enter to return to the main menu");
    }

    /* Print Personal Collection view Menu */
    public void printPCMenu() {
        System.out.println("Personal Collection View \n" +
                "   Do you want to view your personal collection or all personal collections? \n" +
                "   Enter 'P' for your personal collection \n" +
                "   OR press enter to view all personal collections");
    }

    public void printPCSubMenu() {
        System.out.println("Personal Collection View \n" +
                "   Type 'SORT' to sort \n" +
                "   Type 'Search to search' \n" );
    }

    /* Handle Personal Collection user interaction */
    public void handlePC() {
        // TODO handle searching and sorting somewhere in this method
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
                "   Add a comic to your own collection? Type 'AD'\n" +
                "   Remove a comic from your own collection? Type 'RM'\n" +
                "   Modify a comic value to be signed? Type 'SI'\n" +
                "   Modify a comic value to be authenticated? Type 'AU'\n" +
                "   Modify a comic value to be graded? Type 'GR'\n" +
                "   Praise a comic value? Type 'PR'\n" +
                "   Undo the last command? Type 'UNDO'\n" +
                "   Redo the last command? Type 'REDO'\n" +
                "   OR press enter to return to the main menu");
    }

    /* Get the series title, issue number and publisher from the user */
    public String[] getSIP() {
        String seriesTitle, issueNumber, publisher = ""; 
        System.out.println("Type in the series title here:");
        seriesTitle = getUserInput();
        System.out.println("Type in the issue number here:");
        issueNumber = getUserInput();
        System.out.println("Type in the publisher here:");
        publisher = getUserInput();
        String[] SIP = {seriesTitle, issueNumber, publisher};
        return SIP;
    }

    /* Handle Command user interaction */
    public void handleCommand() {
        printCommands();
        String userInput = getUserInput();
        switch( userInput ) {
            case "AD" -> {
                String[] SIP = getSIP();

                // find the comic in the database
                // TODO link the current database to the personal collection

            }
            case "RM" -> {
                String[] SIP = getSIP();

                // handle removing the comic from the personal collection
                // find the comic in the personal collection
                for( PersonalCollectionItems item : userPC.getPC() ) {
                    if( item.getComic().getSeriesTitle().strip().equals( SIP[0] ) && item.getComic().getIssueNum().equals( SIP[1] ) && item.getComic().getPublisher().substring(1, item.getComic().getPublisher().length()-1).equals( SIP[2] ) ) {
                        Comic comicToBeChanged = item.getComic();
                        userPC.removeItem(item);
                        // TODO still throwing an error of a null personal collection
                        RemoveComicFromCollection removeComicFromCollection = new RemoveComicFromCollection( comicToBeChanged, user.getId(), allPC );
                        modifyInvoker.execute(removeComicFromCollection);
                        System.out.println("Comic removed from your personal collection");
                    }
                }
            }
            case "SI" -> {
                String[] SIP = getSIP();
                for( PersonalCollectionItems item : userPC.getPC() ) {
                    if( item.getComic().getSeriesTitle().strip().equals( SIP[0] ) && item.getComic().getIssueNum().equals( SIP[1] ) && item.getComic().getPublisher().substring(1, item.getComic().getPublisher().length()-1).equals( SIP[2] ) ) {
                        Comic comicToBeChanged = item.getComic();
                        userPC.removeItem(item);
                        comicToBeChanged.addValue("Signed by: "+ comicToBeChanged.getCreator() );
                        ModifyComicValueSigned command = new ModifyComicValueSigned( comicToBeChanged, userPC.getUserID(), allPC );
                        modifyInvoker.execute(command);
                        System.out.println("Comic has been signed");
                    }
                }
            }
            case "AU" -> {
                String[] SIP = getSIP();
                for( PersonalCollectionItems item : userPC.getPC() ) {
                    if(  item.getComic().getSeriesTitle().strip().equals( SIP[0] ) && item.getComic().getIssueNum().equals( SIP[1] ) && item.getComic().getPublisher().substring(1, item.getComic().getPublisher().length()-1).equals( SIP[2] ) ) {
                        Comic comicToBeChanged = item.getComic();
                        userPC.removeItem(item);
                        comicToBeChanged.addValue("Authenticated by: "+ comicToBeChanged.getCreator() );
                        ModifyComicValueAuthenticated command = new ModifyComicValueAuthenticated( comicToBeChanged, userPC.getUserID(), userPC );
                        modifyInvoker.execute(command);
                        System.out.println("Comic has been authenticated");
                    }
                }
            }
            case "GR" -> {
                String[] SIP = getSIP();
                for( PersonalCollectionItems item : userPC.getPC() ) {
                    if( item.getComic().getSeriesTitle().strip().equals( SIP[0] ) && item.getComic().getIssueNum().equals( SIP[1] ) && item.getComic().getPublisher().substring(1, item.getComic().getPublisher().length()-1).equals( SIP[2] ) ) {
                        Comic comicToBeChanged = item.getComic();
                        userPC.removeItem(item);
                        int j = 0;
                        for( String s : item.getComic().getValue() ) {
                            if ( s.contains( "Grade: " ) ) {
                                // get the last 2 characters of the string
                                String grade = s.substring( s.length() - 2 );
                                // add to the grade value
                                if ( grade.contains( "10" ) ) {
                                    grade = "9";
                                }
                                int gradeValue = Integer.parseInt( grade ) + 1;
                                String newString = "Grade: " + gradeValue;
                                // modify the comic
                                comicToBeChanged.setSpecificValue( j, newString );
                            } else {
                                // modify the comic
                                comicToBeChanged.addValue( "Grade: 1" );
                            }
                            j++;
                        }
                        ModifyComicValueGraded command = new ModifyComicValueGraded( comicToBeChanged, userPC.getUserID(), userPC );
                        modifyInvoker.execute(command);
                        System.out.println("Comic grade has been updated");
                    }
                }
            }
            case "PR" -> {
                String[] SIP = getSIP();
                for( PersonalCollectionItems item : userPC.getPC() ) {
                    if( item.getComic().getSeriesTitle().strip().equals( SIP[0] ) && item.getComic().getIssueNum().equals( SIP[1] ) && item.getComic().getPublisher().substring(1, item.getComic().getPublisher().length()-1).equals( SIP[2] ) ) {
                        Comic comicToBeChanged = item.getComic();
                        userPC.removeItem(item);
                        comicToBeChanged.addValue("Praised by user "+ user.getName() );
                        ModifyComicValueUserDefined command = new ModifyComicValueUserDefined( comicToBeChanged, userPC.getUserID(), userPC );
                        modifyInvoker.execute(command);
                        System.out.println("You just praised a comic");
                    }
                }
            }
            case "UNDO" -> {
                try {
                    UndoCommand undoCommand = new UndoCommand( redoStack, undoStack, userPC );
                    undoInvoker = new UndoAction( redoStack, undoStack, undoCommand, userPC );
                    undoInvoker.execute();
                    System.out.println("Last command undone");
                } catch (Exception e) {
                    System.out.println("No commands to undo");
                }
                
            }
            case "REDO" -> {
                try {
                    RedoCommand redoCommand = new RedoCommand( redoStack, undoStack, userPC );
                    redoInvoker = new RedoAction( redoStack, undoStack, redoCommand, userPC );
                    redoInvoker.execute();
                    System.out.println("Last command redone");
                } catch (Exception e) {
                    System.out.println("No commands to redo");
                }
            }
            default -> {
                System.out.println("Invalid input");
                printCommands();
            }
        }
    }

    /** Displays the personal collection view and acts as a "main" */
    public boolean view() {
        // get all the personal collections
        allPC = getAllPC();
        userPC = getUserPC();

        while( view ) {
            
            printMainMenu();
            String userInput = getUserInput();
            switch( userInput ) {
                case "PC" -> {
                    handlePC();
                }
                case "C" -> {
                    // check if the user is logged in first
                    if( user.isLoggedIn == true ) {
                        handleCommand();
                    } else {
                        System.out.println("You must be logged in to use this feature");
                    }
                }
                default -> {
                    view = false;
                    return false;
                }
            }
        }
        return false;
    }
}