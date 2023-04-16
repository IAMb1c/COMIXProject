package comicDatabaseController;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * Parses csv for data 
 */
public class ImportData implements ModifyCommand {

    private Map<String, Comic> database = new HashMap<>();
    
    // public void read(){
    //     try(BufferedReader reader = new BufferedReader(new FileReader("comics.csv"))){
    //         int i  = 0;
    //         int j = 0;
    //         String line;
    //         while((line = reader.readLine()) != null){
    //             if(i > 3){
    //                 String[] data = line.split(",");
    //                 // for(String value:data){
    //                 //     System.out.print(value);
    //                 // }
    //                 Comic comic = new Comic(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7]);
    //                 System.out.println(comic.getSeriesTitle());
    //                 database.put(data[0], comic);
    //             }
    //             if(j == 10){break;}
    //             i++;
    //             j++;
    //         }
    //     }
    //     catch (IOException e) {
    //         e.printStackTrace();
    //     }
    // }
    /**
     * 
     * @return Hashmap of String and Comic
     * Name is the key and Comic object is the value
     */
    public Map<String, Comic> getDatabase(){
        return this.database;
    }

    @Override
    public void executeCommand() {
        // TODO Auto-generated method stub
        
    }
    
}
