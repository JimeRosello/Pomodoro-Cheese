package pomodoro

import pomodoro.exceptions.*

class Pomodoro extends Interval {

    Task task
    final String workNotif = "Time to work!"

    public Pomodoro(Session session) {
      this.session = session
      this.session.notify(workNotif)
      duration = 1
      startTime = LocalDateTime.now()
      endTime = startTime.plusMinutes(duration * 60 * 1000)
    }

    public Interval start() {
      throw new IntervalInCourseException("There is already a Pomodoro in course")
    }

    public Interval finish() {
      return new Break(this.session)
    }

    public int countPomodoros() {
      return 1
    }

    static constraints = {
    }
}
