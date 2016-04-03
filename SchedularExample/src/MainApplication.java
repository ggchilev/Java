import java.util.Calendar;
import java.util.Timer;

class MainApplication {
	
  private static final int START_MILLISECONDS = 0;
private static final int START_SECOND = 0;
private static final int START_MINUTE = 0;
private static final int START_HOUR = 10;

public static void main(String[] args) {
    Timer timer = new Timer();
    Calendar date = Calendar.getInstance();
    date.set(
      Calendar.DAY_OF_WEEK,
      Calendar.FRIDAY
    );
    date.set(Calendar.HOUR, START_HOUR);
    date.set(Calendar.MINUTE, START_MINUTE);
    date.set(Calendar.SECOND, START_SECOND);
    date.set(Calendar.MILLISECOND, START_MILLISECONDS);
    timer.schedule(
      new ReportGenerator(),
      date.getTime(),
      1000 * 60 * 60 * 24 * 7
    );
  }
}