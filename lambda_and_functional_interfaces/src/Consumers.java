import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Consumers {

    public static void main(String[] args) {
        List<Friend> friendList = Arrays.asList(
                new Friend("Miguel", 44, 80),
                new Friend("Philip", 30, 70),
                new Friend("Alex", 18, 56)
        );

        singleConsumer(friendList);
        chainMultipleConsumers(friendList);
    }

    private static void singleConsumer(List<Friend> friendList) {
        System.out.println("\n--------------- Print the name of each friend using a consumer ---------------");
        Consumer<Friend> displayName = f -> System.out.println("name = " + f.getName());
        friendList.forEach(displayName);

        System.out.println("\nWe obtain the same result replacing the parameter of andThen() method with the corresponding LAMBDA expression...");
        friendList.forEach(f -> System.out.println("name = " + f.getName()));
    }

    private static void chainMultipleConsumers(List<Friend> friendList) {
        System.out.println("\n--------------- Print the name, the age and the weight of each friend chaining consumers ---------------");
        Consumer<Friend> displayName = f -> System.out.print("name = " + f.getName());
        Consumer<Friend> displayAge = f -> System.out.print(", age = " + f.getAge());
        Consumer<Friend> displayWeight = f -> System.out.println(", weight = " + f.getWeight());

        friendList.forEach(displayName.andThen(displayAge).andThen(displayWeight));

        System.out.println("\nWe obtain the same result replacing the parameter of andThen() method with the corresponding LAMBDA expression...");
        friendList.forEach(displayName
                .andThen(f -> System.out.print(", age = " + f.getAge()))
                .andThen(f -> System.out.println(", weight = " + f.getWeight()))
        );

        // COMPILER ERROR: you can't displayName with the corresponding LAMBDA
//        friendList.forEach( (f -> System.out.print("name = " + f.getName()))
//                .andThen(f -> System.out.print(", age = " + f.getAge()))
//                .andThen(f -> System.out.println(", weight = " + f.getWeight()))
//        );
    }
}

class Friend {
    private String name;
    private int age;
    private int weight;

    public Friend(String name, int age, int weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getWeight() {
        return weight;
    }
}
