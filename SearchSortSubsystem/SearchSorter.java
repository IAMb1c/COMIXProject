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
    /* The comix database now does not need to know/make the individual searches */
    public void setExactSearch() {
        this.searcher = new ExactSearch();
    }
    public void setPartialSearch() {
        this.searcher = new PartialSeach();
    }
    public void setIssueSort() {
        this.sorter = new IssueSort();
    }
    public void setPubDateSort() {
        this.sorter = new PublicationDateSort();
    }
    public void setTitleSort() {
        this.sorter = new TitleSort();
    }

    public List<Comic> searchComics(String[] SIP) {
        return searcher.search(SIP);
    }
    public List<Comic> sortComics(List<Comic> comics) {
        return sorter.sort(comics);
    }
}
