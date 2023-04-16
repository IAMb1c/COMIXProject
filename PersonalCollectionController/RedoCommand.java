import java.util.List;

import PersonalCollection.PersonalCollection;

public class RedoCommand implements ModifyCommand{
    public List<ModifyCommand> redoStack;
    public List<ModifyCommand> undoStack;
    public PersonalCollection personalCollection;

    public RedoCommand(List<ModifyCommand> redoStack, List<ModifyCommand> undoStack, PersonalCollection personalCollection ) {
        this.redoStack = redoStack;
        this.undoStack = undoStack;
        this.personalCollection = personalCollection;
    }

    @Override
    public void execute() {
        // get the last command from the redoable stack 
        ModifyCommand lastCommand = redoStack.get(redoStack.size() - 1);
        // remove the last command from the redoable stack
        redoStack.remove(redoStack.size() - 1);
        // execute the last command in the command stack
        lastCommand.execute();
        // add the last command to the undoable stack
        undoStack.add(lastCommand);
    }
}
