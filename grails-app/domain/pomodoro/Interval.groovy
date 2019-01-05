package pomodoro

import java.time.LocalDateTime

abstract class Interval {

    int duration
    LocalDateTime startTime
    LocalDateTime endTime
    Session session
    // buscar jodatime o el api nueva de java8
    // local date time

    public Interval(Session session) {
      this.session = session
    }

    public abstract Interval start()

    public long remainingTime() {
      return endTime - System.currentTimeMillis()
    }

    public abstract int countPomodoros()

    static constraints = {
    }
}
