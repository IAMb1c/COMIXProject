package SearchSortSubsystem.ComicSearch;
import java.util.ArrayList;
import main.Comic;

public interface ComicSearch {
    ArrayList<Comic> search(String term);
}