import PersonalCollection.PersonalCollection;

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
        // remove the comic from the personal collection
        // TODO create these methods (or something similar) in the PersonalCollection class
        List<Comic> comics = personalCollection.getComics();
        comics.remove( comic );
        personalCollection.setComics( comics );
    }
    
}
