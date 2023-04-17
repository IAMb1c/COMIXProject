package ImportExport;
import org.json.simple.*;
import org.json.simple.parser.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import main.Comic;

public class JSONReader {
    private String filename;
    private List<Comic> database;

    public JSONReader(String filename){
        this.filename = filename;
        this.database = new ArrayList<>();
    }

    public List<Comic> read(){
        JSONParser parser = new JSONParser();
        try{
            Object obj = parser.parse((new FileReader(filename)));
            String data = obj.toString();
            data = data.substring(1, data.length()-1);
            String[] arr = data.split("},");
            int k = 0;
            for(String i : arr){
                if(k > 2){
                    String current = i.substring(1);
                    String[] details = current.split(",");
                    System.out.println(details[0]);
                    String seriesTitle = details[1].substring(10, details[1].length()-1);
                    String issueNum = details[2].substring(8);
                    String format = details[3].substring(10,details[3].length()-1);
                    String publisher = details[4].substring(13,details[4].length()-1);
                    String creators = details[5].substring(12, details[5].length()-1);
                    String addedDate = details[6].substring(14) + " " + details[7].substring(1, details[7].length()-1);
                    String varDescription = details[8].substring(23, details[8].length()-1);
                    String publicationDate = details[9].substring(16, details[9].length()-1);
                    Comic comic = new Comic(seriesTitle, issueNum, varDescription, publisher, publicationDate, format, addedDate, creators);
                    database.add(comic);
                    
                }
                k++;
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
       
 
        return this.database;
    }

    public static void main(String[] args) {
        JSONReader reader  = new JSONReader("main/csvjson.json");
        List<Comic> d = reader.read();
        // for(Comic c : d){
        //     System.out.println(c.getSeriesTitle());
        // }
    }
}
