package pomodoro

import pomodoro.exceptions.*
import java.util.concurrent.TimeUnit
import java.lang.Thread
import java.lang.Runnable
import IntervalInCourseException.*

class Pomodoro extends Interval {

    Task task
    final String workNotif = "Time to work!"

    public Pomodoro() {
      duration = 1
      session.notify(workNotif)
      long startTime = System.currentTimeMillis()
      endTime = startTime + duration * 60 * 1000
    }

    public Interval start() {
        // Runnable wait = new Runnable() {
        //   public void run() {
        //       TimeUnit.MILLISECONDS.sleep(duration)
        //       finish()
        //   }
        // }
        // new Thread(wait).start()
      throw new IntervalInCourseException("There is already a Pomodoro in course")
    }

    public Interval finish() {
      return new Break(this.session)
    }

    static constraints = {
    }
}
