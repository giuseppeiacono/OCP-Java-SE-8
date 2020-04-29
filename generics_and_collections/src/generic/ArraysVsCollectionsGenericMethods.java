package generic;

import java.util.ArrayList;
import java.util.List;

public class ArraysVsCollectionsGenericMethods {

    public static void main(String[] args) {
        // compiler allows to pass a Dog array to method which expects a supertype Animal array
        Dog[] dogArray = {new Dog(), new Dog()};
        checkAnimals(dogArray);

        // Compiler ERROR: polymorphism does not apply to collections
//        List<Dog> dogList = new ArrayList<>();
//        checkAnimals(dogList);
    }

    public static void checkAnimals(Animal[] animals) {
        for(Animal a : animals) {
            a.checkup();
        }

        // CORRECT: add a Dog to the actual Dog array
        animals[0] = new Dog();

        // it compiles, but produce an ArrayStoreException at runtime
        // because the actual array is of type Dog
        animals[1] = new Cat();
    }

    public static void checkAnimals(List<Animal> animals) {
        for(Animal a : animals) {
            a.checkup();
        }
    }
}

abstract class Animal {
    abstract void checkup();
}

class Dog extends Animal {
    public void checkup() {
        System.out.println("Dog");
    }
}

class Cat extends Animal {
    public void checkup() {
        System.out.println("Cat");
    }
}