package ie.gmit.dip;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Cypher table used to code / decode
 *      A D F G V X
    A | p h 0 q g 6
    D | 4 m e a 1 y
    F | l 2 n o f d
    G | x k r 3 c v
    V | s 5 z w 7 b
    X | j 9 u t i 8
 */
public class PolybiusSquare {
    // Build cypher table using HashMap
    private static Map<String, String> charMap;
    static {
        charMap = new HashMap<>();
        charMap.put("P", "AA");
        charMap.put("H", "AD");
        charMap.put("0", "AF");
        charMap.put("Q", "AG");
        charMap.put("G", "AV");
        charMap.put("6", "AX");
        charMap.put("4", "DA");
        charMap.put("M", "DD");
        charMap.put("E", "DF");
        charMap.put("A", "DG");
        charMap.put("1", "DV");
        charMap.put("Y", "DX");
        charMap.put("L", "FA");
        charMap.put("2", "FD");
        charMap.put("N", "FF");
        charMap.put("O", "FG");
        charMap.put("F", "FV");
        charMap.put("D", "FX");
        charMap.put("X", "GA");
        charMap.put("K", "GD");
        charMap.put("R", "GF");
        charMap.put("3", "GG");
        charMap.put("C", "GV");
        charMap.put("V", "GX");
        charMap.put("S", "VA");
        charMap.put("5", "VD");
        charMap.put("Z", "VF");
        charMap.put("W", "VG");
        charMap.put("7", "VV");
        charMap.put("B", "VX");
        charMap.put("J", "XA");
        charMap.put("9", "XD");
        charMap.put("U", "XF");
        charMap.put("T", "XG");
        charMap.put("I", "XV");
        charMap.put("8", "XX");
    }
    
    /**
     * Return the code based in the char and in the cypher table
     * To get the code by letter:
     * To encode a plaintext character using the Polybius Square, locate the character in the
     *  matrix and read off the letter on the far left side on the same row and then the letter
     *  at the top of the same column
     * @param key
     */
    public static String getCharCode(char key) {
        return PolybiusSquare.charMap.get(
            Character.toString(key).toUpperCase()
        );
    }

    /**
     * Return the char corresponding the CODE, example: XD = 9
     * @param code
     */
    public static String getDecodedCharCode(String code) {
        Map<String, String> charMap = PolybiusSquare.charMap;
        Collection<String> charValues = charMap.values();
        // Loop through char values to find the code pair
        for (String character : charValues) {
            if (code.equals(character)) {
                // Return the key value for the corresponded code
                for (Map.Entry<String, String> entry : charMap.entrySet()) {
                    if (Objects.equals(character, entry.getValue())) {
                        return entry.getKey();
                    }
                }
            }
        }

        // Code not found, throwing an error
        throw new Error("Couldn't find char " + code);
    }
}
