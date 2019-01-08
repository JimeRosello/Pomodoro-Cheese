package pomodoro

class User {

    String username
    String email
    String password
    DailyTracker dailyTracker
    Board board 
    Configuration configuration

    public User(String username) {
      this.username = username
    }

    static constraints = {
      email email: true
    }
}
