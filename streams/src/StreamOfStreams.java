import java.util.Arrays;
import java.util.List;

public class StreamOfStreams {

    private static final List<String> LIST_OF_ARRAYS = Arrays.asList(
            new String("rabbits dogs giraffes lions Java tigers"),
            new String("penguins Java deer birds Java Java monkeys"),
            new String("horses whales Java antelope bears Java"),
            new String("Java insects Java raccoons rats zebras"),
            new String("koalas snakes spiders cats hippopotamuses")
    );

    public static void main(String[] args) {
        System.out.println("\nlist of words = {");
        LIST_OF_ARRAYS.forEach(word -> System.out.println("\t" + word));
        System.out.println("}");

        long javaOccurrences =
                LIST_OF_ARRAYS.stream()
                        .map(line -> line.split(" "))
                        .flatMap(array -> Arrays.stream(array))     // stream arrays and join them in one new stream
                        .filter(w -> w.equals("Java"))
                        .count();

        System.out.println("\nNumber of 'Java' word occurrences = " + javaOccurrences);
    }
}