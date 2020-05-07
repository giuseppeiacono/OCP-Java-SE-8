import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class Predicates {

    public static void main(String[] args) {
        List<IceCream> iceCreams = Arrays.asList(
                new IceCream("chocolate", 2.3),
                new IceCream("vanilla", 1.8),
                new IceCream("cream", 1.5)
        );
        singlePredicate(iceCreams.get(0));
        chainMultiplePredicates(iceCreams);
        predicateIsEquals(iceCreams.get(1));
    }

    private static void singlePredicate(IceCream iceCream) {
        Predicate<IceCream> chocolateFlavor = i -> "chocolate".equals(i.getFlavor());
        System.out.println("\nThe ice cream flavor is  chocolate: " + chocolateFlavor.test(iceCream));
    }

    private static void chainMultiplePredicates(List<IceCream> iceCreams) {
        Predicate<IceCream> chocolateFlavor = i -> "chocolate".equals(i.getFlavor());
        Predicate<IceCream> lessThenTwoEuros = i -> i.getPrice() < 2;

        System.out.println("\nIce creams which flavor is not chocolate and the price < 2€");
        for (IceCream iceCream : iceCreams) {
            if (chocolateFlavor.negate().and(lessThenTwoEuros).test(iceCream)) {
                System.out.println(iceCream);
            }
        }
    }

    private static void predicateIsEquals(IceCream iceCream) {
        IceCream vanillaIcecream = new IceCream("vanilla", 1.8);

        // this method expects an object, not primitive value!
        Predicate<IceCream> isEquals = Predicate.isEqual(vanillaIcecream);
        System.out.println("It is the vanilla ice cream: " + isEquals.test(iceCream));
    }
}

class IceCream {
    private String flavor;
    private double price;

    public IceCream(String flavor, double price) {
        this.flavor = flavor;
        this.price = price;
    }

    public String getFlavor() {
        return flavor;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "flavor = " + flavor + ", price = " + price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IceCream iceCream = (IceCream) o;
        return Double.compare(iceCream.price, price) == 0 &&
                Objects.equals(flavor, iceCream.flavor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flavor, price);
    }
}