package pomodoro

class LeisureActivity extends Activity {

    Duration duration

    public LeisureActivity(String name, Duration duration) {
      this.name = name
      this.duration = duration
    }

    static constraints = {
    }
}
