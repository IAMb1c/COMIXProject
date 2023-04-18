package PersonalCollection;

import java.io.BufferedReader;
import java.io.FileReader;

import main.Comic;

public class PersonalCollectionItems {
    public int personalCollectionId;
    public Comic comic;
    private String userFile = "main/users.csv";

    public PersonalCollectionItems( int personalCollectionId, Comic comic ) {
        this.personalCollectionId = personalCollectionId;
        this.comic = comic;
    }

    public int getId() {
        return personalCollectionId;
    }
    public Comic getComic() {
        return comic;
    }
    public void setComic( Comic comic ) {
        this.comic = comic;
    }

    public void setValue( String[] value ) {
        comic.setValue( value );
    }
    public void addValue( String value ) {
        comic.addValue( value );
    }
    public void setSpecificValue( int index, String value ) {
        comic.setSpecificValue( index, value );
    }

    /* Simple helper method to match the user to the user id */
    private String matchUser( int userId ) {
        // read a csv file and match the user id to the provided userID
        // return the user name
        String line = "";
        // get a user from the user csv file and set the user's name and id to the matching row in the file
        try( BufferedReader br = new BufferedReader( new FileReader( userFile ) ) ) {
            while( ( line = br.readLine() ) != null ) {
                String[] words = line.split(",");
                if( words[0].contains( String.valueOf( userId ) ) ) {
                    return words[1];
                }
            }
        }
        catch( Exception e ) {
            System.out.println( "Error reading file: " + e.getMessage() );
        }
        return "user not found";
    }

    @Override
    public String toString() {
        return comic.toString() + "Owned by user: " + matchUser( personalCollectionId ) + "\n";
    }
}
