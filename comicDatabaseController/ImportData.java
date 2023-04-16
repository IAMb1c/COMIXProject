package comicDatabaseController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

import javax.smartcardio.CommandAPDU;

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

    @Override
    public void executeCommand() {
        
    }

    @Override
    public String getId() {
        return null;
    }
    
}
