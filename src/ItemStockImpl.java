package javatest;

import java.util.HashMap;

class ItemStockImpl implements ItemStock {
    private HashMap<String, Integer> itemStockData;

    public ItemStockImpl() {
        itemStockData = new HashMap<>();
    }

    public void add(String item, int number) {
        if (itemStockData.containsKey(item)) {
            Integer itemNumber = itemStockData.get(item);
            itemStockData.put(item, new Integer(number) + itemNumber);
        } else {
            itemStockData.put(item, number);
        }
    }

    public int size(String item) {
        return itemStockData.size();
    }

    public boolean contains(String item) {
        return itemStockData.containsKey(item);
    }
}
