package ie.gmit.dip;

import java.util.ArrayList;
import java.util.Collections;

public class ColumnarTransposition {
    /**
     * Sort the hash map
     * @param cypherMap
     */
    public static ArrayList<MatrixMap> sort(ArrayList<MatrixMap> cypherMap) {
        // Sort the matrix using key for comparison
        Collections.sort(cypherMap);

        return cypherMap;
    }

    /**
     * Unsort map code values
     * @param cypherMap
     * @param code
     * @return
     */
    public static ArrayList<MatrixMap> unsort(ArrayList<MatrixMap> cypherMap, String code) {
        ArrayList<MatrixMap> result = new ArrayList<>();
        ArrayList<Integer> indexUsed = new ArrayList<>();
        for (int i = 0; i < code.length(); i++) {
            // Find the letter in the map and push to the results array
//            int index = cypherMap.stream().findFirst((v) -> v.get == Character.toString(code.charAt(i)) && !indexUsed.includes(index));
            int index = findIndex(cypherMap, Character.toString(code.charAt(i)), indexUsed);
            indexUsed.add(index);
            result.add(cypherMap.get(index));
        }

        return result;
    }

    /**
     * Find the index value of the array list where key = param key
     * @param cypherMap
     * @param key
     * @return
     */
    public static int findIndex(ArrayList<MatrixMap> cypherMap, String key, ArrayList<Integer> indexUsed) {
        for (int i = 0; i < cypherMap.size(); i++) {
            MatrixMap matrix = cypherMap.get(i);
            String keyMap = matrix.getMap().keySet().toArray()[0].toString();

            if (keyMap.equals(key) && !indexUsed.contains(i)) {
                return i;
            }
        }

        return -1;
    }
}
