import java.util.List;

import PersonalCollection.PersonalCollection;
import PersonalCollection.PersonalCollectionItems;

public class ModifyComicValue implements ModifyCommand{

    public Comic comic;
    public int personalCollectionId;
    public PersonalCollection personalCollection;

    public ModifyComicValue( Comic comic, int personalCollectionId, PersonalCollection personalCollection ) {
        this.comic = comic;
        this.personalCollectionId = personalCollectionId;
        this.personalCollection = personalCollection;
    }

    @Override
    public void execute() {
        //** Arbitrarily adds a point of value to a comic so the more points the better ? */
        // TODO add something to match these methods
        // get a full list of comics from the personal collection
        List<PersonalCollectionItems> items = personalCollection.getItems();
        // find the comic in the list of comics items
        for (PersonalCollectionItems i : items) {
            if (i.getId() == personalCollectionId && i.getComicIssueNumber() == comic.getIssueNumber() ) {
                // modify the comic
                i.setValue( i.getValue() + 1 );
            }
        }
    }
    
}
