package assertion;

public class AssertionTypes {

    public static void main (String[] args) {
        // remember to enable assertions before to run this code
        AssertionTypes assertion = new AssertionTypes();
        assertion.reallySimpleAssertion(2);
        assertion.simpleAssertion(30);
        assertion.simpleAssertion(-91);
    }

    public void reallySimpleAssertion(int x) {
        assert (x > 0);
        System.out.println("Really Simple assertion " + x + " > 0 is true");
    }

    public void simpleAssertion(int x) {
        // string message is printed when assertion is false
        assert (x > 0): "Simple assertion " + x + " > 0 is false because x=" + x;
        System.out.println("Simple assertion " + x + " > 0 is true");
    }
}
