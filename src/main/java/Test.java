
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Test {
    public static void main(String args[]) {
        String dataPath, reportDefinitionPath;
        final Report reportDefinition;
        Report reportDefinitionTemp;

        //Taking input
        //You can test it with dummy json files in the project using "Data.json" and "ReportData.json"
        System.out.println("You can test it with dummy json files in the project using \"Data.json\" and \"ReportData.json\" for the file paths");
        System.out.println("Input path to JSON data file:");
        Scanner in = new Scanner(System.in);
        dataPath = in.nextLine();
        System.out.println("Input path to JSON report definition file");
        reportDefinitionPath = in.nextLine();


        //read the ReportData.json
        try (FileReader reader = new FileReader(reportDefinitionPath)) {
            ReportData reportData = Converter.ReportDataFromFileReader(reader);
            reportDefinitionTemp = reportData.getReport();
        } catch (Exception e) {
            reportDefinitionTemp = null;
            e.printStackTrace();
        }
        reportDefinition = reportDefinitionTemp;

        //read the Data.json and generate the CSV file
        try (FileReader reader = new FileReader(dataPath)) {
            EmployeesData data = Converter.EmployeesDataFromFileReader(reader);
            ArrayList<Employee> employeesList = data.getData();

            //remove the objects where salesPeriod > periodLimit from the ArrayList
            employeesList.removeIf(o -> (o.getSalesPeriod() > reportDefinition.getPeriodLimit()));

            //sort the ArrayList by score
            Collections.sort(employeesList, (o1, o2) -> {

                if (reportDefinition.getUseExprienceMultiplier()) {
                    double o1Score = o1.getTotalSales() / o1.getSalesPeriod() * o1.getExperienceMultiplier();
                    double o2Score = o2.getTotalSales() / o2.getSalesPeriod() * o2.getExperienceMultiplier();
                    return Double.compare(o2Score, o1Score);
                } else {
                    double o1Score = o1.getTotalSales() / o1.getSalesPeriod();
                    double o2Score = o2.getTotalSales() / o2.getSalesPeriod();
                    return Double.compare(o2Score, o1Score);
                }
            });


            //Generate CSV file containing the report results
            FileWriter csvWriter = new FileWriter("Result.csv");
            csvWriter.append("Name");
            csvWriter.append(", ");
            csvWriter.append("Score");
            csvWriter.append("\n");
            //append the top X percent of the Array List
            for (int i = 0; i < Math.round(employeesList.size()*reportDefinition.getTopPerformersThreshold()/100.0); i++) {
                csvWriter.append(employeesList.get(i).getName());
                csvWriter.append(", ");
                if (reportDefinition.getUseExprienceMultiplier()) {
                    csvWriter.append(String.format("%.1f",employeesList.get(i).getTotalSales()
                            / employeesList.get(i).getSalesPeriod()
                            * employeesList.get((i)).getExperienceMultiplier()));
                } else {
                    csvWriter.append(String.format("%.1f",(double)employeesList.get(i).getTotalSales()
                            / employeesList.get(i).getSalesPeriod()));
                }
                csvWriter.append("\n");
            }
            csvWriter.flush();
            csvWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}