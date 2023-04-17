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
   private String[] value = new String[0];

   public Comic(String seriesTitle, String issueNum, String fullTitle, String varDescription, String publisher, String publicationDate, String format, String addedDate, String creators){
       this.publisher = publisher;
       this.seriesTitle = seriesTitle;
       this.fullTitle = fullTitle;
       this.issueNum = issueNum;
       this.publicationDate = publicationDate;
       this.creators = creators;
       this.varDescription = varDescription;
       this.format = format;
       this.addedDate = addedDate;
   }
   public String getSeriesTitle(){
       return this.seriesTitle;
   }
   public String getIssueNum() {
       return issueNum;
   }
   public String getpublisher(){
        return this.publisher;
   }
   public String getCreator() {
        return this.creators;
   }
   

    public void setValue( String[] values) {
        this.value = values;
    }
    public void setSpecificValue( int index, String value ) {
        this.value[index] = value;
    }
    public void addValue( String value ) {
        // add the new string value to the array of strings
        String[] newStringArray = new String[this.value.length + 1];
        for (int i = 0; i < this.value.length; i++) {
            newStringArray[i] = this.value[i];
        }
        newStringArray[newStringArray.length - 1] = value;
        this.value = newStringArray;
    }
    public String[] getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return "Series Title: " + this.seriesTitle + "\n" +
                "   Issue Number: " + this.issueNum + "\n" +
                "   Variant Description: " + this.varDescription + "\n" +
                "   Publisher: " + this.publisher + "\n" +
                "   Publication Date: " + this.publicationDate + "\n" +
                "   Creators: " + this.creators + "\n" +
                "   Format: " + this.format + "\n" +
                "   Added Date: " + this.addedDate + "\n" + 
                "   Value: " + this.getValue() + "\n";
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
