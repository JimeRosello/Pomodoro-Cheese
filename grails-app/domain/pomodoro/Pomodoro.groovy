package pomodoro
import java.util.concurrent.TimeUnit
import java.lang.Thread
import java.lang.Runnable

class Pomodoro extends Interval {

    Task task
    boolean active
    final String workNotif = "Time to work!"

    public Pomodoro() {
      duration = 1
      active = false
      start()
    }

    public Interval start() {
      if (!active) {
        session.notify(workNotif)
        active = true
        long startTime = System.currentTimeMillis()
        endTime = startTime + duration * 60 * 1000
        // Runnable wait = new Runnable() {
        //   public void run() {
        //       TimeUnit.MILLISECONDS.sleep(duration)
        //       finish()
        //   }
        // }
        // new Thread(wait).start()
      }
    }

    public void finish() {
      active = false
    }

    static constraints = {
    }
}
