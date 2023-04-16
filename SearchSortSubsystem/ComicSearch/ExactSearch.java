package SearchSortSubsystem.ComicSearch;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

public class ExactSearch implements ComicSearch{

    private final String DATABASE_FILEPATH = "COMIXProject/comics.csv";
    @Override
    public void search(String term) {
        /** Array */
        ArrayList<String> comics = new ArrayList<String>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(DATABASE_FILEPATH));
            String line;
            while((line = reader.readLine()) != null) {
                if(line.contains(term))  {
                    comics.add(line);
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Database filepath is incorrect!");
        } catch (IOException e) {
            System.out.println("IO exception! Check database!");
        }
    }
    
}
