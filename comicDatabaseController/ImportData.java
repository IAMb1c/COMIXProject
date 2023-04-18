package comicDatabaseController;
import java.util.ArrayList;
import java.util.List;
import ImportExport.FileAdapter;
import ImportExport.ReadFile;
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
        ReadFile readFile = new FileAdapter("CSV", "main/comics.csv");
        this.database = readFile.readData();
    }

    @Override
    public void executeCommand() {
       read();
       commandsExecuted.add(this);
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public List<Comic> getDatabase() {
        return this.database;
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
