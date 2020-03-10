package assertion;

public class AssertionIncorrectUse {

    public static int COUNT = 23;

    public static void main(String[] args) {
        assert (modifyCOUNT());
    }

    public static boolean modifyCOUNT() {
        COUNT++;
        return true;
    }

}
