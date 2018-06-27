package pomodoro

class App {

    static enum Duration {
      LONG,
      SHORT
    };

    static enum ColorScheme {

    };

    static enum Feeling {
      UNPRODUCTIVE,
      TIRED,
      MOTIVATED
    };

    /*static enum Priority {
      TODAY,
      THIS_WEEK,
      THIS_MONTH
    }*/

    User user;
    Board activityBoard;
    public Interval currentInterval = new None();
    public static int pomodoroCount = 0;

    public App() {
      activityBoard = new Board();
    }

    public start() {
      currentInterval = currentInterval.start();
    }

    public static updateInterval(Interval interval) {
      App.currentInterval = interval;
    }

    static constraints = {
    }
}
