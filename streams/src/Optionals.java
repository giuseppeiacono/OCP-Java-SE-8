import java.util.Optional;

public class Optionals {

    public static void main(String[] args) {
        optionalOf();
        optionalOfNullable();
        optionalOrElse();
    }

    private static void optionalOf() {
        System.out.println("\n------------- Optional.of() -------------");
        String name = "Joseph";
        System.out.println("name = " + name);

        // COMPILER ERROR: it throws java.lang.NullPointerException if the argument is null
        Optional<String> optionalString = Optional.of(name);
        printOptionalValue("optionalString", optionalString);
    }

    private static void optionalOfNullable() {
        System.out.println("\n------------- Optional.ofNullable() -------------");
        String name = "Maria";
        System.out.println("name = " + name);
        Optional<String> optionalName = Optional.ofNullable(name);
        printOptionalValue("optionalName", optionalName);

        String surname = null;
        System.out.println("\nsurname = " + surname);
        Optional<String> optionalSurname = Optional.ofNullable(surname);    // create an empty Optional because the argument is null
        printOptionalValue("optionalSurname", optionalSurname);
    }

    private static void optionalOrElse() {
        System.out.println("\n------------- Optional.orElse() -------------");
        Integer age = null;
        System.out.println("age = " + age);
        Optional<Integer> optionalInteger = Optional.ofNullable(age);
        Integer integer = optionalInteger.orElse(34);
        System.out.println("optionalInteger = " + integer);

        age = 56;
        System.out.println("\nage = " + age);
        optionalInteger = Optional.of(age);
        integer = optionalInteger.orElse(34);
        System.out.println("optionalInteger = " + integer);
    }

    private static <T> void printOptionalValue(String label, Optional<T> optionalString) {
        if (optionalString.isPresent())
            System.out.println(label + " = " + optionalString.get());
        else
            System.out.println("optional value is empty");
    }
}
