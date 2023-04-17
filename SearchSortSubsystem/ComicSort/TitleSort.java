package SearchSortSubsystem.ComicSort;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import main.Comic;

public class TitleSort implements ComicSort {

    @Override
    public ArrayList<Comic> sort(ArrayList<Comic> filteredComics) {
        Collections.sort(filteredComics, new Comparator<Comic>() {
            public int compare(Comic c1, Comic c2) {
                // Sorting in ascending order
                return c1.getTitle().compareTo(c2.getTitle());
            }
        });
        return filteredComics;
    }
    
}
