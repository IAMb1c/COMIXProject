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
            String fullTitle = comic.getTitle().toLowerCase();
            String seriesTitle = comic.getSeriesTitle().toLowerCase();
            String description = comic.getDescription().toLowerCase();
            String creators = comic.getCreators().toLowerCase();
            /** must just contain the sequence of characters to be counted */
            if (fullTitle.contains(term) || seriesTitle.contains(term) || description.contains(term) || creators.contains(term)) {
                filteredComics.add(comic);
            }
        }

        return filteredComics;
    }
    
    
}
