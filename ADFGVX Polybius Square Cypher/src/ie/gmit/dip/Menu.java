package ie.gmit.dip;
import java.util.*;

/**
 * Class to handle application Menu
 */
public class Menu {
    private Scanner in;
    private boolean keepRunning = true;
    private Cypher c = new Cypher();

    public void start() {
        in = new Scanner(System.in);

        System.out.println("###################################################");
        System.out.println("#          Polybius Square Cypher v.1.0           #");
        System.out.println("###################################################");
        while (keepRunning) {
            showOptions();
            try {
                int selection = Integer.parseInt(in.next());

                if (selection == 1) {
                    // Encrypt
                    encrypt();
                } else if(selection == 2) {
                    // Decrypt
                    decrypt();
                }  else if(selection == 3) {
                    // Stop application
                    keepRunning = false;
                } else {
                    // Invalid choice
                    System.out.println("Invalid choice");
                }
            } catch (Exception exception) {
                // Invalid choice
                System.out.println("Invalid choice");
            }
        }
    }

    /**
     * Show menu options to the user
     */
    private void showOptions() {
        System.out.println("(1) Encrypt");
        System.out.println("(2) Decrypt");
        System.out.println("(3) Quit");
        System.out.println("Select an option between (1-3)>");
    }

    /**
     * Handle encrypt menu choice
     */
    private void encrypt() {
        System.out.println("Enter phrase to encrypt>");
        Scanner scan = new Scanner(System.in);
        String input = "";

        // Handle spaces in the input
        input += scan.nextLine();
        System.out.println("Phrase encrypted: " + c.encrypt(input));
    }

    /**
     * Handle decrypt menu choice
     */
    private void decrypt() {
        // Get user typed code
        System.out.println("Enter code to decrypt>");
        String message = in.next();
        System.out.println("Phrase decrypted: " + c.decrypt(message));
    }
}
