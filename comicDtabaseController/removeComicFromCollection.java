package comicDtabaseController;

import java.util.List;
import java.util.Stack;

public class removeComicFromCollection implements ModifyCommand{
    public Stack<ModifyCommand> redoStack = new Stack<>();
    public Stack<ModifyCommand> undoStack = new Stack<>();

    public removeComicFromCollection(Stack<ModifyCommand> redoStack, Stack<ModifyCommand>undoStack){
        this.redoStack = redoStack;
        this.undoStack = undoStack;
    }

    @Override
    public void executeCommand(List<Comic> database, Comic comic) {
        database.remove(comic);
        
    }

   
    
    
}
