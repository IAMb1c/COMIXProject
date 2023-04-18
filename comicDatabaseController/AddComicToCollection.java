package comicDatabaseController;
import java.util.List;
import main.Comic;

public class AddComicToCollection implements ModifyCommand {
    public List<Comic> database;
    public List<ModifyCommand> commandsExecuted;
    public Comic comic;
    private final String id = "Add";
    public AddComicToCollection(List<Comic> database, Comic comic, List<ModifyCommand> commandsExecuted){
        this.database = database;
        this.comic = comic;
        this.commandsExecuted = commandsExecuted;
    }
    @Override
    public void executeCommand() {
        database.add(comic);
        commandsExecuted.add(this);
    }
    
    public String getId(){
        return this.id;
    }
    @Override
    public List<Comic> getDatabase() {
        return this.database;
    }
   
}
