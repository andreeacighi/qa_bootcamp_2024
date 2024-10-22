package Homework3;


import java.util.List;
import java.util.Map;

public class OfficeSpace extends Room{
    public OfficeSpace(List<Appliance> appliancesType, Map<Furniture, Integer> furnitureType) {
        super("OfficeSpace", appliancesType, furnitureType);
    }

    @Override
    public String roomDetails() {
        return " Office space with " + furnitureType.get(Furniture.DESK) + " desks.";
    }
}
