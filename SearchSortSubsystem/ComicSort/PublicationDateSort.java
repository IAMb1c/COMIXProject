package SearchSortSubsystem.ComicSort;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import main.Comic;

public class PublicationDateSort implements ComicSort {

    @Override
    public List<Comic> sort(List<Comic> filteredComics) {
        Collections.sort(filteredComics, new Comparator<Comic>() {
            public int compare(Comic c1, Comic c2) {
                DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM dd, yyyy");
                LocalDate date1 = LocalDate.parse(c1.getPublicationDate(), format);
                LocalDate date2 = LocalDate.parse(c2.getPublicationDate(), format);
                return date1.compareTo(date2);
            }
        });
        return filteredComics;
    }
    
}
