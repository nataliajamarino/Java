import java.util.*;

public class CountingSort extends Runner {
  /* 
    Implementation of counting sort algorithm
    receives size of input and 
    returns how long it took to run
  */
  @Override
  protected double sort(int size) {
    int[] arr = Utils.randomArray(size);
    Timer.start();
    // Get the max and min value of the array
    int max = Arrays.stream(arr).max().getAsInt(); 
    int min = Arrays.stream(arr).min().getAsInt(); 
    // Get the range between min and max to build counter array
    int range = max - min + 1;
    // Generates the counter array
    int count[] = new int[range]; 
    int output[] = new int[arr.length]; 
    // Count the number of occurencies and add to the counter array
    for (int i = 0; i < arr.length; i++){ 
        count[arr[i] - min]++; 
    } 

    for (int i = 1; i < count.length; i++){ 
        count[i] += count[i - 1]; 
    } 

    // Builds the ouput array based on number of occurencies
    for (int i = arr.length - 1; i >= 0; i--){ 
        output[count[arr[i] - min] - 1] = arr[i]; 
        count[arr[i] - min]--; 
    } 

    // Copy ouput array to the main array to sort it
    for (int i = 0; i < arr.length; i++){ 
        arr[i] = output[i]; 
    } 

    return Timer.end();
  }

  @Override
  protected String getAlgName() {
    return "CountingSort";
  }
}