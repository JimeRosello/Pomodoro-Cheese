package pomodoro

abstract class Interval {

    int duration 
    long endTime = 9999999 
    // buscar jodatime o el api nueva de java8
    // local date time


    public abstract void start() 

    public long remainingTime() {
      return endTime - System.currentTimeMillis() 
    }

    static constraints = {
    }
}
