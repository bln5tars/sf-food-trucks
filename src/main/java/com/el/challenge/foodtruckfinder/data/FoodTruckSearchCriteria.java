package com.el.challenge.foodtruckfinder.data;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodTruckSearchCriteria {
    private boolean hasValidPermit;
    private String facilityType;
    private String searchText;
}
