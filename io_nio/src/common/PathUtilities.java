package common;

import nio.file_visitor.PrintAllFileTree;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class PathUtilities {

    private static final String TMP_DIR_PREFIX = "Java_8_OCP_";

    private static Path TMP_DIRS_TO_DELETE_PATH = null;

    private static final Path TMP_DIRS_TO_DELETE_RELATIVE_PATH = Paths.get("io_nio/src/tmp_dirs_to_delete.txt");

    private static final List<String> TMP_SUB_DIRS = Arrays.asList("/java/class", "/java/src", "/css");

    private static final List<String> TMP_FILES = Arrays.asList(
            "/java/class/Circle.class",
            "/java/class/Square.class",
            "/java/src/Circle.java",
            "/java/src/Square.java",
            "/css/style.css");

    static {
        try {
            TMP_DIRS_TO_DELETE_PATH = createTmpDirsToDeleteFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        deleteTmpDirs();
        deleteTmpDirsToDeleteFile();
    }

    private static Path createTmpDirsToDeleteFile() throws IOException {
        Path projectPath = Paths.get("").toAbsolutePath();
        Path tmpDirsToDeletePath = projectPath.resolve(TMP_DIRS_TO_DELETE_RELATIVE_PATH);
        if (!Files.exists(tmpDirsToDeletePath)) {
            Files.createFile(tmpDirsToDeletePath);
        }
        return tmpDirsToDeletePath;
    }

    private static void deleteTmpDirs() throws IOException {
        System.out.println("Starting to delete all temporal directories created by classes of io_nio module...");

        try (BufferedReader tmpDirsToDelete =
                     new BufferedReader(new FileReader(TMP_DIRS_TO_DELETE_PATH.toString()))) {
            String dirToDelete;
            while( (dirToDelete = tmpDirsToDelete.readLine()) != null) {
                deleteTmpDirRecursively(Paths.get(dirToDelete));
            }
        }
    }

    private static void deleteTmpDirRecursively(Path dirToDelete) throws IOException {
        Files.walk(dirToDelete)
                .sorted(Comparator.reverseOrder())  // to delete the content before the main directory
                .map(Path::toFile)
                .forEach(path -> {
                    path.delete();
                    System.out.println("\tDeleted " + path);
                });
    }

    private static void deleteTmpDirsToDeleteFile() throws IOException {
        Files.deleteIfExists(TMP_DIRS_TO_DELETE_PATH);
        System.out.println("Deleted " + TMP_DIRS_TO_DELETE_PATH);
    }

    /**
     * Create the following temporal directory for Unix systems:
     *
     * / (root)
     *      tmp
     *          Java_8_OCP_[numerical_suffix]
     * 		        java
     * 			        src
     * 			          |-- Square.java
     * 			          |-- Circle.java
     * 			        class
     * 			          |-- Square.class
     * 			          |-- Circle.class
     * 		        css
     * 		          |-- style.css
     */
    public static Path createTmpDirStructure() throws IOException {
        Path tmpDirPath = Files.createTempDirectory(TMP_DIR_PREFIX);
        addPathToTmpDirsToDeleteFile(tmpDirPath);
        createTmpSubDirs(tmpDirPath);
        createTmpFiles(tmpDirPath);
        printFileTree(tmpDirPath);
        return tmpDirPath;
    }

    private static void addPathToTmpDirsToDeleteFile(Path newTmpDirPath) throws IOException {
        try (PrintWriter tmpDirsToDelete =
                     new PrintWriter(new FileWriter(TMP_DIRS_TO_DELETE_PATH.toString(), true))) {
            tmpDirsToDelete.println(newTmpDirPath.toString());
            tmpDirsToDelete.flush();
        }
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
