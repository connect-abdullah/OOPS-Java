package Lab_03;

// Lab Task 1

// class Marks {
//     private int mark1;
//     private int mark2;
//     private int mark3;

//     public void setMark1(int mark1) {
//         this.mark1 = mark1;
//     }

//     public void setMark2(int mark2) {
//         this.mark2 = mark2;
//     }

//     public void setMark3(int mark3) {
//         this.mark3 = mark3;
//     }

//     public int getMark1() {
//         return mark1;
//     }

//     public int getMark2() {
//         return mark2;
//     }

//     public int getMark3() {
//         return mark3;
//     }

//     public void getAllMarks() {
//         System.out.println("Mark 1: " + mark1);
//         System.out.println("Mark 2: " + mark2);
//         System.out.println("Mark 3: " + mark3);
//     }
// }

// public class runner {
//     public static void main(String[] args) {
//         Marks studentMarks = new Marks();
//         studentMarks.setMark1(85);
//         studentMarks.setMark2(90);
//         studentMarks.setMark3(78);

//         System.out.println("Mark 1: " + studentMarks.getMark1());
//         System.out.println("Mark 2: " + studentMarks.getMark2());
//         System.out.println("Mark 3: " + studentMarks.getMark3());
//     }
// }



// Lab Task 2

// class Account {
//     private int balance;
//     private String name;
    
//     public Account() {
//         this.balance = 0;
//         this.name = "";
//     }

//     public Account(String name, int balance) {
//         this.name = name;
//         this.balance = balance;
//     }

//     public void deposit(int funds) {
//         balance += funds;
//         System.out.println("Funds Added to your " + this.name + " account. Your new balance is: " + this.balance);
//     }

//     public void withdraw(int funds) {
//         balance -= funds;
//         System.out.println("Funds Withdrawn From your account. Your new balance is: " + this.balance);
//     }

//     public void getInfo(){
//         System.out.println("Your " + this.name + " Account have balance: " + this.balance);
//     }

//     public int getBalance() {
//         return this.balance;
//     }
// }

// public class runner {
//     public static void main(String[] args) {
//         Account ali = new Account("Ali", 3000);
//         ali.deposit(500);
//         ali.withdraw(20);
//         ali.getInfo();
//         Account abdullah = new Account("Abdullah", ali.getBalance());
//         abdullah.getInfo();
//     }
// }



// Lab Task 3

// class Student {
//     private String name;
//     private int[] marks = new int[5];

//     public Student(){
//         this.name = "";
//         this.marks = new int[5];
//     }

//     public Student(String name, int[] marksArray) {
//         this.name = name;
//         this.marks = marksArray;
//     }

//     public void Average() {
//         int sum = 0;
//         for (int mark : marks) {
//             sum += mark;
//         }
//         double average = (double) sum / marks.length;
//         System.out.println("Average marks of " + this.name + " are: " + average);
//     }

//     public int getTotalMarks() {
//         int sum = 0;
//         for(int mark : this.marks) {
//             sum += mark;
//         }
//         return sum;
//     }

//     public String getStudentName() {
//         return this.name;
//     }

//     public int[] getMarksArray() {
//         // Return a copy of the marks array
//         return this.marks.clone();
//     }

//     public void getStudentInfo() {
//         int sum = 0;
//         for(int mark : this.marks) {
//             sum += mark;
//         }
//         System.out.println(this.name + " has total marks: "  + sum);
//     }
// }

// public class runner {
//     public static void main(String[] args) {
//         System.out.println("------- Student 1 -------");
//         int[] marksArray1 = {80,50,24,51,52};
//         Student ali = new Student("Ali", marksArray1);
//         ali.Average();
//         ali.getStudentInfo();

//         System.out.println("------- Student 2 -------");
//         int[] marksArray2 = {80,80,64,51,52};
//         Student abdullah = new Student("Abdullah", marksArray2);
//         abdullah.Average();
//         abdullah.getStudentInfo();

//         System.out.println("------- Student 3 -------");
//         Student student3 = new Student(ali.getStudentName(), abdullah.getMarksArray());
//         student3.Average();
//         student3.getStudentInfo();

//     }
// }


// Lab Task 4

class HotDogStand {
    private int id;
    private int hotDogsSold;
    private static int totalHotDogsSold = 0;

    public HotDogStand(int id, int hotDogsSold) {
        this.id = id;
        this.hotDogsSold = hotDogsSold;
        totalHotDogsSold += hotDogsSold;
    }

    public void justSold() {
        this.hotDogsSold++;
        totalHotDogsSold++;
    }

    public int getHotDogsSold() {
        return this.hotDogsSold;
    }

    public int getId() {
        return this.id;
    }

    public static int getTotalHotDogsSold() {
        return totalHotDogsSold;
    }
}

public class runner {
    public static void main(String[] args) {
        HotDogStand stand1 = new HotDogStand(101, 5);
        HotDogStand stand2 = new HotDogStand(102, 3);
        HotDogStand stand3 = new HotDogStand(103, 7);

        stand1.justSold();
        stand1.justSold();
        stand2.justSold();
        stand3.justSold();
        stand3.justSold();
        stand3.justSold();

        System.out.println("Hot Dog Stand " + stand1.getId() + " sold: " + stand1.getHotDogsSold() + " hot dogs.");
        System.out.println("Hot Dog Stand " + stand2.getId() + " sold: " + stand2.getHotDogsSold() + " hot dogs.");
        System.out.println("Hot Dog Stand " + stand3.getId() + " sold: " + stand3.getHotDogsSold() + " hot dogs.");
        System.out.println("Total hot dogs sold by all stands: " + HotDogStand.getTotalHotDogsSold());
    }
}
