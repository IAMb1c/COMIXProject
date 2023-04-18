package SearchSortSubsystem;

import SearchSortSubsystem.ComicSearch.ExactSearch;
import SearchSortSubsystem.ComicSearch.PartialSeach;
import comicDatabaseController.ExportData;
import main.ComicDatabase;

public class Testing {
    private static SearchSorter searchSorter = new SearchSorter();
    private static ExportData database = new ExportData();
    
    /* Testing searching for exact; returns six */
    public static void exactSearch() {
        searchSorter.setSearch(new ExactSearch());
        String term = "'Mazing Man";
        System.out.println("Exact Search 1 Comics" + searchSorter.searchComics(term));
    }
    /* Testing searching for exact; no returns */
    public static void exactSearch2() {
        searchSorter.setSearch(new ExactSearch());
        String term2 = "spider man";
        System.out.println("Exact Search 2 Comics:" + searchSorter.searchComics(term2));
    }
    /* Testing searching for partial; 10 */
    public static void partialSearch1() {
        searchSorter.setSearch(new PartialSeach());
        String term3 = "bishop";
        System.out.println("Partial Search 1 Comics:" + searchSorter.searchComics(term3));
    }
    /* Testing searching for partial; no returns */
    public static void partialSearch2() {
        searchSorter.setSearch(new PartialSeach());
        String term4 = "aaaaaaaaaaaaaaaaaa";
        System.out.println("Partial Search 2 Comics:" + searchSorter.searchComics(term4));
    }
    /* Testing issue sorting */
    /* Testing date sorting */
    /* Testing title sorting */

    public static void main(String[] args) {
        // exactSearch();
        // exactSearch2();
        // partialSearch1();
        // partialSearch2();
        System.out.println(new ComicDatabase().getComics());
    }

}

