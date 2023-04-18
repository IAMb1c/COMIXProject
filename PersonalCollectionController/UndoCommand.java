package PersonalCollectionController;
import java.util.List;

import PersonalCollection.PersonalCollection;

public class UndoCommand implements ModifyCommand {
    public List<ModifyCommand> redoStack;
    public List<ModifyCommand> undoStack;
    public PersonalCollection personalCollection;

    public UndoCommand(List<ModifyCommand> redoStack, List<ModifyCommand> undoStack, PersonalCollection personalCollection) {
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
