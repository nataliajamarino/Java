package ie.gmit.dip;
import java.util.ArrayList;
import java.util.Map;

public class Cypher {
    private final String cryptKey = "JAVA";
    
    public String encrypt(String message) {
        // Remove whitespaces from the message
        message = message.replaceAll("\\s+","");
        String cypherText = "";
        // loop through all letter and search in the cypher table
        for(int i = 0 ; i < message.length() ; i++) { 
            char letter = message.charAt(i); 

            // Get codified version of the letter
            cypherText += PolybiusSquare.getCharCode(letter);
        }
        MatrixGenerator m = new MatrixGenerator(this.cryptKey);
        Matrix matrix = m.generateMatrix(cypherText);
        // Convert matrix to map using code letters
        ArrayList<MatrixMap> cypherMap = matrix.convertToMap();
        // Sort map using columnar transposition
        ArrayList<MatrixMap> sortedMap = ColumnarTransposition.sort(cypherMap);

        String cypheredMessage = "";
        // Print the sorted map which is the cyphered message
        for (MatrixMap value : sortedMap) {
            // Get map to loop through
            Map<String, ArrayList<String>> key = value.getMap();
            for (int i = 0; i < key.size(); i++) {
                // Get key name dynamically
                ArrayList<String> letters = key.get(key.keySet().toArray()[0].toString());
                // Using reduce to reduce array list to string
                cypheredMessage += letters.stream().reduce((a, b) -> a + b).get();
            }
        }
        return cypheredMessage;
    }

    /**
     * Decrypt decyphered text
     * @param message
     * @return
     */
    public String decrypt(String message) {
        // Generate Matrix for decoding
        MatrixGenerator m = new MatrixGenerator(this.cryptKey);
        Matrix matrix = m.generateDecodedMatrix(message);
        // Convert matrix to map using code letters
        ArrayList<MatrixMap> cypherMap = matrix.convertToMap();
        // Sort map using columnar transposition
        ArrayList<MatrixMap> unsortedMap = ColumnarTransposition.unsort(cypherMap, this.cryptKey);

        // Return the decoded string
        return decodeCypher(unsortedMap);
    }

    /**
     * Decode message using map of codes
     * @param unsortedMap
     * @return
     */
    private String decodeCypher(ArrayList<MatrixMap> unsortedMap) {
        // Start to generate decoded text
        String cypherText = "";

        int indexToGet = 0;
        Map.Entry<String, ArrayList<String>> entry = unsortedMap.get(0).getMap().entrySet().iterator().next();
        String key = entry.getKey();
        // Get number of columns in the array map
        int columns = unsortedMap.get(0).getMap().get(key).size();
        int column = 0;
        // for (let i = 0; i < unsortedMap.length; i++) {
        while(column < columns){
            // Using code's length to know when to return to the second index
            for (int i = 0; i < unsortedMap.size(); i++) {
                if (i % (this.cryptKey.length()) == 0) {
                    indexToGet = 0;
                }

                // Push the cypher text letter to it
                for (int j = 0; j < this.cryptKey.length(); j++) {
                    // Get value using column and row
                    Map<String, ArrayList<String>> map = unsortedMap.get(indexToGet).getMap();
                    // Get key name
                    String row = map.entrySet().iterator().next().getKey();
                    cypherText += map.get(row).get(column);
                    break;
                }
                indexToGet++;
            }

            column++;
        }

        String decodedMessage = "";
        // Decode message looping two by two letters
        for (int i = 0; i < cypherText.length(); i = i + 2) {
            // Get code pairs
            String code = Character.toString(cypherText.charAt(i)) + Character.toString(cypherText.charAt(i+1));
            // Get decoded code and append to result string
            decodedMessage += PolybiusSquare.getDecodedCharCode(code);
        }

        return decodedMessage;
    }
}
