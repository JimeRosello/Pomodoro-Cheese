package pomodoro

import pomodoro.exceptions.*
import javax.swing.JOptionPane
import java.io.*
import javax.sound.sampled.*

class Session {

    private User user
    private Interval currentInterval = new None(this)
    public LinkedList<Interval> intervals = new LinkedList<Interval>()

    public Session(String username) {
      //user = findByUsername(username)
    }

    // Starts a new Pomodoro interval or throws error if an existent cycle is running
    public void start() {
      try {
        currentInterval = currentInterval.start()
      }
      catch (IntervalInCourseException e) {
        notify(e.message)
      }
      while (currentInterval.continues()) {
        while (LocalDateTime.now() != currentInterval.endTime) {
          continue
        }
        currentInterval = currentInterval.finish().start()
      }
    }

    // Stops the current interval and stops the ongoing cycle
    public void stop() {
      currentInterval = currentInterval.stop()
    }

    public void updateInterval(Interval interval) {
      this.currentInterval = interval
    }

    public void notify(String message) {
      try {
        File audioFile = new File("../utils/alert.mp3")
        AudioInputStream stream;
        AudioFormat format;
        DataLine.Info info;
        Clip clip;

        stream = AudioSystem.getAudioInputStream(audioFile);
        format = stream.getFormat();
        info = new DataLine.Info(Clip.class, format);
        clip = (Clip) AudioSystem.getLine(info);
        clip.open(stream);
        clip.start();
      }
      catch (Exception e) { }
      JOptionPane.showMessageDialog(null, message, message, JOptionPane.INFORMATION_MESSAGE);
    }

    public int pomodoroCount() {
      int count = 0
      this.intervals.each {
        x -> count = count + x.countPomodoros()
      }
      return count
    }

    static constraints = {
    }
}
