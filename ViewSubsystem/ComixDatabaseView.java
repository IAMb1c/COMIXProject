package ViewSubsystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ComixDatabaseView implements SystemViews {
    private String view;


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

    
    public boolean view() {
        System.out.println("Comix Database View");
        return false;
    }

    public static void main(String[] args) {
        ComixDatabaseView view = new ComixDatabaseView();
        String str = view.readDatabase("COMIXProject/comics.csv");
        System.out.println(str);

        // TODO capturing user commands goes here ?
    }
}
