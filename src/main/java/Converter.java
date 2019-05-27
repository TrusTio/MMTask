import java.io.FileReader;
import java.io.IOException;

import com.fasterxml.jackson.databind.*;

public class Converter {

    //EmployeeData
    public static EmployeesData EmployeesDataFromFileReader(FileReader reader) throws IOException {
        return getEmployeesDataObjectReader().readValue(reader);
    }

    private static ObjectReader employeesDataReader;

    private static void instantiateEmployeesDataMapper() {
        ObjectMapper mapper = new ObjectMapper();
        employeesDataReader = mapper.readerFor(EmployeesData.class);
    }

    private static ObjectReader getEmployeesDataObjectReader() {
        if (employeesDataReader == null) instantiateEmployeesDataMapper();
        return employeesDataReader;
    }


    //ReportData
    public static ReportData ReportDataFromFileReader(FileReader reader) throws IOException {
        return getReportDataObjectReader().readValue(reader);
    }

    private static ObjectReader reportDataReader;

    private static void instantiateReportDataMapper() {
        ObjectMapper mapper = new ObjectMapper();
        reportDataReader = mapper.readerFor(ReportData.class);
    }

    private static ObjectReader getReportDataObjectReader() {
        if (reportDataReader == null) instantiateReportDataMapper();
        return reportDataReader;
    }

}