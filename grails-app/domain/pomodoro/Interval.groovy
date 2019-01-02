package pomodoro

abstract class Interval {

    int duration
    long endTime = 9999999
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

    static constraints = {
    }
}
