package PersonalCollectionController;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

import PersonalCollection.PersonalCollection;
import PersonalCollection.PersonalCollectionItem;
import PersonalCollection.PersonalCollectionItems;
import main.Comic;
public class ModifyComicValueSigned implements ModifyCommand{

    public Comic comic;
    public int personalCollectionId;
    public PersonalCollection personalCollection;

    public ModifyComicValueSigned( Comic comic, int personalCollectionId, PersonalCollection personalCollection ) {
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
                // create a new comic
                Comic newComic = i.getComic();
                newComic.addValue("Signed by " + i.getComic().getCreator());
                // remove the old item
                personalCollection.remove( personalCollectionId, i.getComic() );
                // add the new item
                personalCollection.addTo(personalCollectionId, newComic);

                // write to the database
                try( BufferedWriter bw = new BufferedWriter( new FileWriter( "main/personalCollections.csv", true ) ) ) {
                    String newSeries = "\"" + newComic.getSeriesTitle() + "\"";
                    String newIssue = newComic.getIssueNum();
                    String newFullTitle = "\"" + newComic.getFullTitle() + "\"";
                    String newVariantDescription = "\"" + newComic.getVarDescription() + "\"";
                    String newPub = newComic.getPublisher();
                    String newRelease = "\"" + newComic.getPublicationDate() + "\"";
                    String newFormat = newComic.getFormat();
                    String newAddedDate = "\"" + newComic.getAddedDate() + "\"";
                    String newCreator = "\"" + newComic.getCreator() + "\"";
                
                    
                    bw.write( personalCollectionId + "," + newSeries + "," + newIssue + "," + newFullTitle + "," + newVariantDescription + "," + newPub + "," + newRelease + "," + newFormat + "," + newAddedDate + "," + newCreator +"\n");
                    bw.close();
                }
                catch( Exception e ) {
                    System.out.println( "Error writing to file: " + e.getMessage() );
                }
            }
        }
    }
    
}
