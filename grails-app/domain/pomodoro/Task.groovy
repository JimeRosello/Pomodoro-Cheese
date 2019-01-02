package pomodoro

class Task extends Activity {

  Set<Pomodoro> pomodoros
  int estimatedPomodoros
  int priority

  public Task(String name, int estimatedPomodoros) {
    this.pomodoros = new HashSet<>()
    this.name = name
    this.estimatedPomodoros = estimatedPomodoros
  }

  public void complete() {

  }

  public int pomodoros() {
    return pomodoros.size()
  }

  public void add(Pomodoro pomodoro) {
    pomodoros.add(pomodoro)
  }

  static constraints = {
  }

}
