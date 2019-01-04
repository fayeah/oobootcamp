package parkinglot;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    void shouldParkAtParkingBoyLotWhenParkingGivenParkingBoyComeFirstAndSmartParkingBoyLate() {
        Car car = new Car();
        ParkingLot parkingLot1= new ParkingLot(1);
        ParkingLot parkingLot2= new ParkingLot(1);

        List<ParkingLot> parkingBoyParkingLots = new ArrayList<>();
        parkingBoyParkingLots.add(parkingLot1);


        List<ParkingLot> smartParkingBoyParkingLots = new ArrayList<>();
        smartParkingBoyParkingLots.add(parkingLot2);

        ParkingManager parkingManager = new ParkingManager();
        BaseParkingBoy parkingBoy = new ParkingBoy(parkingBoyParkingLots);
        BaseParkingBoy smartParkingBoy = new SmartParkingBoy(smartParkingBoyParkingLots);

        parkingManager.manage(parkingBoy);
        parkingManager.manage(smartParkingBoy);

        Receipt receipt = parkingManager.assignParkingCarTaskToParkingBoy(car);

        assertNotNull(receipt);
        assertSame(car, parkingLot1.pick(receipt));
    }

    @Test
    void shouldParkAtSmartParkingBoyLotWhenParkingGivenSmartParkingBoyComeFirstAndParkingBoyLate() {
        Car car = new Car();
        ParkingLot parkingLot1= new ParkingLot(1);
        ParkingLot parkingLot2= new ParkingLot(1);

        List<ParkingLot> smartParkingBoyParkingLots = new ArrayList<>();
        smartParkingBoyParkingLots.add(parkingLot2);

        List<ParkingLot> parkingBoyParkingLots = new ArrayList<>();
        parkingBoyParkingLots.add(parkingLot1);

        ParkingManager parkingManager = new ParkingManager();
        BaseParkingBoy smartParkingBoy = new SmartParkingBoy(smartParkingBoyParkingLots);
        BaseParkingBoy parkingBoy = new ParkingBoy(parkingBoyParkingLots);

        parkingManager.manage(smartParkingBoy);
        parkingManager.manage(parkingBoy);

        Receipt receipt = parkingManager.assignParkingCarTaskToParkingBoy(car);

        assertNotNull(receipt);
        assertSame(car, parkingLot2.pick(receipt));
    }

    @Test
    void shouldParkAtManagerParkingLotWhenParkingGivenSmartParkingLotsAndParkingLotsAreFull() {
        Car car = new Car();
        Car car1 = new Car();
        Car car2 = new Car();

        ParkingLot parkingLot1= new ParkingLot(1);
        ParkingLot parkingLot2= new ParkingLot(1);
        ParkingLot parkingLot3= new ParkingLot(1);

        List<ParkingLot> parkingBoyParkingLots = new ArrayList<>();
        parkingBoyParkingLots.add(parkingLot1);

        List<ParkingLot> smartParkingBoyParkingLots = new ArrayList<>();
        smartParkingBoyParkingLots.add(parkingLot2);

        List<ParkingLot> managerParkingLots = new ArrayList<>();
        managerParkingLots.add(parkingLot3);


        ParkingManager parkingManager = new ParkingManager(managerParkingLots);
        BaseParkingBoy smartParkingBoy = new SmartParkingBoy(smartParkingBoyParkingLots);
        BaseParkingBoy parkingBoy = new ParkingBoy(parkingBoyParkingLots);

        parkingManager.manage(smartParkingBoy);
        parkingManager.manage(parkingBoy);

        parkingManager.assignParkingCarTaskToParkingBoy(car1);
        parkingManager.assignParkingCarTaskToParkingBoy(car2);

        Receipt receipt = parkingManager.assignParkingCarTaskToParkingBoy(car);

        assertNotNull(receipt);
        assertSame(car, parkingLot3.pick(receipt));
    }

    @Test
    void shouldParkFailedWhenParkingGivenAllParkingLotsAreFull() {
        Car car = new Car();
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();

        ParkingLot parkingLot1= new ParkingLot(1);
        ParkingLot parkingLot2= new ParkingLot(1);
        ParkingLot parkingLot3= new ParkingLot(1);

        List<ParkingLot> parkingBoyParkingLots = new ArrayList<>();
        parkingBoyParkingLots.add(parkingLot1);

        List<ParkingLot> smartParkingBoyParkingLots = new ArrayList<>();
        smartParkingBoyParkingLots.add(parkingLot2);

        List<ParkingLot> managerParkingLots = new ArrayList<>();
        managerParkingLots.add(parkingLot3);


        ParkingManager parkingManager = new ParkingManager(managerParkingLots);
        BaseParkingBoy smartParkingBoy = new SmartParkingBoy(smartParkingBoyParkingLots);
        BaseParkingBoy parkingBoy = new ParkingBoy(parkingBoyParkingLots);

        parkingManager.manage(smartParkingBoy);
        parkingManager.manage(parkingBoy);

        parkingManager.assignParkingCarTaskToParkingBoy(car1);
        parkingManager.assignParkingCarTaskToParkingBoy(car2);
        parkingManager.assignParkingCarTaskToParkingBoy(car3);

        assertThrows(ParkingSpacesAreFullException.class, () -> parkingManager.assignParkingCarTaskToParkingBoy(car));
    }
}
