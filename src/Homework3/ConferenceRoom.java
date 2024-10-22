package Homework3;

import java.util.HashMap;
import java.util.List;

public class ConferenceRoom extends Room{
    public ConferenceRoom(List<Appliance> appliancesType, HashMap<Furniture, Integer> furnitureType) {
        super("ConferenceRoom", appliancesType, furnitureType);
    }

    @Override
    public String roomDetails() {
        String seatsNumber = furnitureType.get(Furniture.SEAT) + " seats";
        String appliances = appliancesType.contains(Appliance.VIDEO_PROJECTOR)?
                "VIDEO_PROJECTOR" : "TV"; //verific daca camera de conferinta contina video proiector sau tv
        if (appliancesType.contains(Appliance.TELEPRESENCE)) {
            appliances += " and Telepresence";
        }
        return " Conference Room with " + seatsNumber + " and a " + appliances + " .";
    }
}
