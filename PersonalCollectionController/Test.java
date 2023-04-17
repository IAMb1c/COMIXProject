import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import PersonalCollection.PersonalCollection;

public class Test {
    public static void main(String[] args) {
        List<ModifyCommand> undoStack = new ArrayList<ModifyCommand>();
        List<ModifyCommand> redoStack = new ArrayList<ModifyCommand>();
        // parse the personal collection csv file and create a personal collection
        String csvFile = "../main/personalCollections.csv";
        PersonalCollection personalCollection = new PersonalCollection( 1 );

        ModifyPersonalCollection modifyPersonalCollection = new ModifyPersonalCollection(undoStack, personalCollection);
        ModifyCommand command1 = new ModifyCommand() {
            @Override
            public void execute() {
                System.out.println("ModifyCommand");
            }
        };
        UndoCommand undoCommand = new UndoCommand( redoStack, undoStack, personalCollection );
        RedoCommand redoCommand = new RedoCommand( redoStack, undoStack, personalCollection );

        UndoAction undoAction = new UndoAction( redoStack, undoStack, undoCommand, personalCollection );
        RedoAction redoAction = new RedoAction( redoStack, undoStack, redoCommand, personalCollection );
        modifyPersonalCollection.execute(command1);
        undoAction.execute();
        redoAction.execute();

    }
}
