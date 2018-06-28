package pomodoro

class App {

    private User user;
    private static Interval currentInterval = new None();
    public static int pomodoroCount = 0;
    public static Board board = new Board();
    public static Configuration configuration = new Configuration(); 

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

    public static void notify(String message) {
      // TO DO: Implement
    }

    public static void increasePomodorosInCurrentTask() {
      if (App.board.inProgress != null)
        App.board.inProgress.pomodoros++;
    }

    static constraints = {
    }
}
