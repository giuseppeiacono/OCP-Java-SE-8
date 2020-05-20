import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.lang.Integer.compare;

public class SortingStream {

    private static List<Person> PERSONS = Arrays.asList(
            new Person("Fred", 40),
            new Person("Mark", 40),
            new Person("John Junior", 16),
            new Person("Fred", 67)
    );

    public static void main(String[] args) {
        sortStreamOfObjectsByNaturalOrder();
        sortStreamOfObjectsByComparator();
        sortStreamOfPrimitivesValuesByNaturalOrder();
        sortStreamRemovingDuplicates();
    }

    private static void sortStreamOfObjectsByNaturalOrder() {
        System.out.println("\n----------- Sorting stream of objects by natural order -----------");
        List<String> colours = Arrays.asList("red", "yellow", "grey", "orange");
        System.out.println("colours = " + colours);
        System.out.println("SORTED colours");
        colours.stream().sorted().forEach(c -> System.out.println("\u25E6 " + c));
    }

    private static void sortStreamOfObjectsByComparator() {
        System.out.println("\n----------- Sorting stream of objects by Comparator -----------");
        Person.print(PERSONS);

        // comparators defined by lambda expression
//        Comparator<Person> byName = (p1, p2) -> p1.getName().compareTo(p2.getName());
//        Comparator<Person> byAge = (p1, p2) -> compare(p1.getAge(), p2.getAge());

        // comparators defined by instance method reference, equivalent to the comparators above
        Comparator<Person> byName = Comparator.comparing(p -> p.getName());
        Comparator<Person> byAge = Comparator.comparing(p -> p.getAge());

        System.out.println("\nSORTED persons by name");
        PERSONS.stream()
                .sorted(byName)
                .forEach(p -> System.out.println("\u25E6 " + p));

        System.out.println("\nSORTED persons by age");
        PERSONS.stream()
                .sorted(byAge)
                .forEach(p -> System.out.println("\u25E6 " + p));
    }

    private static void sortStreamOfPrimitivesValuesByNaturalOrder() {
        System.out.println("\n----------- Sorting stream of primitives values by natural order -----------");
        double[] prices = new double[]{44.5, 65.0, 12.3, 4.1};
        System.out.println("prices = " + Arrays.toString(prices));
        System.out.println("SORTED prices");
        Arrays.stream(prices).sorted().forEach(p -> System.out.println("\u25E6 " + p));
    }

    private static void sortStreamRemovingDuplicates() {
        System.out.println("\n----------- Sorting stream removing duplicates -----------");
        Person.print(PERSONS);

        System.out.println("\nSORTED ages of the persons removing duplicates");
        PERSONS.stream()
                .mapToInt(p -> p.getAge())
                .sorted()
                .distinct()
                .forEach(age -> System.out.println("\u25E6 " + age));

        System.out.println("\nSORTED names of the persons removing duplicates");
        PERSONS.stream()
                .map(p -> p.getName())
                .sorted()
                .distinct()
                .forEach(name -> System.out.println("\u25E6 " + name));
    }
}

class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    static void print(List<Person> personList) {
        System.out.println("persons = {");
        for (Person p : personList)
            System.out.println("\t" + p);
        System.out.println("}");
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "name = " + name + ", age = " + age;
    }
}