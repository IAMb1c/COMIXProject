package PersonalCollection;

import java.util.ArrayList;
import java.util.List;

import main.Comic;

public class PersonalCollection {
    private List<PersonalCollectionItem> personalCollectionList = new ArrayList<PersonalCollectionItem>();
    public List<PersonalCollectionItems> personalCollection;
    private int UserID;

    public PersonalCollection(int UserID){
        this.UserID = UserID;
    }
    public PersonalCollection( PersonalCollection personalCollection ) {
        this.personalCollection = personalCollection.personalCollection;
    }

    public void addItem(PersonalCollectionItem item){
        personalCollectionList.add(item);
    }
    public void removeItem(PersonalCollectionItem item){
        personalCollectionList.remove(item);
    }
    public List<PersonalCollectionItem> getChildren(){
        return this.personalCollectionList;
    }
    public int getUserID() {
        return UserID;
    }


    public void addTo( int personalCollectionId, Comic comic ) {
        PersonalCollectionItems item = new PersonalCollectionItems( personalCollectionId, comic );
        personalCollection.add( item );
    }
    public List<PersonalCollectionItems> getPC() {
        return personalCollection;
    }
    public void remove( int personalCollectionId, Comic comic ) {
        PersonalCollectionItems item = new PersonalCollectionItems( personalCollectionId, comic );
        personalCollection.remove( item );
    }

    public List<PersonalCollectionItems> getPersonalCollection( int id ) {
        List<PersonalCollectionItems> userPC = new ArrayList<PersonalCollectionItems>();
        for( PersonalCollectionItems item : personalCollection ) {
            if( item.getId() == id ) {
                userPC.add( item );
            }
        }
        return userPC;
    }
}
