package util;

public class TimeUtils {
    public static long start() {
        return System.nanoTime();
    }

    public static long end() {
        return System.nanoTime();
    }

    public static long toMillis(long s, long e) {
        return e - s;
    }

    public static double toSeconds(long start, long end) {
        double elapsedTime = (double) end - (double) start;
        return elapsedTime / 1_000_000_000;
    }
}
