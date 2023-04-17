package PersonalCollection;

import main.Comic;

public class PersonalCollectionItems {
    public int personalCollectionId;
    public Comic comic;

    public PersonalCollectionItems( int personalCollectionId, Comic comic ) {
        this.personalCollectionId = personalCollectionId;
        this.comic = comic;
    }

    public int getId() {
        return personalCollectionId;
    }
    public Comic getComic() {
        return comic;
    }
    public void setValue( String[] value ) {
        comic.setValue( value );
    }
    public void addValue( String value ) {
        comic.addValue( value );
    }
    public void setSpecificValue( int index, String value ) {
        comic.setSpecificValue( index, value );
    }
}
