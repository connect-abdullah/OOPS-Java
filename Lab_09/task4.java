package Lab_09;

interface Enumeration {
    boolean hasNext(int index);
    Object getNext(int index);
}

class NameCollection implements Enumeration {
    private String[] names;
    private int size;

    public NameCollection(String[] names) {
        this.names = names;
        this.size = names.length;
    }

    @Override
    public boolean hasNext(int index) {
        return index < size;
    }

    @Override
    public Object getNext(int index) {
        if (index < size) {
            return names[index];
        }
        return null;
    }
}

public class task4 {
    public static void main(String[] args) {
        String[] sampleNames = {"Abdullah", "Abbas", "Sara", "Hassan"};
        NameCollection nc = new NameCollection(sampleNames);

        int i = 0;
        while (nc.hasNext(i)) {
            System.out.println(nc.getNext(i));
            i++;
        }
    }
}
