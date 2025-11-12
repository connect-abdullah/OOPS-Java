package Lab_09;

interface Payable {
    double getPaymentAmount();
}

class Invoice implements Payable {
    private String partNumber;
    private String description;
    private int quantity;
    private double pricePerItem;

    public Invoice(String partNumber, String description, int quantity, double pricePerItem) {
        this.partNumber = partNumber;
        this.description = description;
        this.quantity = quantity;
        this.pricePerItem = pricePerItem;
    }

    @Override
    public double getPaymentAmount() {
        return quantity * pricePerItem;
    }
}

abstract class Employee implements Payable {
    private String name;
    private String id;

    public Employee(String name, String id) {
        this.name = name;
        this.id = id;
    }
}

class SalariedEmployee extends Employee {
    private double weeklySalary;

    public SalariedEmployee(String name, String id, double weeklySalary) {
        super(name, id);
        this.weeklySalary = weeklySalary;
    }

    @Override
    public double getPaymentAmount() {
        return weeklySalary;
    }
}


class Task2 {
    public static void main(String[] args) {
        Payable[] payables = new Payable[] {
            new Invoice("A12", "Laptop Charger", 2, 4500.0),
            new SalariedEmployee("Abdullah", "EMP001", 15000.0)
        };

        for (Payable p : payables) {
            System.out.println("Payment Due: " + p.getPaymentAmount());
        }
    }
}