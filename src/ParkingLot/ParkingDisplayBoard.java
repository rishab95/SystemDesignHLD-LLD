package ParkingLot;

import java.util.Map;

public abstract class ParkingDisplayBoard {
    Map<ParkingSpaceType, Integer> availableParkingSlotsMap;
    public abstract void updateFreeParkingSlots(ParkingSpaceType parkingSpaceType, int parkingSpaces);

}
