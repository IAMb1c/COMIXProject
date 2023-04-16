import java.util.List;

public class AddComicToCollection implements ModifyCommand{

    public Comic comic;
    public int personalCollectionId;
    // TODO replace this with the personal collection object
    private String personalCollectionFile = "COMIXProject/personalCollections.csv";

    public AddComicToCollection( Comic comic, int personalCollectionId ) {
        this.comic = comic;
        this.personalCollectionId = personalCollectionId;
    }

    @Override
    public void execute() {
        // TODO grab the comic and add it to the personal collection with the respective id
    }
    
}
