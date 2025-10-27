package Lab_Mid;

abstract class Vehicle {
    private String vehicleNumber;
    private String ownerName;

    public Vehicle(String vehicleNumber, String ownerName) {
        this.vehicleNumber = vehicleNumber;
        this.ownerName = ownerName;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public abstract double calculateParkingFee(int hours);
}

class Car extends Vehicle {
    private static final double FIRST_HOUR_FEE = 50;
    private static final double PER_HOUR_RATE = 30;

    public Car(String vehicleNumber, String ownerName) {
        super(vehicleNumber, ownerName);
    }

    @Override
    public double calculateParkingFee(int hours) {
        if (hours <= 1) return FIRST_HOUR_FEE;
        return FIRST_HOUR_FEE + (hours - 1) * PER_HOUR_RATE;
    }
}

class Bike extends Vehicle {
    private static final double FIRST_HOUR_FEE = 20;
    private static final double PER_HOUR_RATE = 10;

    public Bike(String vehicleNumber, String ownerName) {
        super(vehicleNumber, ownerName);
    }

    @Override
    public double calculateParkingFee(int hours) {
        if (hours <= 1) return FIRST_HOUR_FEE;
        return FIRST_HOUR_FEE + (hours - 1) * PER_HOUR_RATE;
    }
}

class Truck extends Vehicle {
    private static final double FIRST_HOUR_FEE = 100;
    private static final double PER_HOUR_RATE = 70;

    public Truck(String vehicleNumber, String ownerName) {
        super(vehicleNumber, ownerName);
    }

    @Override
    public double calculateParkingFee(int hours) {
        if (hours <= 1) return FIRST_HOUR_FEE;
        return FIRST_HOUR_FEE + (hours - 1) * PER_HOUR_RATE;
    }
}

class ParkingSlot {
    private Vehicle vehicle; 

    public ParkingSlot(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void showParkingDetails(int hours) {
        System.out.println("Vehicle No: " + vehicle.getVehicleNumber());
        System.out.println("Owner: " + vehicle.getOwnerName());
        System.out.println("Total Fee: $" + vehicle.calculateParkingFee(hours)); 
        System.out.println("---------------------------");
    }
}

public class SmartParkingRunner {
    public static void main(String[] args) {
        ParkingSlot carSlot = new ParkingSlot(new Car("CAR-2025", "Abdullah"));
        ParkingSlot bikeSlot = new ParkingSlot(new Bike("BIKE-909", "Ali"));
        ParkingSlot truckSlot = new ParkingSlot(new Truck("TRUCK-777", "Zain"));

        carSlot.showParkingDetails(3);
        bikeSlot.showParkingDetails(2);
        truckSlot.showParkingDetails(5);
    }
}


// Inheritance: Car, Bike, Truck extend Vehicle.
// Encapsulation: Private attributes with getters.
// Overriding: Each subclass defines its own calculateParkingFee().
// Polymorphism: ParkingSlot holds a Vehicle reference — dynamic dispatch decides which version runs.
// Extensible: Adding ElectricCar requires only a new subclass, no change to existing code.
