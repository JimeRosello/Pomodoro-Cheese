package pomodoro

class Configuration {

    public int workDurationInMinutes = 25
    public int shortRestDurationInMinutes = 5
    public int longRestDurationInMinutes = 15
    public static LinkedList<LeisureActivity> leisureActivities

    public Configuration() {
      initializeWithSuggestedActivities()
    }

    private void initializeWithSuggestedActivities() {
      leisureActivities = [
        new LeisureActivity("a walk around the block", Library.Duration.SHORT),
        new LeisureActivity("making a cup of tea", Library.Duration.SHORT),
        new LeisureActivity("listening to some music", Library.Duration.SHORT),
        new LeisureActivity("a short stretch", Library.Duration.SHORT),
        new LeisureActivity("a long stretch", Library.Duration.LONG),
        new LeisureActivity("a little meditation", Library.Duration.LONG),
        new LeisureActivity("a walk around the block", Library.Duration.LONG),
        new LeisureActivity("listening to some music", Library.Duration.LONG),
      ]
    }

    public LeisureActivity getRandomActivity(Library.Duration duration) {
      LinkedList<LeisureActivity> list = leisureActivities.findAll {
        it.duration == duration
      }
      Collections.shuffle(list)
      return list.first()
    }

    public String addCustomActivity(String name, Library.Duration duration) {
      leisureActivities.add(new LeisureActivity(name, duration))
    }

    public void removeActivity(String name, Library.Duration duration) {
      leisureActivities.remove {
        it.name == name && it.duration == duration
      }
    }

    public void changeWorkDuration(int workDurationInMinutes) {
      this.workDurationInMinutes = workDurationInMinutes
    }

    public void changeShortRestDurationInMinutes(int shortRestDurationInMinutes) {
      this.shortRestDurationInMinutes = shortRestDurationInMinutes
    }

    public void changeLongRestDurationInMinutes(int longRestDurationInMinutes) {
      this.longRestDurationInMinutes = longRestDurationInMinutes
    }
    
    static constraints = {
    }
}
