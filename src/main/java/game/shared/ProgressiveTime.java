package game.shared;

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
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (timeMillisec ^ (timeMillisec >>> 32));
        result = prime * result + (int) (deltaTime ^ (deltaTime >>> 32));
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProgressiveTime other = (ProgressiveTime) obj;
        if (timeMillisec != other.timeMillisec) {
            return false;
        }
        return deltaTime == other.deltaTime;
    }

    @Override
    public String toString() {
        return "ProgressiveTime [timeMillisec=" + timeMillisec + ", deltaTime=" + deltaTime + "]";
    }

}
