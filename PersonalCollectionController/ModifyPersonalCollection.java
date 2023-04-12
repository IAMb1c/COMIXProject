package PersonalCollectionController;

import java.util.List;

public class ModifyPersonalCollection {
    public List<ModifyCommand> undoStack;
   
    public ModifyPersonalCollection( List<ModifyCommand> undoStack) {
        this.undoStack = undoStack;
    }

    public void execute( ModifyCommand command ) {
        command.execute();
        undoStack.add(command);
    }
}
