package SearchSortSubsystem;

import SearchSortSubsystem.ComicSearch.ExactSearch;
import SearchSortSubsystem.ComicSearch.PartialSeach;

public class Testing {
    private static SearchSorter searchSorter = new SearchSorter();
    
    /* Testing searching for exact; returns six */
    public static void exactSearch() {
        searchSorter.setSearch(new ExactSearch());
        String term = "'Mazing Man";
        System.out.println("Comics" + searchSorter.searchComics(term));
    }
    /* Testing searching for exact; no returns */
    public static void exactSearch2() {
        searchSorter.setSearch(new ExactSearch());
        String term = "spider man";
        System.out.println("Comics:" + searchSorter.searchComics(term));
    }
    /* Testing searching for partial; 10 */
    public static void partialSearch1() {
        searchSorter.setSearch(new PartialSeach());
        String term = "bishop";
        System.out.println("Comics:" + searchSorter.searchComics(term));
    }
    /* Testing searching for partial; no returns */
    public static void partialSearch2() {
        searchSorter.setSearch(new PartialSeach());
        String term = "aaaaaaaaaaaaaaaaaa";
        System.out.println("Comics:" + searchSorter.searchComics(term));
    }
    /* Testing issue sorting */
    /* Testing date sorting */
    /* Testing title sorting */

    public static void main(String[] args) {
        exactSearch();
        exactSearch2();
        partialSearch1();
        partialSearch2();
    }

}

