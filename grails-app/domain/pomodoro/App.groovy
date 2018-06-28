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
    public Interval currentInterval = new None();
    public static int pomodoroCount = 0;
    Board board = new Board(); 

    public void start() {
      currentInterval = currentInterval.start();
    }

    public static void updateInterval(Interval interval) {
      App.currentInterval = interval;
    }

    static constraints = {
    }
}
