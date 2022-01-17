public class Tester {
  public void start () {
    System.out.println("STARTING TESTS");
    // Set inputs to be used
    int[] inputs = new int[] {100, 250, 500, 750, 1000, 1250, 2500, 3750, 5000, 6250, 7500, 8750, 10000};

    // Run tests
    BubbleSort b = new BubbleSort();
    b.run(inputs);

    MergeSort m = new MergeSort();
    m.run(inputs);

    CountingSort c = new CountingSort();
    c.run(inputs);

    InsertionSort i = new InsertionSort();
    i.run(inputs);

    SelectionSort s = new SelectionSort();
    s.run(inputs);

    printSizes(inputs);
    b.printResults();
    m.printResults();
    c.printResults();
    i.printResults();
    s.printResults();
    System.out.println("FINISHED ");
  }

  private void printSizes(int[] sizes) {
    System.out.print("Sizes\t\t");
    for (int i = 0; i < sizes.length; i++) {
      System.out.print(sizes[i] + "\t");
    }
    System.out.println("");
  }
}