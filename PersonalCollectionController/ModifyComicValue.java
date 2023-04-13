public class ModifyComicValue implements ModifyCommand{

    public Comic comic;
    public int personalCollectionId;
    private String personalCollectionFile = "COMIXProject/personalCollections.csv";

    public ModifyComicValue( Comic comic, int personalCollectionId ) {
        this.comic = comic;
        this.personalCollectionId = personalCollectionId;
    }

    @Override
    public void execute() {
        // TODO remove the comic from the personal collection then modify it and add it back to the personal collection
        throw new UnsupportedOperationException("Unimplemented method 'execute'");
    }
    
}
