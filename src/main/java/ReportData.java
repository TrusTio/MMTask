import com.fasterxml.jackson.annotation.JsonProperty;

public class ReportData {
    private Report report;

    @JsonProperty("Report definition")
    public Report getReport() {
        return report;
    }

    @JsonProperty("Report definition")
    public void setReport(Report value) {
        this.report = value;
    }
}