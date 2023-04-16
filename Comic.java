import java.util.ArrayList;

import PersonalCollection.PersonalCollectionItem;

public class Comic implements PersonalCollectionItem{
    public String publisher;
    public String seriesTitle;
    public Integer volumeNumber;
    public Integer issueNumber;
    public String publicationDate;
    public ArrayList<String> creators;
    public ArrayList<String> principleCharacters;
    public String description;



    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public void setSeriesTitle(String serierTitle) {
        this.seriesTitle = serierTitle;
    }
    public void setVolumeNumber(Integer volumeNumber) {
        this.volumeNumber = volumeNumber;
    }
    public void setIssueNumber(Integer issueNumber) {
        this.issueNumber = issueNumber;
    }
    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }
    public void setCreators(ArrayList<String> creators) {
        this.creators = creators;
    }
    public void setPrincipleCharacters(ArrayList<String> principleCharacters) {
        this.principleCharacters = principleCharacters;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
