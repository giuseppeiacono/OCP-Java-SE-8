import java.util.Optional;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class GenerateStreams {

    public static void main(String[] args) {
        iterateStream();
        generateStream();
        rangeOfPrimitiveStream();
    }

    private static void iterateStream() {
        System.out.println("\n------------ Iterate stream ------------");
        System.out.print("Iterate stream to produce 4 integers starting from 0 = { ");
        Stream.iterate(0, num -> num + 1)   // create an infinite stream from UnaryOperator
                .limit(4)                         // short-circuit operation to limit the infinite stream
                .forEach(n -> System.out.print(n + " "));
        System.out.println("}");
    }

    private static void generateStream() {
        System.out.println("\n------------ Generate stream ------------");
        Sensor sensor = new Sensor();
        System.out.println("Sensor is " + sensor.value);
        Stream<String> sensorStream = Stream.generate(() -> sensor.next());
        Optional<String> result =
                sensorStream
                        .filter(v -> v.equals("down"))
                        .findFirst();                   // short-circuit operation to limit the infinite stream
        result.ifPresent(sensorValue -> System.out.println("Sensor is " + sensorValue));
    }

    private static void rangeOfPrimitiveStream() {
        System.out.println("\n------------ Iterate stream ------------");

        System.out.print("\nRange of IntStream between 10 and 15 = { ");
        IntStream.range(10, 15)
                .forEach( n -> System.out.print(n + " ") );
        System.out.println("}");

        System.out.print("\nRange closed of IntStream between 10 and 15 = { ");
        IntStream.rangeClosed(10, 15)
                .forEach( n -> System.out.print(n + " ") );
        System.out.println("}");

        System.out.print("\nRange of LongStream between 0 and 25, skipped the first 20 values = { ");
        LongStream.range(0, 25)
                .skip(20)
                .forEach( n -> System.out.print(n + " ") );
        System.out.println("}");
    }
}

class Sensor {

    String value = "up";
    int i = 0;

    public Sensor() { }

    public String next() {
        i = i + 1;
        return i > 10 ? "down" : "up";
    }
}