package comicDatabaseController;

import java.util.List;

import main.Comic;

public class ExportData implements ModifyCommand{
    private final String id = "export";

    @Override
    public void executeCommand() {
        System.out.println("Exporting data");
        
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public List<Comic> getDatabase() {
        return null;
    }
    
}
