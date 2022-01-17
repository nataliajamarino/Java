package ie.gmit.dip;
import java.util.ArrayList;
import java.util.Arrays;

public class MatrixGenerator {
    private String code;
    
    public MatrixGenerator(String code) {
        this.code = code;
    }

    // Method to sort a string alphabetically
    public String sortString(String inputString) {
        // convert input string to char array
        char tempArray[] = inputString.toCharArray();

        // sort tempArray
        Arrays.sort(tempArray);

        // return new sorted string
        return new String(tempArray);
    }

    /**
     * Generate matrix using code and cypher text
     * @param cypherText 
     */
    public Matrix generateMatrix(String cypherText) {
        // Initialize the matrix
        ArrayList<String> firstArray = new ArrayList<>();
        ArrayList<ArrayList<String>> matrix = new ArrayList<>();
        matrix.add(firstArray);
        int indexToAdd = 0;
        
        // First add the code to the first index
        for (int i = 0; i < this.code.length(); i++) {
            matrix.get(indexToAdd).add(Character.toString(this.code.charAt(i)));
        }

        // Then add cypher text letters to the matrix
        for (int i = 0; i < cypherText.length(); i++) {
            // Using code's length to know when to create a new array
            if (i % this.code.length() == 0) {
                // Increment indexToAdd 
                indexToAdd++;
                // Initialize the new array for the index
                matrix.add(new ArrayList<>());
            }
            // Push the cypher text letter to it
            matrix.get(indexToAdd).add(Character.toString(cypherText.charAt(i)));
        }

        Matrix m = new Matrix();
        m.setMatrix(matrix);
        return m;
    }

    /**
     * Generate a decoded matrix base on cypher, for this Matrix the
     * letter are added by column instead by row
     * @param cypherText
     */
    public Matrix generateDecodedMatrix(String cypherText) {
        // Initialize the matrix
        ArrayList<String> firstArray = new ArrayList<>();
        ArrayList<ArrayList<String>> matrix = new ArrayList<>();
        matrix.add(firstArray);
        int indexToAdd = 0;
        String sortedCode = sortString(this.code);

        // First add the reversed code to the first index
        for (int i = 0; i < sortedCode.length(); i++) {
            matrix.get(indexToAdd).add(Character.toString(sortedCode.charAt(i)));
        }

        indexToAdd++;
        // Then add cypher text letters to the matrix
        for (int i = 0; i < cypherText.length(); i++) {
            // Using code's length and cypher length to know when to return to the second index
            if (i % (cypherText.length() / this.code.length()) == 0) {
                // Increment indexToAdd
                indexToAdd = 1;
            }

            if (indexToAdd  >= matrix.size()) {
                // Initialize the new array for the index if it doesnt exist
                matrix.add(new ArrayList<>());
            }

            // Push the cypher text letter to it
            matrix.get(indexToAdd).add(Character.toString(cypherText.charAt(i)));
            indexToAdd++;
        }

        Matrix m = new Matrix();
        m.setMatrix(matrix);
        return m;
    }
}
