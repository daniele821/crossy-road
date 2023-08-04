package game.shared;

public class ProgressiveTime {
    public final long timeMillisec;
    public final long deltaTime;

    public static ProgressiveTime clone(final ProgressiveTime time) {
        return new ProgressiveTime(time.timeMillisec, time.deltaTime);
    }

    public ProgressiveTime(final long timeMillisec, final long deltaTime) {
        this.timeMillisec = timeMillisec;
        this.deltaTime = deltaTime;
    }

    @Override
    public String toString() {
        return "ProgressiveTime [timeMillisec=" + timeMillisec + ", deltaTime=" + deltaTime + "]";
    }

}
