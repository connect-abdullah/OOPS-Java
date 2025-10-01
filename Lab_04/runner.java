// Lab Task 1

import Lab_05.Book;

class Distance {
    private int feet;
    private int inches;

    public Distance() {
        this.feet = 0;
        this.inches = 0;
    }

    public Distance(int feet, int inches) {
        this.feet = feet;
        this.inches = inches;
        normalize();
    }

    public void setFeet(int feet) { this.feet = feet; }
    public void setInches(int inches) { 
        this.inches = inches; 
        normalize();
    }

    public int getFeet() { return feet; }
    public int getInches() { return inches; }

    public void display() {
        System.out.println(feet + " feet " + inches + " inches");
    }

    public Distance add(Distance d) {
        return new Distance(this.feet + d.feet, this.inches + d.inches);
    }

    private void normalize() {
        if (inches >= 12) {
            feet += inches / 12;
            inches = inches % 12;
        }
    }
}


// Lab Task 2
class Book {
    private String author;
    private String[] chapterNames;

    public Book() {
        this.author = "";
        this.chapterNames = new String[0];
    }

    public Book(String author, String[] chapterNames) {
        this.author = author;
        this.chapterNames = chapterNames;
    }

    public void setAuthor(String author) { this.author = author; }
    public void setChapterNames(String[] chapterNames) { this.chapterNames = chapterNames; }

    public String getAuthor() { 
        return author; 
    }
    public String[] getChapterNames() { 
        return chapterNames; 
    }

    public Book compareChapterNames(Book b) {
        if (this.chapterNames.length > b.chapterNames.length) {
            return this;
        } else {
            return b;
        }
    }
}


// Lab Task 3
class Fraction {
    private int numerator;
    private int denominator;

    public Fraction() {
        numerator = 0;
        denominator = 1;
    }

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = (denominator == 0) ? 1 : denominator;
    }

    public void setNumerator(int numerator) { this.numerator = numerator; }
    public void setDenominator(int denominator) { 
        if (denominator != 0) this.denominator = denominator; 
    }

    public int getNumerator() { return numerator; }
    public int getDenominator() { return denominator; }

    public void display() {
        System.out.println(numerator + "/" + denominator);
    }

    public boolean equals(Fraction f) {
        return this.numerator * f.denominator == this.denominator * f.numerator;
    }
}


public class runner {
    public static void main(String[] args) {
        // Task 1
        Distance d1 = new Distance(5, 8);
        Distance d2 = new Distance(3, 11);
        Distance d3 = d1.add(d2);
        System.out.print("Sum of distances: ");
        d3.display();

        // Task 2
        Book b1 = new Book();
        b1.setAuthor("Author Abbas");
        b1.setChapterNames(new String[]{"Ch1", "Ch2"});

        Book b2 = new Book("Author Abdullah", new String[]{"Ch1", "Ch2", "Ch3"});

        System.out.println("Same author? " + b1.getAuthor().equals(b2.getAuthor()));
        Book bigger = b1.compareChapterNames(b2);
        System.out.println("Book with more chapters is authored by: " + bigger.getAuthor());

        // Task 3
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(2, 4);
        System.out.print("Fraction f1: ");
        f1.display();
        System.out.print("Fraction f2: ");
        f2.display();
        System.out.println("Are f1 and f2 equal? " + f1.equals(f2));
    }
}
