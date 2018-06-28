package pomodoro

class Board {

    LinkedList<Task> toDo = new LinkedList<Task>();
    Task inProgress;
    LinkedList<Task> done = new LinkedList<Task>();

    public void addPendingTask(Task task) {
      toDo.add(task);
      toDo = toDo.sort{
        x,y -> x.priority <=> y.priority ?: x.estimatedPomodoros <=> y.estimatedPomodoros
      };
    }

    public void completeTaskInProgress() {
      done.add(inProgress);
      inProgress = toDo.first();
      toDo.remove(inProgress);
    }

    static constraints = {
    }
}
