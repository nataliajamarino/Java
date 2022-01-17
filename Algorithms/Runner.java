abstract public class Runner {
  private double[] times;
  private int numRuns = 10;

  public void run(int[] inputs) {
    this.times = new double[inputs.length];
    for (int i = 0; i < this.numRuns; i++){
      for (int j = 0; j < inputs.length; j++) {
        this.times[j] += sort(inputs[j]);
      }
    }
  }

  public void printResults() {
    String table = getAlgName() + "\t";
    for (int i = 0; i < this.times.length; i++) {
      table += String.format("%.3f\t", this.times[i] / this.numRuns);
    }

    System.out.println(table);
  }

  abstract double sort(int size);
  abstract String getAlgName();
}