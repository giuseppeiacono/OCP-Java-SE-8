package exam_scenarios;

/**
 * Scenario:
 *  Top-level class, Nested inner class and Method-local inner class with the same name
 *
 * This snippet is focused on the way to instantiate this classes with the same name
 * depending on the place of code we need them
 */
public class MixingInnerClasses {

    public static void main(String[] args) {
        new MixingInnerClasses().go();
    }

    void go() {
        new A().m();  // instantiate the top-level class A

        // Method-local inner class
        class A {
            void m() {
                System.out.println("inner");
            }
        }

        new A().m();  // from this point, new A() instantiates the Method-local inner class above

        // the way to instantiate the nested class A
        // after the definition of the Method-local inner class A
        new MixingInnerClasses().new A().m();
    }

    // Nested inner class
    class A {
        void m() {
            System.out.println("middle");
        }
    }
}

// Top-level class
class A {
    void m() {
        System.out.println("outer");
    }
}