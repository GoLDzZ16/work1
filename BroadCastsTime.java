public class BroadCastsTime implements Comparable<BroadCastsTime> {
    private byte hour;
    private byte minutes;

    public BroadCastsTime(byte hour, byte minutes) {
        this.hour = hour;
        this.minutes = minutes;
    }

    public byte hour() {
        return hour;
    }

    public byte minutes() {
        return minutes;
    }

    public boolean after(BroadCastsTime t) {
        if (this.hour > t.hour) {
            return true;
        } else if (this.hour == t.hour && this.minutes > t.minutes) {
            return true;
        }
        return false;
    }

    public boolean before(BroadCastsTime t) {
        if (this.hour < t.hour) {
            return true;
        } else if (this.hour == t.hour && this.minutes < t.minutes) {
            return true;
        }
        return false;
    }

    public boolean between(BroadCastsTime t1, BroadCastsTime t2) {
        if ((this.after(t1) || this.equals(t1)) & (this.before(t2) || this.equals(t2))) {
            return true;
        }
        return false;
    }


    @Override
    public String toString() {
        return String.format("%02d:%02d", hour, minutes);
    }

    @Override
    public int compareTo(BroadCastsTime t) {
        if (this.hour != t.hour) {
            return this.hour - t.hour;
        } else {
            return this.minutes - t.minutes;
        }
    }
}