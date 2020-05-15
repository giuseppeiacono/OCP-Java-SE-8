import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalLong;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class StreamOfPrimitives {

    public static void main(String[] args) {
        System.out.println("\n--------- Streams of primitives values ---------");
        fromPrimitiveValues();
        fromArryaOfPrimitiveValues();

        System.out.println("\n\n--------- Terminal operations available for streams of primitives values ---------");
        long[] array = new long[]{-46778, -4, 0, 445, 920, 1050};
        System.out.println("\nlongArray = " + Arrays.toString(array));

        // WARNING
        // you can not use a stream two o more times like a data structure,
        // else you'll get a COMPILER ERROR: stream has already been operated upon or closed
        System.out.println("sum() = " + Arrays.stream(array).sum());
        System.out.println("count() = " + Arrays.stream(array).count());

        // max(), min() and average() return an Optional value
        max(Arrays.stream(array));
        min(Arrays.stream(array));
        average(Arrays.stream(array));

        // stream primitive fields of collection's objects
        streamPrimitiveFieldsOfCollectionObjects();
    }

    private static void fromPrimitiveValues() {
        System.out.println("\nFrom primitive values with the static method of()");

        // from int values
        IntStream intStreamOf = IntStream.of(1, 2, 3, 4, 5);
        System.out.print("\u25E6 intStreamOf = ");
        intStreamOf.forEach( i -> System.out.print(i + " ") );

        // from double values
        DoubleStream doubleStreamOf = DoubleStream.of(1.2, 5.78, 0.0);
        System.out.print("\n\u25E6 doubleStreamOf = ");
        doubleStreamOf.forEach( d -> System.out.print(d + " ") );

        // from long values
        LongStream longStreamOf = LongStream.of(5222333, 99999999, 1111111111);
        System.out.print("\n\u25E6 longStreamOf = ");
        longStreamOf.forEach( l -> System.out.print(l + " ") );
    }

    private static void fromArryaOfPrimitiveValues() {
        System.out.println("\n\nFrom array of primitive values");

        // from array of int
        int[] arrayInt = new int[]{55, 77, 99};
        IntStream intStream = Arrays.stream(arrayInt);
        System.out.print("\u25E6 intStream = ");
        intStream.forEach( i -> System.out.print(i + " ") );

        // from array of double
        double[] arrayDouble = new double[]{133.4, 12.11, 0.0};
        DoubleStream doubleStream = Arrays.stream(arrayDouble);
        System.out.print("\n\u25E6 doubleStream = ");
        doubleStream.forEach( d -> System.out.print(d + " ") );

        // from array of long
        long[] arrayLong = new long[]{897879879, 312312321, 52222441};
        LongStream longStream = Arrays.stream(arrayLong);
        System.out.print("\n\u25E6 longStream = ");
        longStream.forEach( l -> System.out.print(l + " ") );
    }

    private static void max(LongStream longStream) {
        OptionalLong max = longStream.max();
        if (max.isPresent())
            System.out.println("max() = " + max.getAsLong());
        else
            System.out.println("Empty optional!");
    }

    private static void min(LongStream longStream) {
        OptionalLong min = longStream.min();
        if (min.isPresent())
            System.out.println("min() = " + min.getAsLong());
        else
            System.out.println("Empty optional!");
    }

    private static void average(LongStream longStream) {
        OptionalDouble average = longStream.average();
        if (average.isPresent())
            System.out.println("average() = " + average.getAsDouble());
        else
            System.out.println("Empty optional!");
    }

    private static void streamPrimitiveFieldsOfCollectionObjects() {
        List<Measurements> list = Arrays.asList(
                new Measurements(1, 5.7, 111111111),
                new Measurements(2, 18.8, 222222222),
                new Measurements(3, 99.9, 333333333)
        );
        System.out.print("\nlist = " + list);

        // int field
        int sum = list.stream()
                .mapToInt(e -> e.getHeight())
                .sum();
        System.out.println("\nsum() of heights = " + sum);

        // double field
        OptionalDouble average = list.stream()
                .mapToDouble(e -> e.getLength())
                .average();
        if (average.isPresent())
            System.out.println("average() of lengths = " + average.getAsDouble());
        else
            System.out.println("Empty optional!");

        // long field
        OptionalLong max = list.stream()
                .mapToLong(e -> e.getWeight())
                .max();
        if (max.isPresent())
            System.out.println("max() of weights = " + max.getAsLong());
        else
            System.out.println("Empty optional!");
    }
}

class Measurements {

    private int height;
    private double length;
    private long weight;

    public Measurements(int height, double length, long weight) {
        this.height = height;
        this.length = length;
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public long getWeight() {
        return weight;
    }

    public void setWeight(long weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "\n\t(height = " + height + ", length = " + length + ", weight = " + weight + ")";
    }
}
