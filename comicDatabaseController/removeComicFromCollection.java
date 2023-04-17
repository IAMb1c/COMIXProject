package comicDatabaseController;

import java.util.List;
import main.Comic;

public class removeComicFromCollection implements ModifyCommand{
    public List<Comic> database;
    public Comic comic;
    public List<ModifyCommand> commandsExecuted;
    private final String id = "remove";
    public removeComicFromCollection(List<Comic> database, Comic comic, List<ModifyCommand> commandsExecuted){
        this.database = database;
        this.comic = comic;
        this.commandsExecuted = commandsExecuted;
    }

    @Override
    public void executeCommand() {
        database.remove(comic);
        commandsExecuted.add(this);
    }

   public String getId(){
       return this.id;
   }
    
}
