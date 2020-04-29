package generic;

import java.util.ArrayList;
import java.util.List;

public class ModifyNonGenericList {

    public static void main (String[] args) {
        List<Integer> myList = new ArrayList<>();
        myList.add(4);
        myList.add(6);

        modifyList(myList);
        System.out.println(myList); // [4, 6, 2, "it is not an Integer"]

        // COMPILER ERROR!!!
        // the element with index 3 is a String,
        // but you can't get a String from the generic Integer list, even if the cast is correct
        // String s = (String) myList.get(3);
    }

    private static void modifyList(List nongenericList) {
        // it compiles and works fine because it add an integer to a list of integers
        nongenericList.add(2);

        // you can add any type of object to a nongeneric list, but in this case the compiler know
        // that you passed in an Integer generic collection, so it generates a WARNING like:
        // uses unchecked or unsafe operations
        nongenericList.add("it is not an Integer");

        // You can get any object of a nongeneric list if you apply the correct cast
        String s = (String) nongenericList.get((3));
    }
}
