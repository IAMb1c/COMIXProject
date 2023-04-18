package SearchSortSubsystem.ComicSearch;
import java.util.ArrayList;
import java.util.List;
import comicDatabaseController.ExportData;
import main.Comic;
import main.ComicDatabase;

public class ExactSearch implements ComicSearch{
    ExportData database = new ExportData();

    @Override
    public List<Comic> search(String term) {
        /** Array */
        List<Comic> filteredComics = new ArrayList<Comic>();
        List<Comic> comics = database.getDatabase();

        term = term.toLowerCase(); // makes it case insensitive
    
        for (Comic comic : comics) {
            String fullTitle = ""; String seriesTitle = ""; String description = ""; String creators = "";
            if (comic.getTitle() != "") {
                fullTitle = comic.getTitle().toLowerCase();
            }
            if (comic.getSeriesTitle() != "") {
                seriesTitle = comic.getSeriesTitle().toLowerCase();
            }
            if (comic.getDescription() != "") {
                description = comic.getDescription().toLowerCase();
            }
            if (comic.getCreators() != "") {
                creators = comic.getCreators().toLowerCase();
            }
            /** Very strict search. Must *BE* the term */
            if (fullTitle.equals(term) || seriesTitle.equals(term) || description.equals(term) || creators.equals(term)) {
                filteredComics.add(comic);
            }
        }

        return filteredComics;
    }
    
}
