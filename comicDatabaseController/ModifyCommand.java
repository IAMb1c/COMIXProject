package comicDatabaseController;

import java.util.List;

import main.Comic;

/**
 * Command class represents database/collection commands
 */
public interface ModifyCommand {
    /**
     * Executes a command on the database with the comic
     */
    public void executeCommand();
    
    /**
     * 
     * @return id associated with the specific command
     */
    public String getId();

    public List<Comic> getDatabase();
}
