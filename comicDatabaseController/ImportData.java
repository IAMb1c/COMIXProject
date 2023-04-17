package comicDatabaseController;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import main.Comic;

/**
 * Parses csv for data 
 */
public class ImportData implements ModifyCommand {
    public List<ModifyCommand> commandsExecuted;
    private final String id = "undo";
    public List<Comic> database;

    public ImportData(List<ModifyCommand> commandsExecuted, List<Comic> database){
        this.commandsExecuted  = commandsExecuted;
        this.database = database;
    }

    public void read(){
        try(BufferedReader reader = new BufferedReader(new FileReader("main/comics.csv"))){
            int i  = 0;
            int j = 0;
            String line;
            while((line = reader.readLine()) != null){
                if(i > 3){
                    String[] data = line.split(",");
                    Comic comic = new Comic(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7]);
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
    }

    @Override
    public void executeCommand() {
       read();
       commandsExecuted.add(this);
       // ComicDatabase data = new ComicDatabase("main/comics.csv");
        //data.read();
       // database = data.getComics();
    }

    @Override
    public String getId() {
        return this.id;
    }

    public static void main(String[] args) {
        List<ModifyCommand> commands = new ArrayList<ModifyCommand>();
        List<Comic> database = new ArrayList<>();
        ModifyCommand data = new ImportData(commands, database);
        data.executeCommand();
        for(Comic comic : database){
            System.out.println(comic.getSeriesTitle());
        }
    }
    
}
