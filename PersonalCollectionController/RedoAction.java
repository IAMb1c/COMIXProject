package PersonalCollectionController;

import java.security.PermissionCollection;
import java.util.List;

import PersonalCollection.PersonalCollection;

public class RedoAction {
    public List<ModifyCommand> redoStack;
    public List<ModifyCommand> undoStack;
    public RedoCommand command;
    public PersonalCollection personalCollection;

    public RedoAction(List<ModifyCommand> redoStack, List<ModifyCommand> undoStack, RedoCommand command, PersonalCollection personalCollection ) {
        this.redoStack = redoStack;
        this.undoStack = undoStack;
        this.command = command;
        this.personalCollection = personalCollection;
    }

    public void execute() {
        if (redoStack.size() > 0) {
            command.execute();
        }
    }
}
