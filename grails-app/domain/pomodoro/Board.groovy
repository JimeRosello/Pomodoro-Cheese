package pomodoro

class Board {

    LinkedList<Task> toDo = new LinkedList<Task>()
    Task inProgress
    LinkedList<Task> done = new LinkedList<Task>()

    public void addPendingTask(Task task) {
      toDo.addLast(task)
      sortByPriorityAndEstimatedPomodoros()
    }

    public void completeTaskInProgress() {
      done.addLast(inProgress)
      inProgress = toDo.first()
      toDo.remove(inProgress)
    }

    private void sortByPriorityAndEstimatedPomodoros() {
      toDo = toDo.sort {
        x, y -> x.priority <=> y.priority ?: x.estimatedPomodoros <=> y.estimatedPomodoros
      }
    }

    static constraints = {
    }
}
