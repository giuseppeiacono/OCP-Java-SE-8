package date_and_time;

import java.util.Arrays;
import java.util.ListResourceBundle;

public class Labels_en_CA extends ListResourceBundle {

    private static final Object[][] LABELS_en_CA = {
            {"boolean", true},
            {"list", Arrays.asList(1, 2, 3)},
            {"stringBuilder", new StringBuilder("StringBuilder")}
    };

    protected Object[][] getContents() {
        return LABELS_en_CA;
    }
}
