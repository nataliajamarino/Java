// Class to calculate time elapsed in milliseconds
public class Timer {
  private static long start;

  public static void start () {
    Timer.start = System.nanoTime();
  }

  public static double end() {
    long end = System.nanoTime();
    long timeElapsed = end - Timer.start;

    return timeElapsed / 1000000.0;
  }
}