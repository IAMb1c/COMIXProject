package SearchSortSubsystem.ComicSearch;
import java.util.ArrayList;
import main.Comic;
import main.ComicDatabase;

public class PartialSeach implements ComicSearch{
    ComicDatabase database = new ComicDatabase();

    @Override
    public ArrayList<Comic> search(String term) {
        ArrayList<Comic> filteredComics = new ArrayList<Comic>();
        ArrayList<Comic> comics = database.getComics();

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
