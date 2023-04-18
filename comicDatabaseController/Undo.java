package comicDatabaseController;

import java.util.List;
import main.Comic;

/**
 * Undo class contains a undoStack which conatins commands that you
 */
public class Undo implements ModifyCommand {
    public List<ModifyCommand> commandsExecuted;
    private final String id = "undo";
    public List<Comic> database;

    public Undo(List<ModifyCommand> commandsExecuted, List<Comic> database){
        this.commandsExecuted = commandsExecuted;
        this.database = database;
    }
    @Override
    public void executeCommand() {
        if(!commandsExecuted.isEmpty()){
            ModifyCommand command = commandsExecuted.get(commandsExecuted.size()-1);
            if(command.getId().equals("add")){
                database.remove(database.size()-1);
                commandsExecuted.remove(command);
            }
            else if(command.getId().equals("remove")){
                Comic comic = ((removeComicFromCollection)command).comic;
                commandsExecuted.remove(command);
                ModifyCommand addCommand = new AddComicToCollection(database, comic, commandsExecuted);
                addCommand.executeCommand();
            }
        }
        
    }
    @Override
    public String getId() {
        return id;
    }
    @Override
    public List<Comic> getDatabase() {
        return this.database;
    }
    
}
