package Lab_09;

interface Compare {
    boolean compareObjects(Object o);
}

class InventoryItem implements Compare {
    private String name;
    private int uniqueItemID;

    public InventoryItem(String name, int uniqueItemID) {
        this.name = name;
        this.uniqueItemID = uniqueItemID;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getUniqueItemID() {
        return uniqueItemID;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setUniqueItemID(int uniqueItemID) {
        this.uniqueItemID = uniqueItemID;
    }

    @Override
    public boolean compareObjects(Object o) {
        if (o instanceof InventoryItem) {
            InventoryItem other = (InventoryItem) o;
            return this.uniqueItemID == other.uniqueItemID;
        }
        return false;
    }
}

public class task3 {
    public static void main(String[] args) {
        InventoryItem item1 = new InventoryItem("Keyboard", 101);
        InventoryItem item2 = new InventoryItem("Mouse", 101);
        InventoryItem item3 = new InventoryItem("Monitor", 102);

        System.out.println("Item1 == Item2 ? " + item1.compareObjects(item2));
        System.out.println("Item1 == Item3 ? " + item1.compareObjects(item3));
    }
}