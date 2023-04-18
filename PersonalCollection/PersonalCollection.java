package PersonalCollection;

import java.util.ArrayList;
import java.util.List;

import main.Comic;

public class PersonalCollection {
    private List<PersonalCollectionItems> personalCollectionList = new ArrayList<PersonalCollectionItems>();
    public List<PersonalCollectionItems> personalCollection;
    private int UserID;

    public PersonalCollection(int UserID){
        this.UserID = UserID;
    }
    public PersonalCollection( PersonalCollection personalCollection ) {
        this.personalCollection = personalCollection.personalCollection;
    }
    public PersonalCollection(){
        this.personalCollection = new ArrayList<PersonalCollectionItems>();
    }

    public void addItem(PersonalCollectionItems item){
        personalCollectionList.add(item);
    }
    public void removeItem(PersonalCollectionItems item){
        personalCollectionList.remove(item);
    }
    public List<PersonalCollectionItems> getChildren(){
        return this.personalCollectionList;
    }
    public int getUserID() {
        return UserID;
    }


    public void addTo( int personalCollectionId, Comic comic ) {
        PersonalCollectionItems item = new PersonalCollectionItems( personalCollectionId, comic );
        // check if the list is empty
        if( personalCollection == null ) {
            personalCollection = new ArrayList<PersonalCollectionItems>();
        }
        personalCollection.add( item );
    }
    public List<PersonalCollectionItems> getPC() {
        return personalCollection;
    }
    public void remove( int personalCollectionId, Comic comic ) {
        PersonalCollectionItems item = new PersonalCollectionItems( personalCollectionId, comic );
        personalCollection.remove( item );
    }

    public PersonalCollection getPersonalCollection( int id ) {
        PersonalCollection userPC = new PersonalCollection( id );
        // check if the list is empty
        if( personalCollection == null ) {
            personalCollection = new ArrayList<PersonalCollectionItems>();
        }
        for( PersonalCollectionItems item : personalCollection ) {
            if( item.getId() == id ) {
                userPC.addItem( item );
            }
        }
        return userPC;
    }
}
