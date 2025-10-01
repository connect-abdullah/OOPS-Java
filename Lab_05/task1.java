package Lab_05;

class Address {
    private int streetNo;
    private int houseNo;
    private String city;
    private int postalCode;

    public Address(int streetNo, int houseNo, String city, int postalCode) {
        this.streetNo = streetNo;
        this.houseNo = houseNo;
        this.city = city;
        this.postalCode = postalCode;
    }

    // Getters
    public int getStreetNo() {
        return streetNo;
    }

    public int getHouseNo() {
        return houseNo;
    }

    public String getCity() {
        return city;
    }

    public int getPostalCode() {
        return postalCode;
    }

    // Setters
    public void setStreetNo(int streetNo) {
        this.streetNo = streetNo;
    }

    public void setHouseNo(int houseNo) {
        this.houseNo = houseNo;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public void display() {
        System.out.println("Street#: " + streetNo +
                ", House#: " + houseNo +
                ", City: " + city +
                ", Code: " + postalCode);
    }
}

class Person {
    private String name;
    private Address address;

    public Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.print("Address: ");
        address.display();
    }
}

class Book {
    private String bookName;
    private String publisher;
    private Person author;

    public Book(String bookName, String publisher, Person author) {
        this.bookName = bookName;
        this.publisher = publisher;
        this.author = author;
    }

    public String getBookName() {
        return bookName;
    }

    public String getPublisher() {
        return publisher;
    }

    public Person getAuthor() {
        return author;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setAuthor(Person author) {
        this.author = author;
    }

    public void display() {
        System.out.println("Book: " + bookName + " | Publisher: " + publisher);
        System.out.println("Author Info:");
        author.display();
    }
}

public class task1 {
    public static void main(String[] args) {
        Address addr = new Address(10, 22, "Lahore", 54000);
        Person author = new Person("Abdullah", addr);

        Book book = new Book("AI Revolution", "TechPress", author);

        book.display();

        System.out.println("\n--- Updating Author's Address ---");
        author.getAddress().setCity("Karachi");
        author.getAddress().setPostalCode(75000);

        book.display();
    }
}
