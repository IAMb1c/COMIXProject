package comicDtabaseController;

import java.util.List;
import java.util.Stack;

/**
 * Command class represents database/collection commands
 */
public interface ModifyCommand {
    
    public Stack<ModifyCommand> redoStack = new Stack<>();
    public Stack<ModifyCommand> undoStack = new Stack<>();
    /**
     * Executes a command on the database with the comic
     */
    public void executeCommand(List<Comic> database, Comic comic);
}
