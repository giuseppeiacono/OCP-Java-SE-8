package generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomGenericClasses {

    public static void main(String[] args) {
        useRentalGeneric();
        useGenericWithTwoTypes();
        useAnimalHolder();
    }

    private static void useRentalGeneric() {
        Car c1 = new Car();
        Car c2 = new Car();
        List<Car> carList = new ArrayList<Car>();
        carList.add(c1);
        carList.add(c2);
        RentalGeneric<Car> carRental = new RentalGeneric<>(2, carList);

        // it won't need a cast
        Car carToRent = carRental.getRental();
        carRental.returnRental(carToRent);

        // COMPILER ERROR: we can ONLY add Car objects
//        carList.add(new Plane());
    }

    private static void useGenericWithTwoTypes() {
        GenericWithTwoTypes<String, Integer> twoTypes = new GenericWithTwoTypes<String, Integer>("foo", 42);
        String theT = twoTypes.getT();
        int theU = twoTypes.getU();
        System.out.println("one = " + theT + ", two = " + theU);
    }

    private static void useAnimalHolder() {
        AnimalHolder<Dog> dogHolder = new AnimalHolder<>();
        // COMPILER ERROR: Integer is not an Animal
//        AnimalHolder<Integer> x = new AnimalHolder<Integer>();
    }
}

class Car { }

class Plane { }

class RentalGeneric<T> { // "T" is for the type parameter

    // Use the class type for the List type
    private List<T> rentalPool;

    private int maxNum;

    // constructor takes a List of the class type
    public RentalGeneric(int maxNum, List<T> rentalPool) {
        this.maxNum = maxNum;
        this.rentalPool = rentalPool;
    }

    public T getRental() {
        return rentalPool.get(0);
    }

    public void returnRental(T returnedThing) {
        rentalPool.add(returnedThing);
    }
}

class GenericWithTwoTypes<T, U> {
    T one;
    U two;

    GenericWithTwoTypes(T one, U two) {
        this.one = one;
        this.two = two;
    }

    T getT() { return one; }

    U getU() { return two; }
}

class AnimalHolder<T extends Animal> { // use "T" instead of "?"
    T animal;
}