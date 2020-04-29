package navigable_set_map;

import java.util.*;

public class NavigableSetMap {

    public static void main (String[] args) {
        navigableSetMethods();
        navigableMapMethods();
    }

    private static void navigableSetMethods() {
        NavigableSet<Integer> set = new TreeSet<>();
        set.add(3);
        set.add(22);
        set.add(15);
        set.add(78);

        System.out.println("\n--------------- NavigableSet methods ---------------");
        System.out.println("set = " + set);
        System.out.println("set.descendingSet() = " + set.descendingSet());

        System.out.println("\nset.ceiling(22) is " + set.ceiling(22));
        System.out.println("set.higher(22) is " + set.higher(22));
        System.out.println("set.floor(22) is " + set.floor(22));
        System.out.println("set.lower(22) is " + set.lower(22));

        System.out.println("\nset = " + set);
        System.out.println("set.pollFirst() is " + set.pollFirst());
        System.out.println("set = " + set);
        System.out.println("set.pollLast() is " + set.pollLast());
        System.out.println("set = " + set);
    }

    private static void navigableMapMethods() {
        NavigableMap<Integer, String> map = new TreeMap<>();
        map.put(3, "a");
        map.put(22, "b");
        map.put(15, "c");
        map.put(78, "d");

        System.out.println("\n--------------- NavigableMap methods ---------------");
        System.out.println("map = " + map);
        System.out.println("map.descendingMap() = " + map.descendingMap());

        Integer ceilingKey = map.ceilingKey(22);
        System.out.println("\nmap.ceilingKey(22) is " + ceilingKey + "=" + map.get(ceilingKey));
        Integer higherKey = map.higherKey(22);
        System.out.println("map.higherKey(22) is " + higherKey + "=" + map.get(higherKey));
        System.out.println("map.floorKey(22) is " + map.floorKey(22) + "=" + map.get(22));
        System.out.println("map.lowerKey(22) is " + map.lowerKey(22) + "=" + map.get(22));

        System.out.println("\nmap = " + map);
        Map.Entry<Integer, String> firstEntry = map.pollFirstEntry();
        System.out.println("map.pollFirstEntry() is " + firstEntry + "=" + firstEntry.getValue());
        System.out.println("map = " + map);
        Map.Entry<Integer, String> lastEntry = map.pollLastEntry();
        System.out.println("map.pollLastEntry() is " + lastEntry + "=" + lastEntry.getValue());
        System.out.println("map = " + map);
    }
}
