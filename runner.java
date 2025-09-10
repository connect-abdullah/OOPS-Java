// LAB Task 1

/* class Circle {
    private double radius;

    public Circle() {
        this.radius = 0.0;
    }

    // Constructor with a different name (not Circle)
    public void setRadius(double radius, double dummy) {
        this.radius = radius;
    }

    public double getCircumference() {
        return 2 * Math.PI * radius;
    }
}

public class runner {
    public static void main(String[] args) {
        Circle c1 = new Circle();
        c1.setRadius(2, 0);
        System.out.println(c1.getCircumference());
    }
} */


// LAB Task 2

/* class Account {
    int balance;

    public Account() {
        this.balance = 0;
    }

    public void addBalanace(int amount) {
        balance += amount;
    }

    public void withdraw(int amount) {
        balance -= amount;
        System.out.println("Amount: " + amount + " has been deducted from your account balance.");
    }

    public void displayTotal() {
        System.out.println("Total Balance in Your Account: " + balance);
    }
}

public class runner {
    public static void main(String[] args) {
        Account acc1 = new Account();

        acc1.addBalanace(500);
        acc1.displayTotal();
        acc1.withdraw(150);
        acc1.displayTotal();
    }
} */



// LAB Task 3

/* class Distance {
    int feet;
    int inches;

    // No-argument constructor
    public Distance() {
        this.feet = 0;
        this.inches = 0;
    }

    // Two-argument constructor
    public Distance(int feet, int inches) {
        this.feet = feet;
        this.inches = inches;
    }

    public void display() {
        System.out.println("Feet: " + feet + ", Inches: " + inches);
    }
}

public class runner {
    public static void main(String[] args) {
        Distance d1 = new Distance(5, 8);

        System.out.print("Distance: ");
        d1.display();
    }
}
 */


// LAB Task 4
/* class Marks {
    private int mark1;
    private int mark2;
    private int mark3;

    public Marks() {
        this.mark1 = 0;
        this.mark2 = 0;
        this.mark3 = 0;
    }

    public Marks(int mark1, int mark2, int mark3) {
        this.mark1 = mark1;
        this.mark2 = mark2;
        this.mark3 = mark3;
    }

    public int getSum() {
        return mark1 + mark2 + mark3;
    }
}

public class runner {
    public static void main(String[] args) {
        Marks student1 = new Marks(5, 8, 5);

        System.out.print("Student Marks: " + student1.getSum());
    }
} */


class Time {
    private int hr;
    private int min;
    private int sec;

    public Time() {
        this.hr = 0;
        this.min = 0;
        this.sec = 0;
    }

    public Time(int hr, int min, int sec) {
        if (isValidTime(hr, min, sec)) {
            this.hr = hr;
            this.min = min;
            this.sec = sec;
        } else {
            this.hr = 0;
            this.min = 0;
            this.sec = 0;
            System.out.println("Invalid Time: Reverted to 00:00:00");
        }
    }

    private boolean isValidTime(int hr, int min, int sec) {
        return (hr >= 0 && hr < 24) && (min >= 0 && min < 60) && (sec >= 0 && sec < 60);
    }

    public void display() {
        System.out.println("Time: " + String.format("%02d", hr) + ":" + String.format("%02d", min) + ":" + String.format("%02d", sec));
    }
}

public class runner {
    public static void main(String[] args) {
        // Example usage of Time class
        Time t1 = new Time(13, 45, 30);
        t1.display();

        Time t2 = new Time(25, 70, 80); // Invalid time, should default to 00:00:00
        t2.display();
    }
}
