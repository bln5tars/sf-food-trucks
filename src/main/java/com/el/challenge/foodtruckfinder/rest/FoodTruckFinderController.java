package com.el.challenge.foodtruckfinder.rest;

import com.el.challenge.foodtruckfinder.data.FoodTruckData;
import com.el.challenge.foodtruckfinder.data.FoodTruckSearchCriteria;
import com.el.challenge.foodtruckfinder.service.FoodTruckSearchService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class FoodTruckFinderController {

    private static final Logger LOGGER = Logger.getLogger(FoodTruckFinderController.class.getName());
    private final FoodTruckSearchService foodTruckSearchService;

    FoodTruckFinderController(FoodTruckSearchService foodTruckSearchService) {
        this.foodTruckSearchService = foodTruckSearchService;
    }

    @PostMapping("/food-trucks/search")
    List<FoodTruckData> searchFoodTrucks (@RequestBody FoodTruckSearchCriteria searchCriteria) {
        LOGGER.log(Level.FINER, "search food truck for criteria : " + foodTruckSearchService.toString());
        return foodTruckSearchService.searchFoodTrucks(searchCriteria);
    }
}
