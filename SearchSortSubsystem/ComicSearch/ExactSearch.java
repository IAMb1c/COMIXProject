package SearchSortSubsystem.ComicSearch;
import java.util.ArrayList;
import main.Comic;
import main.ComicDatabase;

public class ExactSearch implements ComicSearch{
    ComicDatabase database = new ComicDatabase();

    @Override
    public ArrayList<Comic> search(String term) {
        /** Array */
        ArrayList<Comic> filteredComics = new ArrayList<Comic>();
        ArrayList<Comic> comics = database.getComics();

        term = term.toLowerCase(); // makes it case insensitive
    
        for (Comic comic : comics) {
            String fullTitle = comic.getTitle().toLowerCase();
            String seriesTitle = comic.getSeriesTitle().toLowerCase();
            String description = comic.getDescription().toLowerCase();
            String creators = comic.getCreators().toLowerCase();
            /** Very strict search. Must *BE* the term */
            if (fullTitle.equals(term) || seriesTitle.equals(term) || description.equals(term) || creators.equals(term)) {
                filteredComics.add(comic);
            }
        }

        return filteredComics;
    }
    
}
