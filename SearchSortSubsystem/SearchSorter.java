package SearchSortSubsystem;
import SearchSortSubsystem.ComicSort.*;
import comicDatabaseController.ImportData;
import main.Comic;

import java.util.ArrayList;
import java.util.List;

import SearchSortSubsystem.ComicSearch.*;

/** In the strategy pattern, this is the context: it has access to the separate searches and sorts. */
public class SearchSorter {
    private ComicSearch searcher;
    private ComicSort sorter;

    public void setSearch(ComicSearch newSearcher) {
        this.searcher = newSearcher;
    }
    public void setSort(ComicSort newSorter) {
        this.sorter = newSorter;
    }

    public List<Comic> searchComics(String term) {
        return searcher.search(term);
    }
    public List<Comic> sortComics(List<Comic> comics) {
        return sorter.sort(comics);
    }
}
