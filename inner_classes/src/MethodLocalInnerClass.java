public class MethodLocalInnerClass {

    private String outerString = "outer";

    public static void main(String args[]) {
        MethodLocalInnerClass outerClass = new MethodLocalInnerClass();
        outerClass.doStuff();
    }

    void doStuff() {
        final String finalLocalVar = "final local variable";
        final String notFinalLocalVar = "not final local variable";

        class MyInner {
            public void seeOuter() {
                System.out.println("\nInvoked method-local inner class...");
                System.out.println("\u25E6 outerString = " + outerString);
                System.out.println("\u25E6 finalLocalVar = " + finalLocalVar);
                System.out.println("\u25E6 notFinalLocalVar = " + notFinalLocalVar);

                // COMPILER ERROR: method-local inner class can not modify NOT final local variables!
//                notFinalLocalVar = "changing the local variable";
            }
        }

        outerString = "Changing variable of the outer class";
        MyInner mi = new MyInner();
        mi.seeOuter();
    }
}
