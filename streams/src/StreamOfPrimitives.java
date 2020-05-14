import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalLong;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class StreamOfPrimitives {

    public static void main(String[] args) {
        System.out.println("\n--------- Streams of primitives values ---------");
        intStream();
        doubleStream();
        longStream();

        System.out.println("\n\n--------- Terminal operations available for streams of primitives values ---------");
        long[] array = new long[]{-46778, -4, 0, 445, 920, 1050};
        System.out.println("\nlongStream = " + Arrays.toString(array));

        // WARNING
        // you can not use a stream two o more times like a data structure,
        // else you'll get a COMPILER ERROR: stream has already been operated upon or closed
        System.out.println("sum() = " + Arrays.stream(array).sum());
        System.out.println("count() = " + Arrays.stream(array).count());

        // max(), min() and average() return an Optional value
        max(Arrays.stream(array));
        min(Arrays.stream(array));
        average(Arrays.stream(array));
    }

    private static void intStream() {
        // from int values
        IntStream intStreamOf = IntStream.of(1, 2, 3, 4, 5);
        System.out.print("\nintStreamOf = ");
        intStreamOf.forEach( i -> System.out.print(i + " ") );

        // from array
        int[] arrayInt = new int[]{55, 77, 99};
        IntStream intStream = Arrays.stream(arrayInt);
        System.out.print("\nintStream = ");
        intStream.forEach( i -> System.out.print(i + " ") );
    }

    private static void doubleStream() {
        // from double values
        DoubleStream doubleStreamOf = DoubleStream.of(1.2, 5.78, 0.0);
        System.out.print("\ndoubleStreamOf = ");
        doubleStreamOf.forEach( d -> System.out.print(d + " ") );

        // from array
        double[] arrayDouble = new double[]{133.4, 12.11, 0.0};
        DoubleStream doubleStream = Arrays.stream(arrayDouble);
        System.out.print("\ndoubleStream = ");
        doubleStream.forEach( d -> System.out.print(d + " ") );
    }

    private static void longStream() {
        // from long values
        LongStream longStreamOf = LongStream.of(5222333, 99999999, 1111111111);
        System.out.print("\nlongStreamOf = ");
        longStreamOf.forEach( l -> System.out.print(l + " ") );

        // from array
        long[] arrayLong = new long[]{897879879, 312312321, 52222441};
        LongStream longStream = Arrays.stream(arrayLong);
        System.out.print("\nlongStream = ");
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
}
