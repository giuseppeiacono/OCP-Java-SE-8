public class NestedInnerClass {

    private int outerInt = 7;
    private String outerString = "outer";

    public static void main(String[] args) {
        System.out.println("\nAccess the nested class from the OUTER class");
        NestedInnerClass outerClass = new NestedInnerClass();
        outerClass.makeNestedClass();

        System.out.println("Access the nested class from an EXTERNAL class");
        AnotherClass anotherClass = new AnotherClass();
        anotherClass.accessNestedClass();
    }

    private void makeNestedClass() {
        NestedClass nestedClass = new NestedClass();
        nestedClass.seeOuter();
    }

    // declared at the same level of instance variables
    class NestedClass {

        private int nestedInt = 12;
        private String nestedString = "nested";

        public void seeOuter() {
            System.out.println("\u25E6 outerInt = " + outerInt);
            System.out.println("\u25E6 outerString = " + NestedInnerClass.this.outerString);
            System.out.println("\u25E6 nestedInt = " + nestedInt);
            System.out.println("\u25E6 nestedString = " + this.nestedString);
        }
    }
}

class AnotherClass {

    void accessNestedClass() {
        NestedInnerClass innerClasses = new NestedInnerClass();
        NestedInnerClass.NestedClass nestedClass = innerClasses.new NestedClass();
        nestedClass.seeOuter();
    }
}
