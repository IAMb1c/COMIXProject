package PersonalCollectionController;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<ModifyCommand> undoStack = new ArrayList<ModifyCommand>();
        List<ModifyCommand> redoStack = new ArrayList<ModifyCommand>();

        ModifyPersonalCollection modifyPersonalCollection = new ModifyPersonalCollection(undoStack);
        ModifyCommand command1 = new ModifyCommand() {
            @Override
            public void execute() {
                System.out.println("ModifyCommand");
            }
        };
        UndoCommand undoCommand = new UndoCommand( redoStack, undoStack );
        RedoCommand redoCommand = new RedoCommand( redoStack, undoStack );

        UndoAction undoAction = new UndoAction( redoStack, undoStack, undoCommand );
        RedoAction redoAction = new RedoAction( redoStack, undoStack, redoCommand );
        modifyPersonalCollection.execute(command1);
        undoAction.execute();
        redoAction.execute();

    }
}
