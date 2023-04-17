package ViewSubsystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import PersonalCollection.PersonalCollection;
import PersonalCollection.PersonalCollectionItems;
import main.Comic;
import main.User;

public class PersonalCollectionView implements SystemViews {
    
    static String PCFile = "../main/personalCollections.csv";
    private boolean view = true;
    private PersonalCollection AllPC;
    private PersonalCollection userPC;
    private User user;

    public PersonalCollectionView( User user ) {
        this.user = user;
    }



    private void getAllPC() {
        String line = "";
        // get a user from the user csv file and set the user's name and id to the matching row in the file
        try( BufferedReader br = new BufferedReader( new FileReader( PCFile ) ) ) {
            while( ( line = br.readLine() ) != null ) {
                String[] words = line.split(",");
                Comic comic = new Comic( words[1], words[2], words[3], words[4], words[5], words[6], words[7], words[8] );
                int id = Integer.parseInt(words[0]);
                AllPC.addTo(id, comic);
            }
        }
        catch( IOException e ) {
            System.out.println( "Error reading file: " + e.getMessage() );
        }
    }

    /* Create a command list for users to use */


    /** Displays the personal collection view and acts as a "main" */
    public boolean view() {
        // get all the personal collections
        getAllPC();
        while( view ) {
            System.out.println("Personal Collection View \n Do you want to view your personal collection or all personal collections? \n Enter 'P' for your personal collection \n OR press enter to view all personal collections");
            String userInput = getUserInput();
            if( userInput.equals("P") ) {
                // get the user's personal collection
                userPC = AllPC.getPersonalCollection( user.getId() );
                // view the user's personal collection
                try {
                    for( PersonalCollectionItems item : userPC.getPC() ) {
                        System.out.println(item);
                    }
                } catch (Exception e) {
                    System.out.println("Oops! Something went wrong! \n Please restart the application and try again.");
                }
            }
            else {
                // view all the personal collections
                try {
                    for( PersonalCollectionItems item : AllPC.getPC() ) {
                        System.out.println(item);
                    }
                } catch (Exception e) {
                    System.out.println("Oops! Something went wrong! \n Please restart the application and try again.");
                }
            }
            
        }
        return false;
    }
}