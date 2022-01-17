public class Utils {
  // Generates array with random integers of size n
  public static int[] randomArray(int n) {
    int[] array = new int[n];
    for (int i = 0; i < n; i++) {
      array[i] = (int) (Math.random() * 100);
    }

    return array;
  }
}