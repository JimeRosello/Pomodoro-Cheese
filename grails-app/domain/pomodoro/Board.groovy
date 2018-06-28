package pomodoro

class Board {

    LinkedList<Task> toDo = new LinkedList<Task>();
    LinkedList<Task> inProgress = new LinkedList<Task>();
    LinkedList<Task> done = new LinkedList<Task>();

    public Task getNextTask() {
      return toDo.sort(it.priority).first();
    }

    static constraints = {
    }
}
