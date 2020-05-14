import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class StreamOfObjects {

    private static Stream<Integer> streamArray;
    private static Stream<String> streamFile;
    private static Stream<String> streamList;

    public static void main(String[] args) throws IOException {
        // from objects
        Stream<String> streamOf = Stream.of("mike", "ana", "philip");

        // from array
        Integer[] arrayInt = new Integer[]{1, 2, 3, 4};
        streamArray = Arrays.stream(arrayInt);

        // from file
        Path fileAbsPath = Paths.get("movies.txt");
        if (!Files.exists(fileAbsPath)) {
            Files.createFile(fileAbsPath);
        }
        streamFile = Files.lines(fileAbsPath);

        // from Collection
        List<String> listString = Arrays.asList("Atlanta", "Ragusa", "Lisboa");
        streamList = listString.stream();

        // from map
        // IMPORTANT: stream() method is defined into Collection interface, but Map does not extend it.
        //            That's why map MUST BE converted into Set to invoke stream()
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        Stream<Map.Entry<Integer, String>> streamMap = map.entrySet().stream();
    }
}
