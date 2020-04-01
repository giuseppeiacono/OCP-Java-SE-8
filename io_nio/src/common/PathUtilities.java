package common;

import nio.file_visitor.PrintAllFileTree;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class PathUtilities {

    private static final String TMP_DIR_PREFIX = "Java_8_OCP_";

    private static final List<String> TMP_SUB_DIRS = Arrays.asList("/java/class", "/java/src", "/css");

    private static final List<String> TMP_FILES = Arrays.asList(
            "/java/class/Circle.class",
            "/java/class/Square.class",
            "/java/src/Circle.java",
            "/java/src/Square.java",
            "/css/style.css");

    public static Path createTmpDirStructure() throws IOException {
        Path tmpDirPath = Files.createTempDirectory(TMP_DIR_PREFIX);
        createTmpSubDirs(tmpDirPath);
        createTmpFiles(tmpDirPath);
        printFileTree(tmpDirPath);

        return tmpDirPath;
    }

    private static void createTmpSubDirs(Path tmpDirPath) throws IOException {
        for (String dirRelativePath : TMP_SUB_DIRS) {
            Path path = Paths.get(tmpDirPath + dirRelativePath);
            Files.createDirectories(path);
        }
    }

    private static void createTmpFiles(Path tmpDirPath) throws IOException {
        for (String fileRelativePath : TMP_FILES) {
            Path path = Paths.get(tmpDirPath + fileRelativePath);
            Files.createFile(path);
        }
    }

    private static void printFileTree(Path tmpDirPath) throws IOException {
        System.out.println("\nCreated temporal directory structure:");
        PrintAllFileTree fileVisitor = new PrintAllFileTree();
        Files.walkFileTree(tmpDirPath, fileVisitor);
    }
}
