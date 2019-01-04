package parkinglot;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

public class ParkingManagerTest {

    @Test
    void shouldParkSuccessfullyWhenParkingManagerParkCarGivenNoParkingBoyAndManageOneParkingLot() {
        Car car = new Car();
        ParkingLot parkingLot= new ParkingLot(1);

        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);
        BaseParkingBoy parkingManager = new ParkingManager(parkingLots);

        assertNotNull(parkingManager.park(car));
    }

    @Test
    void shouldParkSuccessfullyWhenParkingManagerParkCarGivenNoParkingBoyAndManageTwoParkingLots() {
        Car car = new Car();
        ParkingLot parkingLot1= new ParkingLot(1);
        ParkingLot parkingLot2= new ParkingLot(1);

        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        BaseParkingBoy parkingManager = new ParkingManager(parkingLots);

        assertNotNull(parkingManager.park(car));
    }

    @Test
    void shouldParkSuccessfullyWhenParkingBoyParkCarGivenOneParkingBoy() {
        Car car = new Car();
        ParkingLot parkingLot= new ParkingLot(1);

        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);

        ParkingManager parkingManager = new ParkingManager();
        BaseParkingBoy parkingBoy = new ParkingBoy(parkingLots);

        parkingManager.manage(parkingBoy);

        Receipt receipt = parkingManager.assignParkingCarTaskToParkingBoy(car);

        assertNotNull(receipt);
        assertSame(car, parkingLot.pick(receipt));
    }

    @Test
    void shouldParkAtManagerParkingLotWhenParkingGivenParkingboyParkinglotIsFull() {
        Car myCar = new Car();
        Car car = new Car();
        ParkingLot parkingLot1= new ParkingLot(1);
        ParkingLot parkingLot2= new ParkingLot(1);

        List<ParkingLot> parkingBoyParkingLots = new ArrayList<>();
        parkingBoyParkingLots.add(parkingLot1);
        List<ParkingLot> managerParkingLots = new ArrayList<>();
        managerParkingLots.add(parkingLot2);

        ParkingManager parkingManager = new ParkingManager(managerParkingLots);
        BaseParkingBoy parkingBoy = new ParkingBoy(parkingBoyParkingLots);

        parkingManager.manage(parkingBoy);
        parkingManager.assignParkingCarTaskToParkingBoy(car);

        Receipt receipt = parkingManager.assignParkingCarTaskToParkingBoy(myCar);

        assertNotNull(receipt);
        assertSame(myCar, parkingLot2.pick(receipt));
    }


    @Test
    void shouldParkAtSmartParkingLotWhenParkingGivenSmartParkingBoy() {
        Car car = new Car();
        ParkingLot parkingLot1= new ParkingLot(1);

        List<ParkingLot> parkingBoyParkingLots = new ArrayList<>();
        parkingBoyParkingLots.add(parkingLot1);

        ParkingManager parkingManager = new ParkingManager();
        BaseParkingBoy smartParkingBoy = new SmartParkingBoy(parkingBoyParkingLots);

        parkingManager.manage(smartParkingBoy);

        Receipt receipt = parkingManager.assignParkingCarTaskToParkingBoy(car);

        assertNotNull(receipt);
        assertSame(car, parkingLot1.pick(receipt));
    }
}
