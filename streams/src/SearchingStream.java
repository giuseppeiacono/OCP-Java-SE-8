import java.time.Year;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public class SearchingStream {

    public static final String ANSI_BLUE   = "\u001B[34m";
    public static final String ANSI_RESET  = "\u001B[0m";

    public static void main(String[] args) {
        searchingStreamOfObjects();
        searchingStreamOfPrimitivesValues();
    }

    private static void searchingStreamOfObjects() {
        System.out.println("\n----------- Methods to sort streams of objects -----------");
        List<String> cities = Arrays.asList("Rome", "Milan", "Seville", "RAGUSA");
        System.out.println("cities = " + cities);

        boolean allMatchNameLength = cities.stream()
                .allMatch(c -> c.length() > 3);
        System.out.println("\nThe name of all cities is > 3 : " + ANSI_BLUE + allMatchNameLength + ANSI_RESET);

        boolean anyUpperCaseCityName = cities.stream()
                .anyMatch(c -> c.equals(c.toUpperCase()));
        System.out.println("At least one of the city names is uppercase : " + ANSI_BLUE + anyUpperCaseCityName + ANSI_RESET);

        boolean noneCityNameStartsWithA = cities.stream()
                .noneMatch(c -> c.startsWith("A"));
        System.out.println("None of the city names start with A : " + ANSI_BLUE + noneCityNameStartsWithA + ANSI_RESET);

        Optional<String> firstLowerCasecityName = cities.stream()
                .filter(c -> c.equals(c.toLowerCase()))
                .findFirst();
        String cityName = firstLowerCasecityName.orElse("NO MATCH");
        System.out.println("The first lowercase city name found is " + ANSI_BLUE + cityName + ANSI_RESET);

        Optional<String> anyCityNameThatLengthMatchs = cities.stream()
                .filter(c -> c.length() > 4)
                .findAny();
        cityName = anyCityNameThatLengthMatchs.orElse("NO MATCH");
        System.out.println("Any city name with length > 4 is " + ANSI_BLUE + cityName + ANSI_RESET);
    }

    private static void searchingStreamOfPrimitivesValues() {
        System.out.println("\n----------- Methods to sort streams of objects -----------");
        searchingIntYears();
        searchingDoublePrices();
    }

    private static void searchingIntYears() {
        int[] years = new int[]{1999, 2001, 2010, 2019};
        System.out.println("years = " + Arrays.toString(years));

        boolean allYearsGraterThan1980 = Arrays.stream(years)
                .allMatch(y -> y > 2000);
        System.out.println("\u25E6 all years are > 2000 : " + ANSI_BLUE + allYearsGraterThan1980 + ANSI_RESET);

        boolean anyYearBetween2000And2010 = Arrays.stream(years)
                .anyMatch(y -> y >= 2000 && y <= 2010);
        System.out.println("\u25E6 any year between 2000 and 2010 : " + ANSI_BLUE + anyYearBetween2000And2010 + ANSI_RESET);

        boolean noneYearsAfterCurrentOne = Arrays.stream(years)
                .noneMatch(y -> y > Year.now().getValue());
        System.out.println("\u25E6 none of the years are after the current one : " + ANSI_BLUE + noneYearsAfterCurrentOne + ANSI_RESET);
    }

    private static void searchingDoublePrices() {
        double[] prices = new double[]{45.2, 6.0, 77.9, 1220.1};
        System.out.println("\nprices = " + Arrays.toString(prices));

        OptionalDouble firstPriceMatch = Arrays.stream(prices)
                .filter(p -> p > 20.5)
                .findFirst();
        if (firstPriceMatch.isPresent())
            System.out.println("\u25E6 the first price > 47.24€ found is " + ANSI_BLUE + firstPriceMatch.getAsDouble() + ANSI_RESET);
        else
            System.out.println("\u25E6 the first price > 47.24€ found is " + ANSI_BLUE + "NO MATCH" + ANSI_RESET);

        OptionalDouble anyPriceBetween50And100 = Arrays.stream(prices)
                .filter(p -> p >= 50.0 && p <= 100.0)
                .findAny();
        if (anyPriceBetween50And100.isPresent())
            System.out.println("\u25E6 any price between 50.0€ and 100.0€ is " + ANSI_BLUE + anyPriceBetween50And100.getAsDouble() + ANSI_RESET);
        else
            System.out.println("\u25E6 any price between 50.0€ and 100.0€ is " + ANSI_BLUE + "NO MATCH" + ANSI_RESET);
    }
}
