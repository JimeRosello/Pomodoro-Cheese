package pomodoro

class None extends Interval {

    public None(Session session) {
      this.session = session
    }

    public Interval start() {
      return new Pomodoro(this.session)
    }

    public int countPomodoros() {
      return 0
    }

    static constraints = {
    }
}
