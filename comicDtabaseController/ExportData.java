package comicDtabaseController;

import java.util.List;
import java.util.Stack;

public class ExportData implements ModifyCommand{
    public Stack<ModifyCommand> redoStack = new Stack<>();
    public Stack<ModifyCommand> undoStack = new Stack<>();

    public ExportData(Stack<ModifyCommand> redoStack, Stack<ModifyCommand>undoStack){
        this.redoStack = redoStack;
        this.undoStack = undoStack;
    }

    @Override
    public void executeCommand(List<Comic> database, Comic comic) {
        // TODO Auto-generated method stub
        
    }
    
}
