package pomodoro

import pomodoro.exceptions.*

class Session {

    private User user
    private Interval currentInterval = new None(this)
    public LinkedList<Interval> intervals = new LinkedList<Interval>()

    public Session(String username) {
      //user = findByUsername(username)
    }

    // Starts a new Pomodoro interval or throws error if an existent cycle is running
    public void start() {
      try {
        currentInterval = currentInterval.start()
      }
      catch (IntervalInCourseException e) {
        notify(e.message)
      }
      while (currentInterval.continues()) {
        while (LocalDateTime.now() != currentInterval.endTime) {
          continue
        }
        currentInterval = currentInterval.finish().start()
      }
    }

    // Stops the current interval and stops the ongoing cycle
    public void stop() {
      currentInterval = currentInterval.stop()
    }

    public void updateInterval(Interval interval) {
      this.currentInterval = interval
    }

    public void notify(String message) {
      //(new Notification(message)).show()
    }

    public int pomodoroCount() {
      int count = 0
      this.intervals.each {
        x -> count = count + x.countPomodoros()
      }
      return count
    }

    static constraints = {
    }
}
