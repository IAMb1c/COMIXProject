package PersonalCollectionController;
import java.util.List;

import PersonalCollection.PersonalCollection;

public class UndoAction {
    public List<ModifyCommand> redoStack;
    public List<ModifyCommand> undoStack;
    public UndoCommand command;
    public PersonalCollection personalCollection;

    public UndoAction(List<ModifyCommand> redoStack, List<ModifyCommand> undoStack, UndoCommand command, PersonalCollection personalCollection) {
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
