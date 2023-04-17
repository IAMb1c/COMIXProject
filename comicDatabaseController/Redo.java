package comicDatabaseController;
import java.util.List;


public class Redo implements ModifyCommand {
    public List<ModifyCommand> commandsExecuted;
    private final String id = "redo";
    
    public Redo(List<ModifyCommand> commandsExecuted){
        this.commandsExecuted = commandsExecuted;

    }

    @Override
    public void executeCommand() {
       if(!commandsExecuted.isEmpty()){
            ModifyCommand command = commandsExecuted.get(commandsExecuted.size()-1);
            command.executeCommand();
            commandsExecuted.remove(command);
       }
        else{
            System.out.println("Redo stack is empty");
        }
    }

    @Override
    public String getId() {
        return this.id;
    }
    
}
