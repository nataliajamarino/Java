package ie.gmit.dip;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Class Matrix to hold generated matrix
 */
public class Matrix  {
    private ArrayList<ArrayList<String>> matrix;

    public void setMatrix(ArrayList<ArrayList<String>> matrix) {
        this.matrix = matrix;
    }

    public ArrayList<ArrayList<String>> getMatrix() {
        return this.matrix;
    }

    /**
     * Convert matrix to a Map, eg: [[1, 2, 3], [a, b, c]]
     * would return [{1: [a]}, {2: [b]}, {3: [c]}]
     */
    public ArrayList<MatrixMap> convertToMap() {
        ArrayList<MatrixMap> map = new ArrayList<>();
        for (int i = 0; i < this.matrix.size(); i++) {
            for (int j = 0; j < this.matrix.get(i).size(); j++) {
                Map<String, ArrayList<String>> key = new HashMap<>();
                key.put(this.matrix.get(i).get(j), new ArrayList<>());
                // Loop through all array ignoring the first index that contains the code and pick
                // the column values
                for (int k = 1; k < this.matrix.size(); k++) {
                    key.get(this.matrix.get(i).get(j)).add(this.matrix.get(k).get(j));
                }
                MatrixMap matrixMap = new MatrixMap();
                matrixMap.setMap(key);
                map.add(matrixMap);
            }
            // Break the loop
            break;
        }

        return map;
    }
}
