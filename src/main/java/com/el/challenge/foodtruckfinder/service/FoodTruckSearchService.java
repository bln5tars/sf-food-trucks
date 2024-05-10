package com.el.challenge.foodtruckfinder.service;

import com.el.challenge.foodtruckfinder.data.FoodTruckData;
import com.el.challenge.foodtruckfinder.data.FoodTruckSearchCriteria;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FoodTruckSearchService {

    public List<FoodTruckData> searchFoodTrucks(FoodTruckSearchCriteria foodTruckSearchCriteria);
}
