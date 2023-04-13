public class ComicDatabase{
    private ArrayList<Comic> comics;

    public ComicDatabase(csv){
        this.csv = csv;
    }

    public void ReadCSV(csv){
        try (BufferedReader reader = new BufferedReader(new FileReader(csv))) {
            String line;
            boolean isFirstLine = true; // Skip the header line
            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                
                String[] fields = line.split(",");
                Comic comic = new Comic();
                comic.setSeries(fields[0]);
                comic.setIssueNumber(fields[1]);
                comic.setSeriesTitle(fields[2]);
                comic.setDescription(fields[3]);
                comic.setPublisher(fields[4]);
                comic.setPublicationDate(fields[5]);
                comic.setFormat(fields[6]);
                comic.setCreators(fields[8]);

                comics.add(comic);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Comic> getComics(){
        return this.comics;
    }
}