package ImportExport;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import main.Comic;

/**
 * Reads provided CSV file and stores its data in list
 */
public class CSV {
    private String filename;
    private List<Comic> database;

    public CSV(String filename){
        this.filename = filename;
        this.database = new ArrayList<>();
    }

    public List<Comic> read(){
        try(BufferedReader reader = new BufferedReader(new FileReader(this.filename))){
            int i  = 0;
            int j = 0;
            String line;
            while((line = reader.readLine()) != null){
                if(i > 2){
                    String[] data = line.split(",");
                    Comic comic = new Comic(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7], data[8]);
                   database.add(comic);
                }
                //controller for how many comic to add to database, for testing purposes
                if(j == 10){break;}
                i++;
                j++;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return database;
    }
}
