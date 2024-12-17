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

    public void add(Time time) {
        this.seconds += time.seconds;
        if (this.seconds >= 60) {
            this.seconds -= 60;
            this.minutes ++;
        }


        this.minutes += time.minutes;
        if (this.minutes >= 60) {
            this.minutes -= 60;
            this.hours ++;
        }


        this.hours += time.hours;
        if (this.hours >= 24) {
            this.hours -= 24;
        }
    }


    public String toString() {
        String hourStr = String.valueOf(hours);
        if (hours < 10) {
            hourStr = "0" + hourStr;
        }


        String minuteStr = String.valueOf(minutes);
        if (minutes < 10) {
            minuteStr = "0" + minuteStr;
        }


        String secondStr = String.valueOf(seconds);
        if (seconds < 10) {
            secondStr = "0" + secondStr;
        }


        return hourStr + ":" + minuteStr + ":" + secondStr;
    }
}

