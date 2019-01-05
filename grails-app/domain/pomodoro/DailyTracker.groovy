package pomodoro

class DailyTracker {

    int completedPomodoros
    int completedTasks
    int totalHighPriorityTasks
    Feeling overallFeeling

    public long calculateProductivityIndex() {
      return 0.75 * completedPomodoros / totalHighPriorityTasks +
             (overallFeeling == Feeling.MOTIVATED? 0.25 : 0)
    }

    public long calculateTirednessIndex() {
      return overallFeeling == Feeling.TIRED? 1 : 0
    }

    static constraints = {
    }
}
