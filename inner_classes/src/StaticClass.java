public class StaticClass {

    private int outerInt = 5;

    static class NestedClassStatic {
        void introduce() {
            System.out.println("I'm a static class");

            // COMPILER ERROR: it has no access to the non-static variables/methods of the outer class
//            System.out.println(outerInt);
        }
    }

    public static void main(String[] args) {
        NestedClassStatic nestedClassStatic = new NestedClassStatic();
        nestedClassStatic.introduce();

        // look at the syntax
        Another.AnotherStaticClass anotherStaticClass = new Another.AnotherStaticClass();
        anotherStaticClass.go();
    }
}

class Another {
    static class AnotherStaticClass {
        void go() {
            System.out.println("I'm another static class");
        }
    }
}
