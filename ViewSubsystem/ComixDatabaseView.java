package ViewSubsystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import main.User;

public class ComixDatabaseView implements SystemViews {
    static String defaultCSV = "main/comics.csv";
    private boolean view = true;
    private User user;

    public ComixDatabaseView( User user ) {
        this.user = user;
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
                
                }
                case "SE" -> {
                
                }
                case "SO" -> {
                
                }
                case "I" -> {
                
                }
                case "E" -> {
                
                }
                default -> System.out.println( "Invalid input" );
            }
        }
        return false;
    }
}
