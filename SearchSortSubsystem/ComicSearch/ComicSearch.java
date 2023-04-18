package SearchSortSubsystem.ComicSearch;
import java.util.List;
import main.Comic;

public interface ComicSearch {
    List<Comic> search(String term);
}