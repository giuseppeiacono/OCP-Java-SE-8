public class AnonymousInnerClasses {

    public static void main(String[] args) {
        anonymousSubclass();
        anonymousImplementor();
    }

    private static void anonymousSubclass() {
        Food p = new Popcorn() {
            public void pop() {
                System.out.println("anonymous popcorn");
            }
        };  // semicolon is mandatory to compile successfully

        p.food();

        // COMPILER ERROR:
        // There is no pop() method in the class Food
        // It's like any polymorphic reference
//        p.pop();
    }

    private static void anonymousImplementor() {
        Beverage beverage = new Beverage() {
            @Override
            public void drink() {
                System.out.println("drink");
            }
        };  // semicolon is mandatory to compile successfully

        beverage.drink();
    }
}

interface Beverage {
    public void drink();
}

class Food {
    public void food() {
        System.out.println("food");
    }
}

class Popcorn extends Food {
    public void pop() {
        System.out.println("popcorn");
    }
}
