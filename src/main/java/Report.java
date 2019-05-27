
import com.fasterxml.jackson.annotation.*;

public class Report {
    private int topPerformersThreshold;
    private boolean useExprienceMultiplier;
    private long periodLimit;

    @JsonProperty("topPerformersThreshold")
    public int getTopPerformersThreshold() {
        return topPerformersThreshold;
    }

    @JsonProperty("topPerformersThreshold")
    public void setTopPerformersThreshold(int value) {
        this.topPerformersThreshold = value;
    }

    @JsonProperty("useExprienceMultiplier")
    public boolean getUseExprienceMultiplier() {
        return useExprienceMultiplier;
    }

    @JsonProperty("useExprienceMultiplier")
    public void setUseExprienceMultiplier(boolean value) {
        this.useExprienceMultiplier = value;
    }

    @JsonProperty("periodLimit")
    public long getPeriodLimit() {
        return periodLimit;
    }

    @JsonProperty("periodLimit")
    public void setPeriodLimit(long value) {
        this.periodLimit = value;
    }
}
