public class PersonalCollectionView implements SystemViews {
    
    static String PCFile = "../personalCollection.csv";
    
    private String view;

    public void view() {
        System.out.println("Personal Collection View");
    }

    @Override
    // for the personal collection view we could just show the number of personal collection items
    public String readDatabase(String filename) {
        // TODO Capturing use commands here ?
        return null;
    }
}