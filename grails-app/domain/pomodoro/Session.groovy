package pomodoro

class Session {

    private Session instance = null
    private User user
    private Interval currentInterval = new None(this)
    public LinkedList<Interval> intervals = new LinkedList<Interval>()
    //public LinkedList<Pomodoro> pomodoros = new LinkedList<Pomodoro>()

    private Session() { }

    public Session getSession() {
      if (instance == null) {
        instance = new Session()
      }
      return instance
    }

    // Starts a new Pomodoro interval
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
