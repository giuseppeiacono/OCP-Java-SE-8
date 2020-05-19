import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.lang.Integer.compare;

public class SortingStream {

    public static void main(String[] args) {
        sortStreamOfObjectsByNaturalOrder();
        sortingStreamOfObjectsByComparator();
        sortStreamOfPrimitivesValuesByNaturalOrder();
        sortStreamOfPrimitivesValuesByComparator();
    }

    private static void sortStreamOfObjectsByNaturalOrder() {
        System.out.println("\n----------- Sorting stream of objects by natural order -----------");
        List<String> colours = Arrays.asList("red", "yellow", "grey", "orange");
        System.out.println("colours = " + colours);
        System.out.println("SORTED colours");
        colours.stream().sorted().forEach(c -> System.out.println("\u25E6 " + c));
    }

    private static void sortingStreamOfObjectsByComparator() {
        System.out.println("\n----------- Sorting stream of objects by Comparator -----------");
        List<Person> persons = Arrays.asList(
                new Person("Fred", 34),
                new Person("Mark", 40),
                new Person("John Junior", 16)
        );
        System.out.println("persons = {");
        for (Person p : persons)
            System.out.println("\t" + p);
        System.out.println("}");
        Comparator<Person> byName = (p1, p2) -> p1.getName().compareTo(p2.getName());
        Comparator<Person> byAge = (p1, p2) -> compare(p1.getAge(), p2.getAge());

        System.out.println("\nSORTED persons by name");
        persons.stream()
                .sorted(byName)
                .forEach(p -> System.out.println("\u25E6 " + p));

        System.out.println("\nSORTED persons by age");
        persons.stream()
                .sorted(byAge)
                .forEach(p -> System.out.println("\u25E6 " + p));
    }

    private static void sortStreamOfPrimitivesValuesByNaturalOrder() {
        System.out.println("\n----------- Sorting stream of primitives values by natural order -----------");
        double[] prices = new double[]{44.5, 65.0, 12.3, 4.1};
        System.out.println("\nprices = " + Arrays.toString(prices));
        System.out.println("SORTED prices");
        Arrays.stream(prices).sorted().forEach(p -> System.out.println("\u25E6 " + p));
    }

    private static void sortStreamOfPrimitivesValuesByComparator() {
        System.out.println("\n----------- Sorting stream of primitives values by Comparator -----------");

    }
}

class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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