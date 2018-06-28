package pomodoro
import java.util.concurrent.TimeUnit

class Break extends Interval {

    LeisureActivity activity;
    boolean active;

    public Break() {
      if ((App.pomodoroCount % 4) == 0)
        duration = Configuration.longRestDurationInMinutes;
      else
        duration = Configuration.shortRestDurationInMinutes;
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

      //App.updateInterval(new Pomodoro());
    }

    static constraints = {
    }
}
