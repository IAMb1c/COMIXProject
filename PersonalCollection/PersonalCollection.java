package PersonalCollection;

import java.util.ArrayList;
import java.util.List;

public class PersonalCollection {
    private List<PersonalCollectionItem> personalCollectionList = new ArrayList<PersonalCollectionItem>();
    private int UserID;

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
}
