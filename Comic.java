import java.util.ArrayList;

public class Comic {
    public String publisher;
    public String seriesTitle;
    public Integer volumeNumber;
    public Integer issueNumber;
    public String publicationDate;
    public ArrayList<String> creators;
    public ArrayList<String> principleCharacters;
    public String description;
    //** New parameter to encapsulate a comics value *Arbitrary Scale*  Maybe move to personal collection item*/
    public int value;


    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public void setSeriesTitle(String seriesTitle) {
        this.seriesTitle = seriesTitle;
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

    public int getValue() {
        return value;
    } 
    public void setValue(int value) {
        this.value = value;
    }

    public String getPublisher() {
        return publisher;
    }
    public String getSeriesTitle() {
        return seriesTitle;
    }
    public Integer getVolumeNumber() {
        return volumeNumber;
    }
    public Integer getIssueNumber() {
        return issueNumber;
    }
    public String getPublicationDate() {
        return publicationDate;
    }
    public ArrayList<String> getCreators() {
        return creators;
    }
    public ArrayList<String> getPrincipleCharacters() {
        return principleCharacters;
    }
    public String getDescription() {
        return description;
    }
}
