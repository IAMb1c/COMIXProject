package PersonalCollectionController;
import PersonalCollection.PersonalCollection;
import main.Comic;

public class RemoveComicFromCollection implements ModifyCommand{

    public Comic comic;
    public int personalCollectionId;
    public PersonalCollection personalCollection;

    public RemoveComicFromCollection( Comic comic, int personalCollectionId, PersonalCollection personalCollection ) {
        this.comic = comic;
        this.personalCollectionId = personalCollectionId;
    }

    @Override
    public void execute() {
       personalCollection.remove( personalCollectionId, comic );
    }
    
}
