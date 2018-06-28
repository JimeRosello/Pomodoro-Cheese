package pomodoro

class LeisureActivity extends Activity {

    App.Duration duration;

    public LeisureActivity(String name, App.Duration duration) {
      this.name = name;
      this.duration = duration;
    }

    static constraints = {

    }
}
