package ie.gmit.dip;

import java.util.ArrayList;
import java.util.Map;

/**
 * Class to hold the value of the hashMap for the converted Matrix
 * Created to be able to use the Comparable interface
 */
public class MatrixMap implements Comparable<MatrixMap> {
    private Map<String, ArrayList<String>> map;

    public void setMap(Map<String, ArrayList<String>> map) {
        this.map = map;
    }

    public Map<String, ArrayList<String>> getMap() {
        return map;
    }

    @Override
    public String toString() {
        return "" + map;
    }

    /**
     * Compare the key vales of the map and sort alphabetically
     * @param o
     * @return (int}
     */
    @Override
    public int compareTo(MatrixMap o) {
        // Convert keys to string to be able to compare values
        String keyA = this.getMap().keySet().toArray()[0].toString();
        String keyB = o.getMap().keySet().toArray()[0].toString();

        return keyA.compareTo(keyB);
    }
}
