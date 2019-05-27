import java.util.*;

import com.fasterxml.jackson.annotation.*;

public class EmployeesData {
    private ArrayList<Employee> employees;

    @JsonProperty("Data")
    public ArrayList<Employee> getData() {

        return employees;
    }

    @JsonProperty("Data")
    public void setData(ArrayList<Employee> value) {
        this.employees = value;
    }
}
