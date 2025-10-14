import java.util.ArrayList;

class Customer {
    private String fullName;
    private String contactNumber;

    public Customer(String fullName, String contactNumber) {
        this.fullName = fullName;
        this.contactNumber = contactNumber;
    }

    public String getFullName() { return fullName; }
    public String getContactNumber() { return contactNumber; }

    @Override
    public String toString() {
        return fullName + " (" + contactNumber + ")";
    }
}

class Suite {
    private int suiteId;
    private double nightlyRate;
    private boolean isBooked;
    private Customer currentCustomer;

    public Suite(int suiteId, double nightlyRate) {
        this.suiteId = suiteId;
        this.nightlyRate = nightlyRate;
        this.isBooked = false;
        this.currentCustomer = null;
    }

    public int getSuiteId() { return suiteId; }
    public double getNightlyRate() { return nightlyRate; }
    public boolean isAvailable() { return !isBooked; }

    public boolean reserve(Customer customer) {
        if (isBooked) {
            System.out.println("Suite " + suiteId + " is already reserved.");
            return false;
        }

        isBooked = true;
        currentCustomer = customer;
        Resort.totalReservations++;
        System.out.println("Suite " + suiteId + " reserved for " + customer.getFullName());
        return true;
    }

    public boolean release() {
        if (!isBooked) {
            System.out.println("Suite " + suiteId + " is not reserved yet.");
            return false;
        }

        isBooked = false;
        currentCustomer = null;
        Resort.totalReservations--;
        System.out.println("Reservation released for suite " + suiteId);
        return true;
    }

    @Override
    public String toString() {
        return "Suite " + suiteId + " | Rate: " + nightlyRate + " | " +
                (isBooked ? "Reserved by " + currentCustomer.getFullName() : "Available");
    }
}

class Resort {
    private String resortName;
    private ArrayList<Suite> suiteList;

    public static int totalSuites = 0;
    public static int totalReservations = 0;

    public Resort(String resortName) {
        this.resortName = resortName;
        this.suiteList = new ArrayList<>();
    }

    public void addSuite(Suite suite) {
        suiteList.add(suite);
        totalSuites++;
    }

    public void showAvailableSuites() {
        System.out.println("\nAvailable Suites in " + resortName + ":");
        for (Suite suite : suiteList) {
            if (suite.isAvailable())
                System.out.println("  " + suite);
        }
    }

    public Suite findSuiteById(int suiteId) {
        for (Suite suite : suiteList)
            if (suite.getSuiteId() == suiteId)
                return suite;
        return null;
    }
}

public class assignment1 {
    public static void main(String[] args) {
        Resort resort = new Resort("Azure Heights");

        resort.addSuite(new Suite(101, 5500));
        resort.addSuite(new Suite(102, 6500));
        resort.addSuite(new Suite(201, 8500));

        // Customers
        Customer customer1 = new Customer("Ahmed", "0300-1122334");
        Customer customer2 = new Customer("Sara", "0311-9988776");

        // Reservations
        resort.findSuiteById(101).reserve(customer1);
        resort.findSuiteById(102).reserve(customer2);
        resort.findSuiteById(101).reserve(customer2); // already reserved

        resort.showAvailableSuites();

        // Cancel a reservation
        resort.findSuiteById(101).release();
        resort.showAvailableSuites();

        System.out.println("\nTotal Suites: " + Resort.totalSuites);
        System.out.println("Total Reservations: " + Resort.totalReservations);
    }
}
