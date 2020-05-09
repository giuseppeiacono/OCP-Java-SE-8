import java.util.Map;
import java.util.TreeMap;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Functions {

    public static void main(String[] args) {
        functionWithOneArgument();
        functionWithTwoArguments();
        passFunctionToMethodAsArgument();
        chainMultipleFunctions();
        unaryOperator();
    }

    private static void functionWithOneArgument() {
        System.out.println("\n-------------------- Function with 1 argument --------------------");

        // take an integer and return a String
        Function<Integer, String> answer = n -> {
            if (n == 10)
                return "ten";
            else
                return "The integer is not 10!";
        };
        System.out.println(answer.apply(10));
        System.out.println(answer.apply(33));
    }

    private static void functionWithTwoArguments() {
        System.out.println("\n-------------------- Function with 2 arguments --------------------");

        BiFunction<String, String, String> concatTwoStrings = (name, surname) -> name + " " + surname;
        System.out.println( concatTwoStrings.apply("Mike", "Anderson") );
        System.out.println( concatTwoStrings.apply("Kate", "McLyon") );
    }

    private static void passFunctionToMethodAsArgument() {
        System.out.println("\n-------------------- Passing function to method as an argument --------------------");
        Map<String, String> aprilWinner = new TreeMap<>() {{
            put("April 2017", "Bob");
            put("April 2016", "Annette");
            put("April 2015", "Lamar");
        }};
        BiConsumer<String, String> printMapEntry = (k, v) -> System.out.println("\u25E6 " + k + ": " + v);

        System.out.println("List, before checking April 2014");
        aprilWinner.forEach(printMapEntry);

        // no key for April 2014, so John Doe gets added to the map
        aprilWinner.computeIfAbsent("April 2014", (k) -> "John Doe");
        // key April 2014 now has a value, so Jane won't be added
        aprilWinner.computeIfAbsent("April 2014", (k) -> "Jane Doe");

        System.out.println("\nList, after checking April 2014");
        aprilWinner.forEach(printMapEntry);

        // use a BiFunction to replace all values in the map with uppercase values
        BiFunction<String, String, String> valueToUpperCase = (key, oldValue) -> oldValue.toUpperCase();
        aprilWinner.replaceAll(valueToUpperCase);
        System.out.println("\nList, after replacing values with uppercase");
        aprilWinner.forEach(printMapEntry);
    }

    private static void chainMultipleFunctions() {
        System.out.println("\n-------------------- Chaining multiple functions --------------------");
        Function<String, String> concatString = s -> s += "-suffix";
        Function<String, String> concatInt = s -> s += "-45";
        String s = "mike";
        System.out.println("The starting string is " + s);
        System.out.println("After functions were executed in sequence the string is " + concatString.andThen(concatInt).apply(s));
    }

    private static void unaryOperator() {
        System.out.println("\n-------------------- UnaryOperator --------------------");
        UnaryOperator<String> toLowerCase = s -> s.toLowerCase();
        String s = "PHILIP";
        System.out.println("The starting string is " + s);
        System.out.println("The result of UnaryOperator toLowerCase is " + toLowerCase.apply(s));
    }
}
