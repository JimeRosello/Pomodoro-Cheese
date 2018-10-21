package pomodoro

class LeisureActivity extends Activity {

    Library.Duration duration

    public LeisureActivity(String name, Library.Duration duration) {
      this.name = name
      this.duration = duration
    }

    static constraints = {

    }
}
