package SearchSortSubsystem.ComicSearch;
import java.util.ArrayList;
import java.util.List;

import comicDatabaseController.ExportData;
import main.Comic;

public class PartialSeach implements ComicSearch{
    ExportData database = new ExportData();

    @Override
    public List<Comic> search(String[] SIP) {
        List<Comic> filteredComics = new ArrayList<Comic>();
        List<Comic> comics = database.getDatabase();

        String seriesTerm = SIP[0].toLowerCase();
        String issueTerm = SIP[1];
        String pubDateTerm = SIP[2];
    
        for (Comic comic : comics) {
            String seriesTitle = ""; String issue = ""; String pubDate = "";
            if (comic.getSeriesTitle() != "") {
                seriesTitle = comic.getSeriesTitle().toLowerCase();
            }
            if (comic.getIssue() != "") {
                issue = comic.getIssue();
            }
            if (comic.getPublicationDate() != "") {
                pubDate = comic.getPublicationDate();
            }
            /** Very strict search. Must *BE* the term */
            if (seriesTitle.contains(seriesTerm) || issue.contains(issueTerm) || pubDate.contains(pubDateTerm)) {
                filteredComics.add(comic);
            }
        }

        return filteredComics;
    }
    
    
}
