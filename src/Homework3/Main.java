package Homework3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // 1st floor 1 office space with 20 desks, 2 toilets, 1 kitchen,
        // 3 conference rooms(each with 10 seats)


        Map<Furniture,Integer> officeFurniture1 = new HashMap<>();
        officeFurniture1.put(Furniture.DESK,20);
        OfficeSpace officeSpace1 = new OfficeSpace(Arrays.asList(),officeFurniture1);
         // 3 conference room
        Map<Furniture,Integer> conferenceFurniture1 = new HashMap<>();
        conferenceFurniture1.put(Furniture.SEAT,10);
        ConferenceRoom conferenceRoom1 = new ConferenceRoom(Arrays.asList(Appliance.TV),conferenceFurniture1);
        ConferenceRoom conferenceRoom2 = new ConferenceRoom(Arrays.asList(Appliance.TV),conferenceFurniture1);
        ConferenceRoom conferenceRoom3 = new ConferenceRoom(Arrays.asList(Appliance.TV),conferenceFurniture1);


        Kitchen kitchen1 = new Kitchen(Arrays.asList(Appliance.FRIDGE,Appliance.COFFEE_MACHINE,
                Appliance.WATER_DISPENSER),new HashMap<>());
        Toilet toilet1 = new Toilet(Arrays.asList(),new HashMap<>());
        Toilet toilet2 = new Toilet(Arrays.asList(),new HashMap<>());

        Floor floor1 = new Floor(1,Arrays.asList(officeSpace1,conferenceRoom1,conferenceRoom2,conferenceRoom3,kitchen1,toilet1,toilet2));


        //  2nd floor: 2 office spaces with 10 desks each, 2 toilets, 1 kitchen, 4 conference
        //rooms (each with 8 seats)
        Map<Furniture,Integer> officeFurniture2 = new HashMap<>();
        officeFurniture2.put(Furniture.DESK,10);
        OfficeSpace officeSpace2ndFloor1 = new OfficeSpace(Arrays.asList(),officeFurniture2);
        OfficeSpace officeSpace2ndFloor2 = new OfficeSpace(Arrays.asList(),officeFurniture2);

        Map<Furniture,Integer> confRoom2 = new HashMap<>();
        confRoom2.put(Furniture.SEAT,8);
        ConferenceRoom confRoom2ndFloor1 = new ConferenceRoom(Arrays.asList(Appliance.TV),confRoom2);
        ConferenceRoom confRoom2ndFloor2 = new ConferenceRoom(Arrays.asList(Appliance.TV),confRoom2);
        ConferenceRoom confRoom2ndFloor3 = new ConferenceRoom(Arrays.asList(Appliance.TV),confRoom2);
        ConferenceRoom confRoom2ndFloor4 = new ConferenceRoom(Arrays.asList(Appliance.TV),confRoom2);

        Toilet toilet2ndFloor1 = new Toilet(Arrays.asList(),new HashMap<>());
        Toilet toilet2ndFloor2 = new Toilet(Arrays.asList(),new HashMap<>());

        Kitchen kitchen2ndFloor = new Kitchen(Arrays.asList(Appliance.FRIDGE,Appliance.COFFEE_MACHINE,
                Appliance.WATER_DISPENSER),new HashMap<>());

        Floor floor2 = new Floor(2,Arrays.asList(officeSpace2ndFloor1,officeSpace2ndFloor2,confRoom2ndFloor1,confRoom2ndFloor2,
                confRoom2ndFloor3,confRoom2ndFloor4,toilet2ndFloor1,toilet2ndFloor2,kitchen2ndFloor));

        //  3rd floor: 2 toilets, 6 conference rooms (one with 30 seats, one with 20 seats and
        //the rest with 10 seats each).

        Map<Furniture,Integer> confRoom3_30seats = new HashMap<>();
        confRoom3_30seats.put(Furniture.SEAT,30);
        ConferenceRoom largeConfRoom = new ConferenceRoom(Arrays.asList(Appliance.VIDEO_PROJECTOR,Appliance.TELEPRESENCE),confRoom3_30seats);

        Map<Furniture,Integer> confRoom3_20seats = new HashMap<>();
        confRoom3_20seats.put(Furniture.SEAT,20);
        ConferenceRoom confRoom3rdFloor2 = new ConferenceRoom(Arrays.asList(Appliance.TV,Appliance.TELEPRESENCE),confRoom3_20seats);

        Map<Furniture,Integer> confRoom3_10seats = new HashMap<>();
        confRoom3_10seats.put(Furniture.SEAT,10);
        ConferenceRoom confRoom3rdFloor3 = new ConferenceRoom(Arrays.asList(Appliance.TV,Appliance.TELEPRESENCE),confRoom3_10seats);
        ConferenceRoom confRoom3rdFloor4 = new ConferenceRoom(Arrays.asList(Appliance.TV,Appliance.TELEPRESENCE),confRoom3_10seats);
        ConferenceRoom confRoom3rdFloor5 = new ConferenceRoom(Arrays.asList(Appliance.TV,Appliance.TELEPRESENCE),confRoom3_10seats);
        ConferenceRoom confRoom3rdFloor6 = new ConferenceRoom(Arrays.asList(Appliance.TV,Appliance.TELEPRESENCE),confRoom3_10seats);

        Toilet toilet3rdFloor1 = new Toilet(Arrays.asList(),new HashMap<>());
        Toilet toilet3rdFloor2 = new Toilet(Arrays.asList(),new HashMap<>());


        Floor floor3 = new Floor(3,Arrays.asList(largeConfRoom,confRoom3rdFloor2,confRoom3rdFloor3,
                confRoom3rdFloor4,confRoom3rdFloor5,confRoom3rdFloor6,toilet3rdFloor1,toilet3rdFloor2));

        Building building = new Building("Andreea",Arrays.asList(floor1,floor2,floor3));
        System.out.println(building);


    }
}
