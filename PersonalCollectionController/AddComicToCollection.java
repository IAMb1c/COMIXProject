package PersonalCollectionController;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

import PersonalCollection.PersonalCollection;
import PersonalCollection.PersonalCollectionItems;
import main.Comic;

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
        personalCollection.addTo( personalCollectionId, comic );
        try {
            try( BufferedWriter bw = new BufferedWriter( new FileWriter( "main/personalCollections.csv", true ) ) ) {
                    String newSeries = "\"" + comic.getSeriesTitle() + "\"";
                    String newIssue = comic.getIssueNum();
                    String newFullTitle = "\"" + comic.getFullTitle() + "\"";
                    String newVariantDescription = "\"" + comic.getVarDescription() + "\"";
                    String newPub = comic.getPublisher();
                    String newRelease = "\"" + comic.getPublicationDate() + "\"";
                    String newFormat = comic.getFormat();
                    String newAddedDate = "\"" + comic.getAddedDate() + "\"";
                    String newCreator = "\"" + comic.getCreator() + "\"";
                
                    
                    bw.write( personalCollectionId + "," + newSeries + "," + newIssue + "," + newFullTitle + "," + newVariantDescription + "," + newPub + "," + newRelease + "," + newFormat + "," + newAddedDate + "," + newCreator +"\n");
                    bw.close();
                }
        } catch (Exception e) {
            System.out.println( "Error writing to file: " + e.getMessage() );
        }
    }
    
}
