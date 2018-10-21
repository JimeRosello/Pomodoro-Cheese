package pomodoro

class Session {

    private User user 
    private Interval currentInterval = new None() 
    public int pomodoroCount = 0 
    public Board board = new Board() 

    // TO DO: class Library

    //Public enums
    /*static enum Duration {
      LONG,
      SHORT
    } 

    static enum ColorScheme {
    } 

    static enum Feeling {
      UNPRODUCTIVE,
      TIRED,
      MOTIVATED
    } */

    /*static enum Priority {
      TODAY,
      THIS_WEEK,
      THIS_MONTH
    }*/

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
