package pomodoro

class Task extends Activity {

    int pomodoros = 0 
    //Set<Pomodoro> pomodoros
    int estimatedPomodoros 
    int priority 

    public Task(String name, int estimatedPomodoros) {
      this.name = name 
      this.estimatedPomodoros = estimatedPomodoros 
    }

    public void complete() {

    }

    static constraints = {
    }
}
