package common;

import java.nio.file.Files;
import java.nio.file.Path;

public class ConsolePrinting {

    public static String getFileTreeAlignment(Path path) {
        StringBuilder alignment = new StringBuilder();

        int i = Files.isDirectory(path) ? path.getNameCount()-1 : path.getNameCount()-2;
        for (; i > 0 ; i--) {
            alignment.append("\t");
        }
        if (!Files.isDirectory(path)) {
            alignment.append("  |-- ");
        }

        return alignment.toString();
    }
}
