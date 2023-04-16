import java.util.List;

import PersonalCollection.PersonalCollection;
import PersonalCollection.PersonalCollectionItems;

public class AddComicToCollection implements ModifyCommand{

    public Comic comic;
    public int personalCollectionId;
    public PersonalCollection personalCollection;

    public AddComicToCollection( Comic comic, int personalCollectionId, PersonalCollection personalCollection ) {
        this.comic = comic;
        this.personalCollectionId = personalCollectionId;
        this.personalCollection = personalCollection;
    }

    @Override
    public void execute() {
        // TODO create these methods (or something similar) in the PersonalCollection class 
        List<PersonalCollectionItems> items = personalCollection.getItems();
        items.add( personalCollectionId, comic );
        personalCollection.setItems( items );
    }
    
}
