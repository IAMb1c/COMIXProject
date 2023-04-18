package PersonalCollectionController;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

import PersonalCollection.PersonalCollection;
import PersonalCollection.PersonalCollectionItem;
import PersonalCollection.PersonalCollectionItems;
import main.Comic;
public class ModifyComicValueGraded implements ModifyCommand{

    public Comic comic;
    public int personalCollectionId;
    public PersonalCollection personalCollection;

    public ModifyComicValueGraded( Comic comic, int personalCollectionId, PersonalCollection personalCollection ) {
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
                // check if the comic is graded 
                Comic newComic = i.getComic();
                int j = 0;
                for( String s : i.getComic().getValue() ) {
                    if ( s.contains( "Grade: " ) ) {
                        // get the last 2 characters of the string
                        String grade = s.substring( s.length() - 2 );
                        // add to the grade value
                        if ( grade.contains( "10" ) ) {
                            grade = "9";
                        }
                        int gradeValue = Integer.parseInt( grade ) + 1;
                        String newString = "Grade: " + gradeValue;
                        // modify the comic
                        i.setSpecificValue( j, newString );
                    } else {
                        // modify the comic
                        i.addValue( "Grade: 1" );
                    }
                    j++;
                }
                personalCollection.remove( personalCollectionId, i.getComic() );
                personalCollection.addTo( personalCollectionId, newComic );

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
