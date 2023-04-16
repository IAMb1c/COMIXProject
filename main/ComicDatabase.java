package main;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.util.Arrays;
import java.io.FileReader;
import java.io.IOException;
import comicDatabaseController.ImportData;
import comicDatabaseController.ModifyCommand;

public class ComicDatabase {
    private ArrayList<Comic> comics;
   // private String csv;

    public ComicDatabase(){
        this.comics = new ArrayList<>();
    }
    public ArrayList<Comic> getComics(){
        ModifyCommand data = new ImportData(new ArrayList<>(), comics);
        data.executeCommand();
        return comics;
    }
    // public void ReadCSV(){
    //     try (BufferedReader reader = new BufferedReader(new FileReader(csv))) {
    //         String line;
    //         boolean isFirstLine = true; // Skip the header line
    //         while ((line = reader.readLine()) != null) {
    //             if (isFirstLine) {
    //                 isFirstLine = false;
    //                 continue;
    //             }
                
    //             String[] fields = line.split(",");
    //             Comic comic = new Comic();
    //             //comic.setSeries((Integer.valueOf(fields[0])));
    //             comic.setIssueNumber(Integer.valueOf(fields[1]));
    //             comic.setSeriesTitle(fields[2]);
    //             comic.setDescription(fields[3]);
    //             comic.setPublisher(fields[4]);
    //             comic.setPublicationDate(fields[5]);
    //            // comic.setFormat(fields[6]);
    //             comic.setCreators(new ArrayList<String>(Arrays.asList(fields[8].split(","))));

    //             comics.add(comic);
    //         }
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
    // }

    
    
}
