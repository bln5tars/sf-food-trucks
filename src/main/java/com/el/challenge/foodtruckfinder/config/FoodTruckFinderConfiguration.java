package com.el.challenge.foodtruckfinder.config;

import com.el.challenge.foodtruckfinder.data.FoodTruckDataLoader;
import com.el.challenge.foodtruckfinder.service.FoodTruckSearchService;
import com.el.challenge.foodtruckfinder.service.FoodTruckSearchServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FoodTruckFinderConfiguration {

    @Bean
    public FoodTruckSearchService getFoodTruckSearchService() {
        return new FoodTruckSearchServiceImpl(new FoodTruckDataLoader());
    }
}
