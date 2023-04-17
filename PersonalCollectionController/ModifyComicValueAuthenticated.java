package PersonalCollectionController;

import java.util.List;

import PersonalCollection.PersonalCollection;
import PersonalCollection.PersonalCollectionItem;
import PersonalCollection.PersonalCollectionItems;
import main.Comic;
public class ModifyComicValueAuthenticated implements ModifyCommand{

    public Comic comic;
    public int personalCollectionId;
    public PersonalCollection personalCollection;

    public ModifyComicValueAuthenticated( Comic comic, int personalCollectionId, PersonalCollection personalCollection ) {
        this.comic = comic;
        this.personalCollectionId = personalCollectionId;
        this.personalCollection = personalCollection;
    }

    @Override
    public void execute() {
        // get a full list of comics from the personal collection
        List<PersonalCollectionItems> items = personalCollection.getPC();
        // find the comic in the list of comics items
        for (PersonalCollectionItems i : items) {
            if (i.getId() == personalCollectionId && i.getComic() == comic ) {
                // check if the comic is signed
                for( String s : i.getComic().getValue() ) {
                    if ( s.contains( i.getComic().getCreator() ) ) {
                        // modify the comic
                        i.addValue( "Authenticated" );
                    }
                }
            }
        }
    }
    
}
