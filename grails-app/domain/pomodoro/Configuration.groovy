package pomodoro

class Configuration {

    public static int workDurationInMinutes = 25;
    public static int shortRestDurationInMinutes = 5;
    public static int longRestDurationInMinutes = 15;
    //public static App.ColorScheme colorScheme;
    public static LinkedList<LeisureActivity> leisureActivities;

    public void initializeWithSuggestedActivities() {
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

    static constraints = {
    }
}
