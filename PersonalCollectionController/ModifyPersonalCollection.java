import java.util.List;

public class ModifyPersonalCollection {
    public List<ModifyCommand> undoStack;
    // TODO add a personal collection object when available
   
    public ModifyPersonalCollection( List<ModifyCommand> undoStack) {
        this.undoStack = undoStack;
    }

    public void execute( ModifyCommand command ) {
        command.execute();
        undoStack.add(command);
    }
}
