package game.utility;

/** class to keep track of total time, and elapsed time. */
public class ProgressiveTime {
    private final long timeMillisec;
    private final long deltaTime;

    /**
     * constructor with all parameters.
     * 
     * @param timeMillisec : total time
     * @param deltaTime    : elapsed time
     */
    public ProgressiveTime(final long timeMillisec, final long deltaTime) {
        this.timeMillisec = timeMillisec;
        this.deltaTime = deltaTime;
    }

    /** @return total time */
    public long getTimeMillisec() {
        return this.timeMillisec;
    }

    /** @return elapsed time */
    public long getDeltaTime() {
        return this.deltaTime;
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "ProgressiveTime [timeMillisec=" + timeMillisec + ", deltaTime=" + deltaTime + "]";
    }

}
