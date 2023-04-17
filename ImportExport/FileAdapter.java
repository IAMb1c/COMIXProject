package ImportExport;
import java.util.List;
import main.Comic;

/**
 * Delegates file reading to the correct file reader class(CSV, JSON, XML)
 */
public class FileAdapter implements ReadFile{
    private JSONReader JSONReader;
    private XML XMLReader;
    private CSV CSVReader;
    private String fileType;
    private String filename;
    private List<Comic> database;

    public FileAdapter(String fileType, String filename){
        this.fileType = fileType;
        this.filename = filename;
    }

    @Override
    public List<Comic> readData() {
        if(this.fileType.equals("JSON")){
            JSONReader = new JSONReader(this.filename);
            this.database = JSONReader.read();
        }
        else if(this.fileType.equals("XML")){
            XMLReader = new XML(this.filename);
            XMLReader.read();
        }
        else if(this.fileType.equals("CSV")){
            System.out.println("here");
            CSVReader = new  CSV(this.filename);
            this.database = CSVReader.read();
            for(Comic comic : database){
                System.out.println(comic.getSeriesTitle());
            }
            return this.database;
        }
           return null;
        
    }
    
}
