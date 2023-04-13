import java.util.List;

public class RedoCommand implements ModifyCommand{
    public List<ModifyCommand> redoStack;
    public List<ModifyCommand> undoStack;

    public RedoCommand(List<ModifyCommand> redoStack, List<ModifyCommand> undoStack ) {
        this.redoStack = redoStack;
        this.undoStack = undoStack;
    }

    @Override
    public void execute() {
        // get the last command from the redoable stack 
        ModifyCommand lastCommand = redoStack.get(redoStack.size() - 1);
        // remove the last command from the redoable stack
        redoStack.remove(redoStack.size() - 1);
        // execute the last command in the command stack
        lastCommand.execute();
    }
}
