package Homework3;

import java.util.ArrayList;
import java.util.List;

public class Building {
    private String buildingName;
   private List<Floor> floors;

    public Building(String buildingName, List<Floor> floors) {
        this.buildingName = buildingName;
        this.floors = floors;
    }

    @Override
    public String toString() {
        StringBuilder buildingDetails = new StringBuilder("Building " + buildingName + " has " + floors.size() + " floors.\n");
        for (Floor floor : floors) {
            buildingDetails.append(floor).append("\n");
        }
        return buildingDetails.toString();
    }
}
