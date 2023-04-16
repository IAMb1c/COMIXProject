import java.util.List;

public class RedoAction {
    public List<ModifyCommand> redoStack;
    public List<ModifyCommand> undoStack;
    public RedoCommand command;
    // TODO add a personal collection object when available

    public RedoAction(List<ModifyCommand> redoStack, List<ModifyCommand> undoStack, RedoCommand command ) {
        this.redoStack = redoStack;
        this.undoStack = undoStack;
        this.command = command;
    }

    public void execute() {
        if (redoStack.size() > 0) {
            command.execute();
        }
    }
}
