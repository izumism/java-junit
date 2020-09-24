package javatest;

public interface ItemStock {
    public void add(String item, int number);

    public int size(String item);

    public boolean contains(String item);
}
