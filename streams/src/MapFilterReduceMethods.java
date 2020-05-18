import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class MapFilterReduceMethods {

    public static void main(String[] args) {
        pricesAverageOfREadingsFrom2000();
        squaresGraterThan18();
    }

    private static void pricesAverageOfREadingsFrom2000() {
        List<Reading> readings = Arrays.asList(
                new Reading(2010, 5, 6, 12.5),
                new Reading(2020, 1, 1, 36.0),
                new Reading(1902, 3, 30, 8.54)
        );

        // price's average of those readings from the year 2000
        OptionalDouble priceAverage = readings.stream()
                .filter(r -> r.getYear() >= 2000)
                .mapToDouble(r -> r.getPrice())
                .average();

        if (priceAverage.isPresent())
            System.out.println("\nPrice's average of the reading from the year 2000 is " + priceAverage.getAsDouble() + "€");
        else
            System.out.println("\nThere are no reading that match the filters");
    }

    private static void squaresGraterThan18() {
        Double[] doubleArray = new Double[]{4.0, 55.0, 8.0, 2.0};
        System.out.println("\narray = " + Arrays.toString(doubleArray));
        System.out.println("Follow the squares root of these values >= 1.9");

        // calculate the square root of each array value, then filter and print those ones >= 1.9
        Arrays.stream(doubleArray)
                .mapToDouble(n -> Math.sqrt(n))
                .filter(d -> d >= 1.9)
                .forEach(square -> {
                    if (Double.isNaN(square))
                        System.out.println("This value is Nan");
                    else
                        System.out.println("\u25E6 " + square);
                });
    }
}

class Reading {

    int year;
    int month;
    int day;
    double price;

    Reading(int year, int month, int day, double price) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public double getPrice() {
        return price;
    }
}