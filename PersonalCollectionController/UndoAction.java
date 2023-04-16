import java.util.List;

public class UndoAction {
    public List<ModifyCommand> redoStack;
    public List<ModifyCommand> undoStack;
    public UndoCommand command;
    // TODO add a personal collection object when available

    public UndoAction(List<ModifyCommand> redoStack, List<ModifyCommand> undoStack, UndoCommand command ) {
        this.redoStack = redoStack;
        this.undoStack = undoStack;
        this.command = command;
    }

    public void execute() {
        if (undoStack.size() >= 2) {
            command.execute();
        }
    }
}
