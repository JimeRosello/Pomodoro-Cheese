package pomodoro

class User {

    String name 
    String email 
    String password 
    DailyActivity dailyActivity 
    Session session 
    Configuration configuration 

    public User(String username) {
      this.name = username 
    }

    static constraints = {
      email email: true
    }
}
