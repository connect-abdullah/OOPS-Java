package Lab_05;
class Pizza {
    private String size;
    private int cheese;
    private int pepperoni;
    private int ham;

    public Pizza(String size, int cheese, int pepperoni, int ham) {
        this.size = size.toLowerCase();
        this.cheese = cheese;
        this.pepperoni = pepperoni;
        this.ham = ham;
    }

    public double calcCost() {
        int base = 0;
        if (size.equals("small")) base = 10;
        else if (size.equals("medium")) base = 12;
        else if (size.equals("large")) base = 14;

        int toppings = cheese + pepperoni + ham;
        return base + (2 * toppings);
    }

    public String getDescription() {
        return size.toUpperCase() + " Pizza -> Cheese: " + cheese +
               ", Pepperoni: " + pepperoni + ", Ham: " + ham +
               " | Cost: $" + calcCost();
    }
}

class PizzaOrder {
    private Pizza p1, p2, p3;  

    public void setPizza1(Pizza pizza) { p1 = pizza; }
    public void setPizza2(Pizza pizza) { p2 = pizza; }
    public void setPizza3(Pizza pizza) { p3 = pizza; }

    public double calcTotal() {
        double total = 0;
        if (p1 != null) total += p1.calcCost();
        if (p2 != null) total += p2.calcCost();
        if (p3 != null) total += p3.calcCost();
        return total;
    }
}

public class task3 {
    public static void main(String[] args) {
        Pizza pizza1 = new Pizza("large", 1, 1, 2); 
        Pizza pizza2 = new Pizza("medium", 2, 0, 1); 

        System.out.println(pizza1.getDescription());
        System.out.println(pizza2.getDescription());

        PizzaOrder order = new PizzaOrder();
        order.setPizza1(pizza1);
        order.setPizza2(pizza2);

        System.out.println("Total Order Cost: $" + order.calcTotal());
    }
}
