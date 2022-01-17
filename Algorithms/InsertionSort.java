public class InsertionSort extends Runner {
  /* 
    Implementation of insertion sort algorithm
    receives size of input and 
    returns how long it took to run
  */
  @Override
  protected double sort(int size) {
    int[] arr = Utils.randomArray(size);
    Timer.start();
    int n = arr.length; 
    for (int i = 1; i < n; ++i) { 
      int key = arr[i]; 
      int j = i - 1; 

      /* Move elements of arr[0..i-1], that are 
          greater than key, to one position ahead 
          of their current position */
      while (j >= 0 && arr[j] > key) { 
          arr[j + 1] = arr[j]; 
          j = j - 1; 
      } 
      arr[j + 1] = key; 
    }
    return Timer.end();
  }

  @Override
  protected String getAlgName() {
    return "InsertionSort";
  }
}