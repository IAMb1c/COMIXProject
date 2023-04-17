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
            /** Very strict search. Must *BE* the term */
            if (fullTitle.equals(term) || seriesTitle.equals(term) || description.equals(term) || creators.equals(term)) {
                filteredComics.add(comic);
            }
        }

        return filteredComics;
    }
    
    
}
