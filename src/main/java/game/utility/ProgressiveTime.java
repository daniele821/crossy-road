package game.utility;

public class ProgressiveTime {
    private final long timeMillisec;
    private final long deltaTime;

    public ProgressiveTime(final long timeMillisec, final long deltaTime) {
        this.timeMillisec = timeMillisec;
        this.deltaTime = deltaTime;
    }

    public long getTimeMillisec() {
        return this.timeMillisec;
    }

    public long getDeltaTime() {
        return this.deltaTime;
    }

    @Override
    public String toString() {
        return "ProgressiveTime [timeMillisec=" + timeMillisec + ", deltaTime=" + deltaTime + "]";
    }

}
