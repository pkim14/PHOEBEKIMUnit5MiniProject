/**
 * Represents a time on a 24-hour digital clock with hours, minutes, and seconds
 * Supports time manipulation operations like tick and add
 */
public class Time {
    private int hours;
    private int minutes;
    private int seconds;

    /**
     * Constructs a Time object with specified hours, minutes, and seconds
     * Assumes input is valid for a 24-hour format
     *
     * @param hrs represents the hours (0-23)
     * @param mins represents the minutes (0-59)
     * @param secs represents the seconds (0-59)
     */
    public Time (int hrs, int mins, int secs) {
        this.hours = hrs;
        this.minutes = mins;
        this.seconds = secs;
    }

    /**
     * Advances the time by one second, handling rollovers for seconds, minutes, and hours
     */
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

    /**
     * Adds the time from another Time object to this Time object
     * Changes the state of the current object by adding hours, minutes, and seconds
     *
     * @param time represents the Time object to add to the current time
     */
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

    /**
     * Returns a string representation of the time in 00:00:00 format
     * Ensures each component is two digits with leading 0s if necessary
     *
     * @return formatted time string
     */
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

