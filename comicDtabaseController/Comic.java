package comicDtabaseController;
import java.util.Properties;

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
   public String getSeriesTitle(){
       return this.seriesTitle;
   }
   
   }
