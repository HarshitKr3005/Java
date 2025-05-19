package collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CollectionsDemo {
    public static void show() {
        Collection<String> collection = new ArrayList<>();
        Collections.addAll(collection, "a","b","c");
        System.out.println(collection);
        System.out.println(collection.size());
        collection.remove("a");
        System.out.println(collection);
        System.out.println(collection.isEmpty());
        var containsA = collection.contains("b");
        System.out.println(containsA);
        Object[] objectArray = collection.toArray();
        String[] stringArray = collection.toArray(new String[0]);

        Collection<String> other = new ArrayList<>();
        other.addAll(collection);
        System.out.println(collection == other);
        System.out.println(collection.equals(other));
    }
    public static void main(String[] args) {
        show(); // Call the method here
    }
}
