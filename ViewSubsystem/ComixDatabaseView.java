package ViewSubsystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import PersonalCollection.PersonalCollection;
import main.Comic;
import main.User;

public class ComixDatabaseView implements SystemViews {

    static String defaultCSV = "main/comics.csv";
    private boolean view = true;
    private User user;
    private PersonalCollection allPC;
    private PersonalCollection userPC;
    private List<Comic> database;

    public ComixDatabaseView( User user, PersonalCollection allPC, PersonalCollection userPC, List<Comic> database ) {
        this.user = user;
        this.allPC = allPC;
        this.userPC = userPC;
        this.database = database;
    }


    // return the contents of the database file that has comic book information
    // Series,Issue,"Full Title","Variant Description",Publisher,"Release Date",Format,"Added Date",Creators
    public String readDatabase( String filename ) {
        try( BufferedReader br = new BufferedReader( new FileReader( filename ) ) ) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while( line != null ) {
                sb.append( line );
                sb.append( System.lineSeparator() );
                line = br.readLine();
            }

            br.close();
            return sb.toString();
        }
        catch( IOException e ) {
            System.out.println( "Error reading file: " + e.getMessage() );
            return "file not found";
        }
    }

    /* Print main menu of commands */
    public void printMainMenu() {
        System.out.println("Comic Database View \n" +
                "   Do you want to view the entire database? Type 'D' \n" +
                "   Do you want to execute a Command? Type 'C' \n" +
                "   Do you want to search the database? Type 'SE' \n" +
                "   Do you want to sort the database? Type 'SO' \n" +
                "   Do you want to import a database? Type 'I' \n" +
                "   Do you want to export the database? Type 'E' \n");
    }
  
    /* print the menu for commands */
    private void printCommandMenu() {
        System.out.println("Commands \n" +
                "   Do you want to add a comic to your collection? Type 'A' \n" +
                "   Do you want to remove a comic from your collection? Type 'R' \n" +
                "   Or press enter to leave this menu");
    }

    /* Simple helper method */
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

    /* handling the command menu */
    private void handleCommand() {
        printCommandMenu();
        String userInput = getUserInput();
        switch( userInput ) {
            case "A" -> {
                String[] SIP = getSIP();
                // Comic comic = database.getComic( SIP[0], SIP[1], SIP[2] );
                // if( comic != null ) {
                //     userPC.addTo( user.getId(), comic );
                // }
                // else {
                //     System.out.println( "Comic not found" );
                // }
                System.out.println( "Adding comic to personal collection" );
            }
            case "R" -> {
                String[] SIP = getSIP();
                
                // Comic comic = userPC.getComic( SIP[0], SIP[1], SIP[2] );
                // if( comic != null ) {
                //     userPC.removeFrom( user.getId(), comic );
                // }
                // else {
                //     System.out.println( "Comic not found" );
                // }

                System.out.println( "Removing comic from personal collection" );
            }
            default -> System.out.println( "Leaving sub-view" );
        }
    }

    private void printSearchMenu() {
        System.out.println("Search \n" +
                "   Do you want to search precisely? Type 'P' \n" +
                "   Do you want to search vaguely? Type 'V' \n" +
                "   Or press enter to leave this menu");
    }

    private void handleSearch() {
        printSearchMenu();
        String userInput = getUserInput();
        switch( userInput ) {
            case "P" -> {
                System.out.println("Enter exact search Parameters here: ");
                String[] SIP = getSIP();
                System.out.println( "Searching precisely" );
            }
            case "V" -> {
                System.out.println("Enter search Parameters here: ");
                userInput = getUserInput();
                System.out.println( "Searching vaguely" );
            }
            default -> System.out.println( "Leaving sub-view" );
        }
    }

    private void printSortMenu() {
        System.out.println("Sort \n" +
                "   Do you want to sort by series title? Type 'ST' \n" +
                "   Do you want to sort by issue number? Type 'IN' \n" +
                "   Do you want to sort by publisher? Type 'P' \n" +
                "   Do you want to sort by publication date? Type 'PD' \n" +
                "   Or press enter to leave this menu");
    }

    private void handleSort() {
        printSortMenu();
        String userInput = getUserInput();
        switch( userInput ) {
            case "ST" -> {
                System.out.println( "Type in the series title to sort by here:" );
                userInput = getUserInput();
                System.out.println( "Sorting by series title" );
            }
            case "IN" -> {
                System.out.println( "Type in the issue number to sort by here:" );
                userInput = getUserInput();
                System.out.println( "Sorting by issue number" );
            }
            case "P" -> {
                System.out.println( "Type in the publisher to sort by here:" );
                userInput = getUserInput();
                System.out.println( "Sorting by publisher" );
            }
            case "PD" -> {
                System.out.println( "Type in the publication date to sort by here:" );
                userInput = getUserInput();
                System.out.println( "Sorting by publication date" );
            }
            default -> System.out.println( "Leaving sub-view" );
        }
    }

    private void printImportMenu() {
        System.out.println("Import \n" +
                "   Do you want to import a CSV file? Type 'CSV' \n" +
                "   Do you want to import a JSON file? Type 'JSON' \n" +
                "   Do you want to import an XML file? Type 'XML' \n" +
                "   Or press enter to leave this menu");
    }

    private void handleImport() {
        printImportMenu();
        String userInput = getUserInput();
        switch( userInput ) {
            case "CSV" -> {
                System.out.println( "Type in the file name to import here:" );
                userInput = getUserInput();
                System.out.println( "Importing CSV file" );
            }
            case "JSON" -> {
                System.out.println( "Type in the file name to import here:" );
                userInput = getUserInput();
                System.out.println( "Importing JSON file" );
            }
            case "XML" -> {
                System.out.println( "Type in the file name to import here:" );
                userInput = getUserInput();
                System.out.println( "Importing XML file" );
            }
            default -> System.out.println( "Leaving sub-view" );
        }
    }

    private void printExportMenu() {
        System.out.println("Export \n" +
                "   Do you want to export a CSV file? Type 'CSV' \n" +
                "   Do you want to export a JSON file? Type 'JSON' \n" +
                "   Do you want to export an XML file? Type 'XML' \n" +
                "   Or press enter to leave this menu");
    }

    private void handleExport() {
        printExportMenu();
        String userInput = getUserInput();
        switch( userInput ) {
            case "CSV" -> {
                System.out.println( "Type in the file name to export here:" );
                userInput = getUserInput();
                System.out.println( "Exporting CSV file" );
            }
            case "JSON" -> {
                System.out.println( "Type in the file name to export here:" );
                userInput = getUserInput();
                System.out.println( "Exporting JSON file" );
            }
            case "XML" -> {
                System.out.println( "Type in the file name to export here:" );
                userInput = getUserInput();
                System.out.println( "Exporting XML file" );
            }
            default -> System.out.println( "Leaving sub-view" );
        }
    }

    public boolean view() {
        // get all the personal collections
       
        while( view ) {
            printMainMenu();
            String userInput = getUserInput();
            switch( userInput ) {
                case "D" -> {
                    System.out.println( readDatabase( defaultCSV ) );
                }
                case "C" -> {
                    if( user.isLoggedIn == true ) {
                        handleCommand();
                    } else {
                        System.out.println("You must be logged in to use this feature");
                    }
                }
                case "SE" -> {
                    handleSearch();
                }
                case "SO" -> {
                    handleSort();
                }
                case "I" -> {
                    if( user.isLoggedIn == true ) {
                        handleImport();
                    } else {
                        System.out.println("You must be logged in to use this feature");
                    }
                }
                case "E" -> {
                    if( user.isLoggedIn == true ) {
                        handleExport();
                    } else {
                        System.out.println("You must be logged in to use this feature");
                    }
                }
                default -> System.out.println( "Invalid input" );
            }
        }
        return false;
    }
}
