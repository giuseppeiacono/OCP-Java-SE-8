package exam_scenarios;

/**
 * Scenario:
 *  Anonymous classes that extend abstract top-level class and abstract nested inner class
 *
 * At first sight, it seems it should not compile because we are trying to instantiate ABSTRACT classes.
 * But really we are instantiating anonymous classes which extends from abstract classes. It compiles and works fine
 */
public abstract class AbstractInnerClasses {

    public void who() {
        System.out.println("AbstractInnerClasses");
    }

    public abstract class NestedClass {
        public void who() {
            System.out.println("NestedClass");
        }
    }

    public static void main(String[] args) {
        AbstractInnerClasses anonymousTopLevelClass = new AbstractInnerClasses() {
            @Override
            public void who() {
                System.out.println("anonymous class which extends AbstractInnerClasses");
            }
        };

        AbstractInnerClasses.NestedClass anonymousNestedClass = anonymousTopLevelClass.new NestedClass() {
            @Override
            public void who() {
                System.out.println("anonymous class which extends AbstractInnerClasses.NestedClass");
            }
        };

        anonymousTopLevelClass.who();
        anonymousNestedClass.who();

        // COMPILE ERROR: abstract classes CANNOT BE instantiated!!!
//        AbstractInnerClasses abstractInnerClasses = new AbstractInnerClasses();
//        NestedClass nestedClass = abstractInnerClasses.new NestedClass();
    }
}
