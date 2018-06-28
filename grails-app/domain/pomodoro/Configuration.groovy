package pomodoro

class Configuration {

    public static int workDurationInMinutes = 25;
    public static int shortRestDurationInMinutes = 5;
    public static int longRestDurationInMinutes = 15;
    //public static App.ColorScheme colorScheme;
    public static LinkedList<LeisureActivity> leisureActivities;

    public Configuration() {
      initializeWithSuggestedActivities();
    }

    private void initializeWithSuggestedActivities() {
      leisureActivities = new LinkedList<LeisureActivity>();
      leisureActivities.add(new LeisureActivity("a walk around the block", App.Duration.SHORT));
      leisureActivities.add(new LeisureActivity("making a cup of tea", App.Duration.SHORT));
      leisureActivities.add(new LeisureActivity("listening to some music", App.Duration.SHORT));
      leisureActivities.add(new LeisureActivity("a short stretch", App.Duration.SHORT));
      leisureActivities.add(new LeisureActivity("a long stretch", App.Duration.LONG));
      leisureActivities.add(new LeisureActivity("a little meditation", App.Duration.LONG));
      leisureActivities.add(new LeisureActivity("a walk around the block", App.Duration.LONG));
      leisureActivities.add(new LeisureActivity("listening to some music", App.Duration.LONG));
    }

    public String getRandomActivity(App.Duration duration) {
      LinkedList<LeisureActivity> list = leisureActivities.collect{
        it.duration == duration
      };
      Collections.shuffle(list);
      return list.first();
    }

    public String addCustomActivity(String name, App.Duration duration) {
      leisureActivities.add(new LeisureActivity(name, duration));
    }

    public void removeActivity(String name, App.Duration duration) {
      leisureActivities.remove{
        x -> x.name == name && x.duration == duration
      };
    }

    static constraints = {
    }
}
