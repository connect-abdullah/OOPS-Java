class Marks {
    private int x;
    private int y;
    private int z;

    public Marks(int a, int b, int c) {
        this.x = a;
        this.y = b;
        this.z = c;
    }

    public void display() {
        System.out.println("First Mark: " + this.x + ", Second Mark: " + this.y + ", Third Mark: " + this.z);
    }
    
}


// Lab Task 1: Student class
class Student {
    private String name;
    private int rollNumber;
    private String department;
    private int year;
    private double cgpa;

    public Student(String name, int rollNumber, String department, int year, double cgpa) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.department = department;
        this.year = year;
        this.cgpa = cgpa;
    }

    public void displayInfo() {
        System.out.println("Name: " + name + ", Roll Number: " + rollNumber + ", Department: " + department + ", Year: " + year + ", CGPA: " + cgpa);
    }

    public void updateCGPA(double newCgpa) {
        this.cgpa = newCgpa;
    }

    public void promoteYear() {
        this.year += 1;
    }
}

// Lab Task 2: Time class
class Time {
    private int hours;
    private int minutes;
    private int seconds;

    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public void displayTime() {
        System.out.println(String.format("%02d:%02d:%02d", hours, minutes, seconds));
    }

    public void addSeconds(int sec) {
        int totalSeconds = hours * 3600 + minutes * 60 + seconds + sec;
        this.hours = (totalSeconds / 3600) % 24;
        this.minutes = (totalSeconds % 3600) / 60;
        this.seconds = totalSeconds % 60;
    }
}

// Lab Task 3: Car class
class Car {
    private String make;
    private String model;
    private int year;
    private String variant;

    public Car(String make, String model, int year, String variant) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.variant = variant;
    }

    public void displayInfo() {
        System.out.println("Make: " + make + ", Model: " + model + ", Year: " + year + ", Variant Level: " + variant);
    }
}

// Lab Task 4: Rectangle class
class Rectangle {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double area() {
        return length * width;
    }

    public double perimeter() {
        return 2 * (length + width);
    }

    public void display() {
        System.out.println("Rectangle [Length: " + length + ", Width: " + width + ", Area: " + area() + ", Perimeter: " + perimeter() + "]");
    }
}

public class runner {
    public static void main(String[] args) {
        Marks p1 = new Marks(2,4,6);
        p1.display();
    }
}
