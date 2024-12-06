public class Time {
    private int hours;
    private int minutes;
    private int seconds;

    public Time (int hrs, int mins, int secs) {
        this.hours = hrs;
        this.minutes = mins;
        this.seconds = secs;
    }

    public void tick() {
        if (seconds <= 59) {
            seconds += 1;
        }

        if (seconds == 60) {
            seconds = 0;
            minutes++;

            if (minutes == 60) {
                minutes = 0;
                hours++;

                if (hours == 24) {
                    hours = 0;
                }
            }
        }
    }
}
