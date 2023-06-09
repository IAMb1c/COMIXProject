package PersonalCollection;

import java.util.ArrayList;
import java.util.List;

public class ComicGroup implements PersonalCollectionItem{
    // The name for this comic group eg name of publisher, or volume name
    private String name;
    // Type of objects stored, eg publishers, volumes, etc
    private String type;

    public ComicGroup(String name, String type){
        this.name = name;
        this.type = type;
    }
    private List<PersonalCollectionItem> comicGroup = new ArrayList<PersonalCollectionItem>();


    
    public String getName() {
        // TODO Auto-generated method stub
        return this.name;

    }

    public String getType() {
        return this.type;
    }

    
    public void addItem(PersonalCollectionItem item){
        comicGroup.add(item);
    }
    public void removeItem(PersonalCollectionItem item){
        comicGroup.remove(item);
    }
    public List<PersonalCollectionItem> getChildren(){
        return this.comicGroup;
    }
}
