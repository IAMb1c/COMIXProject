import java.util.List;

public class UndoCommand implements ModifyCommand {
    public List<ModifyCommand> redoStack;
    public List<ModifyCommand> undoStack;
    // TODO add a personal collection object when available

    public UndoCommand(List<ModifyCommand> redoStack, List<ModifyCommand> undoStack ) {
        this.redoStack = redoStack;
        this.undoStack = undoStack;
    }

    @Override
    public void execute() {
        // getting the last command from the undoable stack
        ModifyCommand lastCommand = undoStack.get(undoStack.size() - 1);
        redoStack.add(lastCommand);

        // removing the last command from the undoable stack
        undoStack.remove(undoStack.size() - 1);
 
        // executing the new last command in the command stack
        undoStack.get(undoStack.size() - 1).execute();
    }
}
