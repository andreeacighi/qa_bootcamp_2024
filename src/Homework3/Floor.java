package Homework3;

import java.util.ArrayList;
import java.util.List;

public class Floor {
    private int floorNumber;
    private List<Room> rooms;

    public Floor(int floorNumber, List<Room> rooms) {
        this.floorNumber = floorNumber;
        this.rooms = rooms;
    }


    @Override
    public String toString() {
        StringBuilder floorDetails = new StringBuilder(("Floor " + floorNumber + " :\n"));
        int conferenceRoomCount = 0, kitchenCount = 0, officeSpaceCount = 0, toiletCount = 0;
        for (Room room : rooms){
            if (room instanceof OfficeSpace ) { //verific daca clasa mea generala Room este de tipul clasei OfficeSpace
                officeSpaceCount++;
            }else if (room instanceof  ConferenceRoom) {
                conferenceRoomCount++;
            } else if (room instanceof Kitchen) {
                kitchenCount++;
            } else if (room instanceof Toilet) {
                toiletCount++;
            }
        }

        // Afișăm detaliile fiecărei camere
        // Office Spaces
        if (officeSpaceCount > 0) {
            floorDetails.append("\t").append(officeSpaceCount).append(" Office spaces: \n");
            int officeSpaceIndex = 1;
            for (Room room : rooms) {
                if (room instanceof OfficeSpace) {
                    floorDetails.append("\t\tOffice space ").append(officeSpaceIndex++).append(": ").
                            append(room.roomDetails()).append("\n");
                }
            }
        }

        // Conference Rooms
        if (conferenceRoomCount > 0) {
            floorDetails.append("\t").append(conferenceRoomCount).append(" Conference rooms: \n");
            int conferenceRoomIndex = 1;
            for (Room room : rooms) {
                if (room instanceof ConferenceRoom) {
                    floorDetails.append("\t\tConference room ").append(conferenceRoomIndex++).append(": \n").
                            append("\t\t\t\t").
                            append(room.roomDetails()).append("\n");
                }
            }
        }

        // Kitchens
        if (kitchenCount > 0) {
            floorDetails.append("\t").append(kitchenCount).append(" Kitchens: \n");
            for (Room room : rooms) {
                if (room instanceof Kitchen) {
                    floorDetails.append(room.roomDetails()).append("\n");
                }
            }
        }

        // Toilets
        if (toiletCount > 0) {
            floorDetails.append("\t").append(toiletCount).append(" Toilets: \n");
            for (Room room : rooms) {
                if (room instanceof Toilet) {
                    floorDetails.append(room.roomDetails()).append("\n");
                }
            }
        }

        return floorDetails.toString();
    }
}
