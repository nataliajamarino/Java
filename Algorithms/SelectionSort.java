public class SelectionSort extends Runner {
  /* 
    Implementation of selection sort algorithm
    receives size of input and 
    returns how long it took to run
  */
  @Override
  protected double sort(int size) {
    int[] arr = Utils.randomArray(size);
    Timer.start();
    int n = arr.length; 
  
    // One by one move boundary of unsorted subarray 
    for (int i = 0; i < n-1; i++) { 
      // Find the minimum element in unsorted array 
      int min_idx = i; 
      for (int j = i+1; j < n; j++) 
          if (arr[j] < arr[min_idx]) 
              min_idx = j; 

      // Swap the found minimum element with the first 
      // element 
      int temp = arr[min_idx]; 
      arr[min_idx] = arr[i]; 
      arr[i] = temp; 
    }
    return Timer.end();
  }

  @Override
  protected String getAlgName() {
    return "SelectionSort";
  }
}