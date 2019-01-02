package pomodoro
import java.util.concurrent.TimeUnit
import java.lang.Thread
import java.lang.Runnable

class Pomodoro extends Interval {

    Task task
    boolean active
    String workNotif = "Time to work!"

    public Pomodoro() {
      //duration = Configuration.workDurationInMinutes
      duration = 1
      active = false
      start()
    }

    public void start() {
      if (!active) {
        //App.notify(workNotif)
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
      //App.pomodoroCount++
      //App.increasePomodorosInCurrentTask()
      //App.updateInterval(new Break())
    }

    static constraints = {
    }
}
