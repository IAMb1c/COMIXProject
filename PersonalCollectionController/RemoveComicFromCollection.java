package PersonalCollectionController;

public class RemoveComicFromCollection implements ModifyCommand{

    public Comic comic;
    public int personalCollectionId;
    private String personalCollectionFile = "COMIXProject/personalCollections.csv";

    public RemoveComicFromCollection( Comic comic, int personalCollectionId ) {
        this.comic = comic;
        this.personalCollectionId = personalCollectionId;
    }

    @Override
    public void execute() {
        // TODO remove the comic from the personal collection
        throw new UnsupportedOperationException("Unimplemented method 'execute'");
    }
    
}
