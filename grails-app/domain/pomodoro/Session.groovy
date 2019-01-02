package pomodoro

class Session {

    private User user
    private Interval currentInterval = new None()
    public LinkedList<Pomodoro> pomodoros = new LinkedList<Pomodoro>()

    public void start() {
      currentInterval = currentInterval.start()
    }

    public void updateInterval(Interval interval) {
      this.currentInterval = interval
    }

    public void notify(String message) {
      // TO DO: Implement
    }

    public void increasePomodorosInCurrentTask() {
      if (this.board.inProgress != null)
        this.board.inProgress.pomodoros++
    }

    public void calculateProductivityIndex() {
      //double index = 0.75
    }

    public void enterFatigueIndex() {
      // TO DO: Implement
    }

    static constraints = {
    }
}
