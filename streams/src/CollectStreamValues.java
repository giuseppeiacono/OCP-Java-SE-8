import java.util.*;
import java.util.stream.Collectors;

public class CollectStreamValues {

    public static final String ANSI_BLUE   = "\u001B[34m";
    public static final String ANSI_RESET  = "\u001B[0m";

    private static final List<Person> PEOPLE = Arrays.asList(
        new Person("Beth", 30),
        new Person("Eric", 31),
        new Person("Deb", 31),
        new Person("Liz", 30),
        new Person("Wendi", 34),
        new Person("Kathy", 35),
        new Person("Beth", 32),
        new Person("Bill", 34),
        new Person("Robert", 38),
        new Person("Bill", 81)
    );

    public static void main(String[] args) {
        System.out.println("\nPeople = " + getFormattedCollection(PEOPLE));
        collectIntoDataStructure();
        groupingAndMappingByFunction();
        groupingByFunctionAndSumming();
        groupingByFunctionAndAveraging();
        partitioningByPredicate();
        countingItems();
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
        System.out.println("Set of persons = " + getFormattedCollection(set));

        List<Person> list = set.stream().collect(Collectors.toList());
        System.out.println("List obtained from the previous set = " + getFormattedCollection(list));

        ArrayList<Person> arrayList = set.stream().collect(Collectors.toCollection(ArrayList::new));
        System.out.println("ArrayList obtained from the previous set = " + getFormattedCollection(arrayList));
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
        System.out.println("People grouped by age = " + getFormattedMap(peopleByAge));
    }

    private static void groupingByFunctionAndSumming() {
        System.out.println("\n------------ Group by function and summing ------------");
        Map<String, Integer> sumOfBAges =
                PEOPLE.stream()
                        .filter(p -> p.getName().startsWith("B"))
                        .collect(
                                Collectors.groupingBy(
                                        Person::getName,
                                        Collectors.summingInt(Person::getAge)
                                )
                        );
        System.out.println("People whose name starts with 'B', grouped by name and sum of their ages: " + getFormattedMap(sumOfBAges));
    }

    private static void groupingByFunctionAndAveraging() {
        System.out.println("\n------------ Group by function and averaging ------------");
        Map<String, Double> averageOfBAges =
                PEOPLE.stream()
                        .filter(p -> p.getName().startsWith("B"))
                        .collect(
                                Collectors.groupingBy(
                                        Person::getName,
                                        Collectors.averagingInt(Person::getAge)
                                )
                        );
        System.out.println("People whose name starts with 'B', grouped by name and averaging of their ages: " + getFormattedMap(averageOfBAges));
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
        System.out.println("People > 34: " + getFormattedMap(peopleOlderThan34));
    }

    private static void countingItems() {
        System.out.println("\n------------ Counting items of the stream into collect() method ------------");
        Long older34Counting =
                PEOPLE.stream()
                        .filter(p -> p.getAge() > 34)
                        .map(Person::getName)
                        .collect(Collectors.counting());    // don't mistake it with count() method of Stream class
        System.out.println("Number of people older than 34 = " + older34Counting);
    }

    private static void joining() {
        System.out.println("\n------------ Joining items of the stream ------------");
        List<String> older34 =
                PEOPLE.stream()
                        .filter(p -> p.getAge() > 34)
                        .map(Person::getName)
                        .collect(Collectors.toList());
        String joiningAsString = older34.stream().collect(Collectors.joining());
        String joiningWithDelimiter = older34.stream().collect(Collectors.joining(","));
        String joiningWithPrefixDelimiterSuffix = older34.stream().collect(Collectors.joining(",", "START --| ", " |-- END"));
        System.out.println("Names of people older than 34 joined:");
        System.out.println("\u25E6 as a string = " + ANSI_BLUE + joiningAsString + ANSI_RESET);
        System.out.println("\u25E6 with delimiter = " + ANSI_BLUE +  joiningWithDelimiter + ANSI_RESET);
        System.out.println("\u25E6 with prefix, delimiter and suffix = " + ANSI_BLUE +  joiningWithPrefixDelimiterSuffix + ANSI_RESET);
    }

    private static void maxBy() {
        System.out.println("\n------------ Maximum of stream ------------");
        Optional<Person> oldest =
                PEOPLE.stream()
                        .collect(
                                Collectors.maxBy(Comparator.comparing(Person::getAge))
                        );
        oldest.ifPresent(p -> System.out.println("Oldest person = " + p));
    }

    private static void minBy() {
        System.out.println("\n------------ Minimum of stream ------------");
        Optional<Person> youngest =
                PEOPLE.stream()
                        .collect(
                                Collectors.minBy(Comparator.comparing(Person::getAge))
                        );
        youngest.ifPresent(p -> System.out.println("Youngest person = " + p));
    }

    private static <E> String getFormattedCollection(Collection<E> collection) {
        StringBuilder formattedCollection = new StringBuilder();
        formattedCollection.append("{ \n");
        collection.forEach(
                p -> formattedCollection.append("\t" + p + "\n")
        );
        formattedCollection.append("}");
        return formattedCollection.toString();
    }

    private static <K, V> String getFormattedMap(Map<K, V> map) {
        StringBuilder formattedMap = new StringBuilder();
        Iterator<Map.Entry<K, V>> iter = map.entrySet().iterator();

        formattedMap.append("{");
        while (iter.hasNext()) {
            Map.Entry<K, V> entry = iter.next();
            formattedMap.append("\n\t" + entry.getKey());
            formattedMap.append(" = ");
            formattedMap.append(entry.getValue());
            if (iter.hasNext()) {
                formattedMap.append(',').append(' ');
            }
        }
        formattedMap.append("\n}");

        return formattedMap.toString();
    }
}
