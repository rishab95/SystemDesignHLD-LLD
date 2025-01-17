package ParkingLot;

import java.util.List;

public abstract class ParkingLot {
    List<ParkingSpace> parkingSpaceList;
    String name;
    List<Entrance> entranceList;
    List<Exit> exitList;
    Address address;

    public abstract boolean isParkingSpaceAvailable(Vehicle vehicle);

}
