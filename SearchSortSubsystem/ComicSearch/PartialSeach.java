package SearchSortSubsystem.ComicSearch;
import java.util.ArrayList;
import java.util.List;

import comicDatabaseController.ExportData;
import main.Comic;

public class PartialSeach implements ComicSearch{
    ExportData database = new ExportData();

    @Override
    public List<Comic> search(String term) {
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
            /** Lenient Search. */
            if (fullTitle.contains(term) || seriesTitle.contains(term) || description.contains(term) || creators.contains(term)) {
                filteredComics.add(comic);
            }
        }

        return filteredComics;
    }
    
    
}
