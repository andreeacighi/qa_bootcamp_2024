package Homework3;

import java.util.List;
import java.util.Map;

public abstract class Room {
    private String roomName;

    protected List<Appliance> appliancesType ;
    protected Map<Furniture,Integer> furnitureType;

    public Room(String roomName, List<Appliance> appliancesType, Map<Furniture, Integer> furnitureType) {
        this.roomName = roomName;
        this.appliancesType = appliancesType;
        this.furnitureType = furnitureType;
    }

    public abstract String roomDetails();
}
