public class BubbleSort extends Runner {
  /* 
    Implementation of bubble sort algorithm
    receives size of input and 
    returns how long it took to run
  */
  @Override
  protected double sort(int size) {
    int[] arr = Utils.randomArray(size);
    Timer.start();
    int n = arr.length;
    // Start looping through the array
    for (int i = 0; i < n-1; i++){
      // Inner loop to compare against the number at position i
      for (int j = 0; j < n-i-1; j++) {
        // If i > j swap positions
        if (arr[j] > arr[j+1]) { 
              // swap arr[j+1] and arr[i] 
              int temp = arr[j]; 
              arr[j] = arr[j+1]; 
              arr[j+1] = temp; 
          }
      }
    }
    return Timer.end();
  }

  @Override
  protected String getAlgName() {
    return "BubbleSort";
  }
}