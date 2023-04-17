package PersonalCollectionController;

import java.util.List;

import PersonalCollection.PersonalCollection;

public class ModifyPersonalCollection {
    public List<ModifyCommand> undoStack;
    public PersonalCollection personalCollection;
   
    public ModifyPersonalCollection( List<ModifyCommand> undoStack, PersonalCollection personalCollection ) {
        this.undoStack = undoStack;
        this.personalCollection = personalCollection;
    }

    public void execute( ModifyCommand command ) {
        command.execute();
        undoStack.add(command);
    }
}
