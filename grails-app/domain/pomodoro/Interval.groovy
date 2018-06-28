package pomodoro

abstract class Interval {

    int duration;
    long endTime = 9999999;

    public abstract void start();

    public long remainingTime() {
      return endTime - System.currentTimeMillis();
    }

    static constraints = {
    }
}
