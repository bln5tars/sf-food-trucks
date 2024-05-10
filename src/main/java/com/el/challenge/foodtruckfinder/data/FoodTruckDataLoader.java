package com.el.challenge.foodtruckfinder.data;

import org.springframework.util.ResourceUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FoodTruckDataLoader {

    private static final String COMMA = ",";
    private static final String HEADING_LOCATION_ID = "locationid";
    private static final String DATA_FILE_PATH = "classpath:Mobile_Food_Facility_Permit.csv";
    private static final DateTimeFormatter APPROVED_EXPIRATION_DATE_FORMATTER = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    public List<FoodTruckData> loadData() {
        List<List<String>> foodTruckCsvData = new ArrayList<>();
        // Should be external source in future to autoload new data. Split into path and filename
        try (BufferedReader br = new BufferedReader(
                new FileReader(ResourceUtils.getFile(DATA_FILE_PATH)))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(COMMA);
                foodTruckCsvData.add(Arrays.asList(values));
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to load Food Truck data. The application failed to start!");
        }
        return toFoodTruckData(foodTruckCsvData);
    }

    public List<FoodTruckData> toFoodTruckData(List<List<String>> foodTruckCsvData) {
        List<FoodTruckData> foodTruckDataList = new ArrayList<>();
        for (List<String> foodTruckCsv : foodTruckCsvData) {
            FoodTruckData data = new FoodTruckData();
            // TODO: we will not read this from CSV instead have a cache or DB; if we continue to use CSV we should
            //       create a separate parser with element name and index mapper or use the header row from CSV
            // for now skip the header
            if (HEADING_LOCATION_ID.equals(foodTruckCsv.get(0))) {
                continue;
            }
            data.setLocationId(foodTruckCsv.get(0));
            data.setApplicant(foodTruckCsv.get(1));
            data.setFacilityType(foodTruckCsv.get(2));
            data.setLocationDescription(foodTruckCsv.get(4));
            data.setAddress(foodTruckCsv.get(5));
            data.setPermit(foodTruckCsv.get(9));
            data.setPermitStatus(foodTruckCsv.get(10));
            // understand the colon (":") separated data for parsing so we could use for better search
            data.setFoodItems(foodTruckCsv.get(11));
            data.setDaysHours(foodTruckCsv.get(17));
            if (foodTruckCsv.get(19) != null && foodTruckCsv.get(19).length() >= 10) {
                // TODO: set to null if parsing fails
                data.setApprovedDate(LocalDate.parse(foodTruckCsv.get(19).substring(0, 10),
                        APPROVED_EXPIRATION_DATE_FORMATTER));
            }
            if (foodTruckCsv.get(22) != null && foodTruckCsv.get(22).length() >= 10) {
                // TODO: set to null if parsing fails
                data.setExpirationDate(LocalDate.parse(foodTruckCsv.get(22).substring(0, 10),
                        APPROVED_EXPIRATION_DATE_FORMATTER));
            }

            foodTruckDataList.add(data);
        }

        return foodTruckDataList;
    }
}
