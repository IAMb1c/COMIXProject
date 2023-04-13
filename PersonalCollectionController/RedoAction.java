import java.util.List;

public class RedoAction {
    public List<ModifyCommand> redoStack;
    public List<ModifyCommand> undoStack;
    public RedoCommand command;

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
