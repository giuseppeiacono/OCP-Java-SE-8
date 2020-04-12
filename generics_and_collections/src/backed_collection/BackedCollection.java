package backed_collection;

import java.util.SortedMap;
import java.util.TreeMap;

public class BackedCollection {

    public static final String ANSI_BLUE   = "\u001B[34m";
    public static final String ANSI_RESET  = "\u001B[0m";

    public static void main(String[] args) {
        TreeMap<String, String> map = new TreeMap<>();
        map.put("a", "ant");
        map.put("d", "dog");
        map.put("h", "horse");

        SortedMap<String, String> submap;
        submap = map.subMap("b", "g");
        System.out.println("\noriginal map = " + map);
        System.out.println("submap with range [b, g] = " + submap);

        reflectChangeOnSubmap(map, submap);

        reflectChangeOnOriginalMap(map, submap);

        addElementOutOfTheRange(submap);
    }

    private static void reflectChangeOnOriginalMap(TreeMap<String, String> map, SortedMap<String, String> submap) {
        submap.put("f", "fish");
        System.out.println("\nAdded the element (f, fish) to the submap");
        System.out.println("\u25E6 original map = " + map);
        System.out.println("\u25E6 submap with range [b, g] = " + submap);
        System.out.println(ANSI_BLUE + "The change is automatically reflected on the original map" + ANSI_RESET);
    }

    private static void reflectChangeOnSubmap(TreeMap<String, String> map, SortedMap<String, String> submap) {
        map.put("b", "bat");
        System.out.println("\nAdded the element (b, bat) to the original map");
        System.out.println("\u25E6 original map = " + map);
        System.out.println("\u25E6 submap with range [b, g] = " + submap);
        System.out.println(ANSI_BLUE + "The change is automatically reflected on the backed collection submap because the new element is within its range" + ANSI_RESET);
    }

    private static void addElementOutOfTheRange(SortedMap<String, String> submap) {
        System.out.println("\nAdding an element to the submap out of its range is thrown an exception");
        submap.put("p", "pig");
    }
}
