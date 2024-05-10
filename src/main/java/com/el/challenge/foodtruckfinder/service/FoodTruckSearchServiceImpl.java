package com.el.challenge.foodtruckfinder.service;

import com.el.challenge.foodtruckfinder.data.FoodTruckData;
import com.el.challenge.foodtruckfinder.data.FoodTruckDataLoader;
import com.el.challenge.foodtruckfinder.data.FoodTruckSearchCriteria;
import com.el.challenge.foodtruckfinder.helper.FoodTruckDataSearchHelper;

import java.util.List;

public class FoodTruckSearchServiceImpl implements FoodTruckSearchService {

    List<FoodTruckData> foodTruckDataList;

    public FoodTruckSearchServiceImpl(FoodTruckDataLoader dataLoader) {
        foodTruckDataList = dataLoader.loadData();
    }

    @Override
    public List<FoodTruckData> searchFoodTrucks(FoodTruckSearchCriteria foodTruckSearchCriteria) {
        return FoodTruckDataSearchHelper.searchFoodTruckByNameFoodItem(
                foodTruckSearchCriteria.getSearchText(), foodTruckDataList);
    }
}
