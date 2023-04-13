import java.util.Properties;

public class Comic {
   private String publisher;
   private String seriesTitle;
   private int volumeNum;
   private int issueNum; 
   private String publicationDate;
   private String creators;
   private String principleCharacters;
   private String description; 

   public Comic(String publisher, String seriesTitle, int volumeNum, int issueNum, String publicationDate, String creators, String principleCharacters, String description){
       this.publisher = publisher;
       this.seriesTitle = seriesTitle;
       this.volumeNum = volumeNum;
       this.issueNum = issueNum;
       this.publicationDate = publicationDate;
       this.creators = creators;
       this.principleCharacters = principleCharacters;
       this.description = description;
   }
   
   }
