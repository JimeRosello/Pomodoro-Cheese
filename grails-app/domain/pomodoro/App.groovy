package pomodoro

class App {

    User user;
    static Interval currentInterval = new None();
    public static int pomodoroCount = 0;
    Board board = new Board();

    // Public enums
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

    public void start() {
      currentInterval = currentInterval.start();
    }

    public static void updateInterval(Interval interval) {
      App.currentInterval = interval;
    }

    static constraints = {
    }
}
