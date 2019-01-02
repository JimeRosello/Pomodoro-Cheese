package pomodoro

class User {

    String usename 
    String email
    String password
    DailyActivity dailyActivity
    Session session
    Configuration configuration

    public User(String username) {
      this.usename = username 
    }

    static constraints = {
      email email: true
    }
}
