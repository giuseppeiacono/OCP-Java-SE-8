import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;

public class CollectStreamValues {

    private static final List<Person> PEOPLE = Arrays.asList(
        new Person("Beth", 30),
        new Person("Eric", 31),
        new Person("Deb", 31),
        new Person("Liz", 30),
        new Person("Wendi", 34),
        new Person("Kathy", 35),
        new Person("Bert", 32),
        new Person("Bill", 34),
        new Person("Robert", 38)
    );

    public static void main(String[] args) {
        System.out.println("\nPeople = {");
        PEOPLE.forEach(p -> System.out.println("\t" + p));
        System.out.println("}");

        collectIntoDataStructure();
        groupingAndMappingByFunction();
        groupingByFunctionAndSumming();
        groupingByFunctionAndAveraging();
        partitioningByPredicate();
        counting();
        joining();
        maxBy();
        minBy();
    }

    private static void collectIntoDataStructure() {
        System.out.println("\n------------ Collect stream into data structure ------------");
        Set<Person> set = new HashSet<>();
        set.add(new Person("mike", 34));
        set.add(new Person("john", 12));
        set.add(new Person("mark", 34));
        System.out.println("Set of persons = " + set.toString());

        List<Person> list = set.stream().collect(Collectors.toList());
        System.out.println("List obtained from the previous set = " + list.toString());

        ArrayList<Person> arrayList = set.stream().collect(Collectors.toCollection(ArrayList::new));
        System.out.println("ArrayList obtained from the previous set = " + arrayList.toString());
    }

    private static void groupingAndMappingByFunction() {
        System.out.println("\n------------ Group by function ------------");
        Map<Integer, List<String>> peopleByAge =
                PEOPLE.stream()
                        .collect(
                                Collectors.groupingBy(
                                        Person::getAge,
                                        Collectors.mapping(Person::getName, Collectors.toList())
                                )
                        );
        System.out.println("People grouped by age = " + printMap(peopleByAge));
    }

    private static void groupingByFunctionAndSumming() {

    }

    private static void groupingByFunctionAndAveraging() {

    }

    private static void partitioningByPredicate() {
        System.out.println("\n------------ Partitioning by Predicate ------------");
        Map<Boolean, List<String>> peopleOlderThan34 =
                PEOPLE.stream()
                        .collect(
                                Collectors.partitioningBy(
                                        p -> p.getAge() > 34,
                                        Collectors.mapping(Person::getName, Collectors.toList())
                                )
                        );
        System.out.println("People > 34: " + printMap(peopleOlderThan34));
    }

    private static void joining() {

    }

    private static void maxBy() {

    }

    private static void minBy() {

    }

    private static <K, V> String printMap(Map<K, V> map) {
        StringBuilder mapEntries = new StringBuilder();
        Iterator<Map.Entry<K, V>> iter = map.entrySet().iterator();

        mapEntries.append("{");
        while (iter.hasNext()) {
            Map.Entry<K, V> entry = iter.next();
            mapEntries.append("\n\t" + entry.getKey());
            mapEntries.append(" = ");
            mapEntries.append(entry.getValue());
            if (iter.hasNext()) {
                mapEntries.append(',').append(' ');
            }
        }
        mapEntries.append("\n}");

        return mapEntries.toString();
    }
}
