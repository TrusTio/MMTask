import com.fasterxml.jackson.annotation.*;
public class Employee {
    private String name;
    private int totalSales;
    private int salesPeriod;
    private double experienceMultiplier;


    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("totalSales")
    public int getTotalSales() {
        return totalSales;
    }

    @JsonProperty("totalSales")
    public void setTotalSales(int totalSales) {
        this.totalSales = totalSales;
    }

    @JsonProperty("salesPeriod")
    public int getSalesPeriod() {
        return salesPeriod;
    }

    @JsonProperty("salesPeriod")
    public void setSalesPeriod(int salesPeriod) {
        this.salesPeriod = salesPeriod;
    }

    @JsonProperty("experienceMultiplier")
    public double getExperienceMultiplier() {
        return experienceMultiplier;
    }

    @JsonProperty("experienceMultiplier")
    public void setExperienceMultiplier(double experienceMultiplier) {
        this.experienceMultiplier = experienceMultiplier;
    }


}
