package pomodoro

class None extends Interval {

    public Interval start() {
      return new Pomodoro(this.session)
    }

    static constraints = {
    }
}
