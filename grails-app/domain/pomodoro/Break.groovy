package pomodoro

import pomodoro.exceptions.*
import java.util.concurrent.TimeUnit
import java.lang.Thread
import java.lang.Runnable

class Break extends Interval {

    LeisureActivity activity
    final String shortBreakNotif = "Time for a short break!"
    final String longBreakNotif = "Time for a long break!"

    public Break(Session session) {
      this.session = session
      if (session.pomodoroCount() % 4 == 0) {
        duration = this.session.user.configuration.longRestDurationInMinutes
        session.notify(longBreakNotif)
      } else {
        session.notify(shortBreakNotif)
        duration = this.session.user.configuration.shortRestDurationInMinutes
      }
    }

    public Interval start() {
      throw new IntervalInCourseException("There is already a Break in course")
    }

    public Interval finish() {
      return new Pomodoro()
    }

    public int countPomodoros() {
      return 0
    }

    static constraints = {
    }
}
