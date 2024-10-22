package Homework3;

import java.util.List;
import java.util.Map;

public class Toilet extends Room{
    public Toilet(List<Appliance> appliancesType, Map<Furniture, Integer> furnitureType) {
        super("Toilet", appliancesType, furnitureType);
    }

    @Override
    public String roomDetails() {
        return "\t\tToilet.";
    }
}
