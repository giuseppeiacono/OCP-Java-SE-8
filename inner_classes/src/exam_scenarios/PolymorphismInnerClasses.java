package exam_scenarios;

/**
 * Scenario:
 *  Polymorphism applied to inner classes
 *
 * This snippet shows that polymorphism works exactly in the same way for both top-level classes and inner classes
 */
public class PolymorphismInnerClasses {

    public static void main(String[] args) {

        // Method-local inner class
        class Horse {
            public String name;

            public Horse(String s) {
                name = s;
            }
        }

        Object obj = new Horse("Zippo");
        // COMPILER ERROR: you can access only members defined in class Object, because of polymorphism rules
//        System.out.println(obj.name);

        Horse horse = new Horse("Furia");
        System.out.println(horse.name);
    }
}
