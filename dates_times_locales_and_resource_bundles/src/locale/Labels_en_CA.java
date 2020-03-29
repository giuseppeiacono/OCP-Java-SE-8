package locale;

import java.util.Arrays;
import java.util.ListResourceBundle;

public class Labels_en_CA extends ListResourceBundle {

    private static final Object[][] LABELS_en_CA = {
            {"boolean", true},
            {"list", Arrays.asList(1, 2, 3)},
            {"stringBuilder", new StringBuilder("string builder value")}
    };

    protected Object[][] getContents() {
        return LABELS_en_CA;
    }
}
