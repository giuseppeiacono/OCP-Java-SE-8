package nio;

import java.nio.file.Path;
import java.nio.file.Paths;

public class NIO2WorkWithPath {

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET  = "\u001B[0m";
    private static final Path RELATIVE_PATH = Paths.get("io_nio/src/nio/NIO2WorkWithPath.java");

    public static void main(String[] args) {
        getPathInfo();
        normalizePath();
        resolvePath();
        relativizePath();
    }

    private static void getPathInfo() {
        System.out.println("\n--------------- Retrieving information about relativePath ---------------");
        System.out.println("RELATIVE relativePath: " + RELATIVE_PATH);
        System.out.println("\u25E6 getFileName: " + RELATIVE_PATH.getFileName());
        System.out.println("\u25E6 getName(1): " + RELATIVE_PATH.getName(1));
        System.out.println("\u25E6 getNameCount: " + RELATIVE_PATH.getNameCount());
        System.out.println("\u25E6 getParent: " + RELATIVE_PATH.getParent());
        System.out.println("\u25E6 getRoot: " + RELATIVE_PATH.getRoot() + "\t // because relative relativePath has no root");
        System.out.println("\u25E6 subpath(0, 2): " + RELATIVE_PATH.subpath(0, 2));
    }

    private static void normalizePath() {
        System.out.println("\n--------------- Normalize path ---------------------------------------------");
        String startPath = "dates_times_locales_and_resource_bundles/src";
        String upTwoDirectories = "../..";
        String endPath = "io_nio/src";
        Path path = Paths.get(startPath, upTwoDirectories, endPath);
        System.out.println("Path to normalize: " + path);
        System.out.println("Normalized path: " + path.normalize());
    }

    private static void resolvePath() {
        System.out.println("\n--------------- Resolve path ---------------------------------------------");
        Path absolutePath = Paths.get("/home/giuseppe/Documents/IntelliJ projects/OCP-Java-SE-8");
        Path relativePath = Paths.get("io_nio/src");
        Path filePath = Paths.get("NIO2WorkWithPath.java");

        System.out.println("Legal examples of resolve method:");
        System.out.println("\u25E6 absolute + relative: " + absolutePath.resolve(relativePath));
        System.out.println("\u25E6 absolute + file: " + absolutePath.resolve(filePath));
        System.out.println("\u25E6 relative + file: " + relativePath.resolve(filePath));
        System.out.println(ANSI_RED + "The method resolve() does not check if the path returned exists!" + ANSI_RESET);

        System.out.println("\nILLEGAL use of resolve method:");
        System.out.println("\u25E6 " + ANSI_RED + "relative + absolute: " + ANSI_RESET + relativePath.resolve(absolutePath));
        System.out.println("\u25E6 " + ANSI_RED + "file + relative: " + ANSI_RESET + filePath.resolve(relativePath));
        System.out.println("\u25E6 " + ANSI_RED + "file + absolute: " + ANSI_RESET + filePath.resolve(absolutePath));
    }

    private static void relativizePath() {
        System.out.println("\n--------------- Relativize path ---------------------------------------------");
        String classPath = NIO2WorkWithPath.class.getClassLoader().getResource("").getPath();
        Path absoluteClassPath = Paths.get(classPath);
        Path absolute1 = absoluteClassPath.subpath(0, 2);
        Path absolute2 = absoluteClassPath.subpath(0, 3);
        int nameCount = absoluteClassPath.getNameCount();
        Path relative1 = absoluteClassPath.subpath(3,   nameCount -1);
        Path relative2 = absoluteClassPath.subpath(nameCount -2, nameCount -1);

        System.out.println("class path = " + classPath);
        System.out.println("absolute1 = " + absolute1);
        System.out.println("absolute2 = " + absolute2);
        System.out.println("relative1 = " + relative1);
        System.out.println("relative2 = " + relative2);

        System.out.println("\nLegal examples of relativize method:");
        System.out.println("\u25E6 absolute1.relativize(absolute2) = " + absolute1.relativize(absolute2));
        System.out.println("\u25E6 absolute2.relativize(absolute1) = " + absolute2.relativize(absolute1));
        System.out.println("\u25E6 relative1.relativize(relative2) = " + relative1.relativize(relative2));
        System.out.println(ANSI_RED + "The method relativize() does not check if the path returned exists!" + ANSI_RESET);

        System.out.println("\nILLEGAL use of relativize method:");
        System.out.println("\u25E6 absolute1.relativize(relative1) = " + absolute1.relativize(relative1));
        System.out.println(ANSI_RED + "Java can't figure out how to make a relative path out of one ABSOLUTE path and one RELATIVE path" + ANSI_RESET);
    }
}
