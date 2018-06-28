package pomodoro
import java.util.concurrent.TimeUnit

class Pomodoro extends Interval {

    Task task;
    boolean active;

    public Pomodoro() {
      duration = Configuration.workDurationInMinutes;
      active = false;
      start();
    }

    public void start() {
      if (!active) {
        active = true;
        long startTime = System.currentTimeMillis();
        long endTime = startTime + duration;// * 60 * 1000;
        TimeUnit.MILLISECONDS.sleep(duration);
        finish();
      }
    }

    public void finish() {
      active = false;
      App.pomodoroCount++;
      //App.updateInterval(new Break());
    }

    static constraints = {
    }
}
