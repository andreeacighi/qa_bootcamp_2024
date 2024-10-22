package Homework3;

import java.util.List;
import java.util.Map;

public class ConferenceRoom extends Room{
    public ConferenceRoom(List<Appliance> appliancesType, Map<Furniture, Integer> furnitureType) {
        super("ConferenceRoom", appliancesType, furnitureType);
    }

    @Override
    public String roomDetails() {
        String seatsNumber = furnitureType.get(Furniture.SEAT) + " seats";
        String appliances = appliancesType.contains(Appliance.VIDEO_PROJECTOR)?
                "\t\t\t\tVIDEO_PROJECTOR" : "\t\t\t\tTV"; //verific daca camera de conferinta contina video proiector sau tv
        if (appliancesType.contains(Appliance.TELEPRESENCE)) {
            appliances += "\n\t\t\t\tTelepresence";
        }
        return seatsNumber + "\n" + appliances ;
    }
}
