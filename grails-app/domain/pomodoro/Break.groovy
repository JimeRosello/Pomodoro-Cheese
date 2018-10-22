package pomodoro
import java.util.concurrent.TimeUnit
import java.lang.Thread
import java.lang.Runnable

class Break extends Interval {

    LeisureActivity activity
    boolean active
    String shortBreakNotif = "Time for a short break!"
    String longBreakNotif = "Time for a long break!"

    public Break() {
      //if ((App.pomodoroCount % 4) == 0) {
      //  App.notify(longBreakNotif)
      //  duration = Configuration.longRestDurationInMinutes
      //} else {
      //  App.notify(shortBreakNotif)
      //  duration = Configuration.shortRestDurationInMinutes
      //}
      active = false 
      start()
    }

    public void start() {
      if (!active) {
        active = true
        long startTime = System.currentTimeMillis()
        endTime = startTime + duration * 60 * 1000
        Runnable wait = new Runnable() {
          public void run() {
              TimeUnit.MILLISECONDS.sleep(duration)
              finish()
          }
        }
        new Thread(wait).start()
      }
    }

    public void finish() {
      active = false
      //App.updateInterval(new Pomodoro())
    }

    static constraints = {
    }
}
