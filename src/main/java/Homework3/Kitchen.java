package Homework3;

import java.util.List;
import java.util.Map;

public class Kitchen extends Room{

    public Kitchen(List<Appliance> appliancesType, Map<Furniture, Integer> furnitureType) {
        super("Kitchen", appliancesType, furnitureType);
    }

    @Override
    public String roomDetails() {
        return "\t\tKitchen with " + appliancesType;
    }
}
