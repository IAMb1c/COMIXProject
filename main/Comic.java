 package main;

public class Comic {
   private String publisher;
   private String seriesTitle;
   private String fullTitle;
   private String issueNum; 
   private String publicationDate;
   private String creators;
   private String varDescription; 
   private String format;
   private String addedDate;

   public Comic(String seriesTitle, String issueNum, String varDescription, String publisher, String publicationDate, String format, String addedDate, String creators){
       this.publisher = publisher;
       this.seriesTitle = seriesTitle;
       this.issueNum = issueNum;
       this.publicationDate = publicationDate;
       this.creators = creators;
       this.varDescription = varDescription;
       this.format = format;
       this.addedDate = addedDate;
   }
   // getters added by Kevin L. if these need to be removed, please let me know-- I need this for the searches
    public String getSeriesTitle(){
       return this.seriesTitle;
    }
    public String getPublisher(){
        return this.publisher;
    }
    public String getTitle() {
        return fullTitle;
    }
    public String getDescription() {
        return varDescription;
    }
    public String getCreators() {
        return creators;
    }
    public String getPublicationDate() {
        return publicationDate;
    }
    public String getIssue() {
        return issueNum;
    }
   
   }

// import java.util.ArrayList;

// import PersonalCollection.PersonalCollectionItem;

// public class Comic implements PersonalCollectionItem{
//     public String publisher;
//     public String seriesTitle;
//     public Integer volumeNumber;
//     public Integer issueNumber;
//     public String publicationDate;
//     public ArrayList<String> creators;
//     public ArrayList<String> principleCharacters;
//     public String description;



//     public void setPublisher(String publisher) {
//         this.publisher = publisher;
//     }
//     public void setSeriesTitle(String serierTitle) {
//         this.seriesTitle = serierTitle;
//     }
//     public void setVolumeNumber(Integer volumeNumber) {
//         this.volumeNumber = volumeNumber;
//     }
//     public void setIssueNumber(Integer issueNumber) {
//         this.issueNumber = issueNumber;
//     }
//     public void setPublicationDate(String publicationDate) {
//         this.publicationDate = publicationDate;
//     }
//     public void setCreators(ArrayList<String> creators) {
//         this.creators = creators;
//     }
//     public void setPrincipleCharacters(ArrayList<String> principleCharacters) {
//         this.principleCharacters = principleCharacters;
//     }
//     public void setDescription(String description) {
//         this.description = description;
//     }
// }
