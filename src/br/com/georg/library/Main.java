package br.com.georg.library;

import br.com.georg.library.utilities.Bookstore;
import br.com.georg.library.utilities.InventoryItem;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        var hashMap = Bookstore.getInventory();

        for (Map.Entry<String, HashMap<String, HashMap<String, InventoryItem>>> outerEntry : hashMap.entrySet()) {
            System.out.println("Outer key: " + outerEntry.getKey() + " | Outer value: " + outerEntry.getValue());
            System.out.println();
            for (Map.Entry<String, HashMap<String, InventoryItem>> innerEntry : outerEntry.getValue().entrySet()) {
                System.out.println("    Inner key: " + innerEntry.getKey() + " | Inner value: " + innerEntry.getValue());
            }
            System.out.println();
        }

    }
}
