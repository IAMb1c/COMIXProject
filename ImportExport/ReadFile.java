package ImportExport;

import java.util.List;

import main.Comic;

/**
 * Target class that contains current data format
 */
public interface ReadFile {
    /**
     * 
     * @param data the data to be converted to new format
     * @return String version in a new format
     */
    public List<Comic> readData();
}
