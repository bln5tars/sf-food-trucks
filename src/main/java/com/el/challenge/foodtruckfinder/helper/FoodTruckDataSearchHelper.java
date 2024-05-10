package com.el.challenge.foodtruckfinder.helper;

import com.el.challenge.foodtruckfinder.data.FoodTruckData;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FoodTruckDataSearchHelper {

    public static List<FoodTruckData> searchFoodTruckByNameFoodItem(String criteria, List<FoodTruckData> data) {
        //TODO - handle ignore case
        return data.stream().filter(foodTruckData ->
                        foodTruckData.getFoodItems().contains(criteria)
                                || foodTruckData.getApplicant().contains(criteria)
        ).collect(Collectors.toList());
    }
}
