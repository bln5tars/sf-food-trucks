package com.el.challenge.foodtruckfinder.data;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class FoodTruckData {
    String locationId;
    String applicant;
    String facilityType;
    String locationDescription;
    String address;
    // TODO: enum
    String permit;
    String permitStatus;
    // TODO: understand the format and implement a parser to support item search
    String foodItems;
    // TODO: convert to proper format to support search
    String daysHours;
    LocalDate approvedDate;
    LocalDate expirationDate;
}
