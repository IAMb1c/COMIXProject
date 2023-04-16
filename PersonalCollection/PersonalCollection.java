package PersonalCollection;

import java.util.ArrayList;
import java.util.List;

public class PersonalCollection {
    private List<PersonalCollectionItem> personalCollectionList = new ArrayList<PersonalCollectionItem>();


    public void addItem(PersonalCollectionItem item){
        personalCollectionList.add(item);
    }
    public void removeItem(PersonalCollectionItem item){
        personalCollectionList.remove(item);
    }
    public List<PersonalCollectionItem> getChildren(){
        return this.personalCollectionList;
    }
}
