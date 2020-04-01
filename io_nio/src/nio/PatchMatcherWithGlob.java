package nio;

import common.PathUtilities;
import nio.file_visitor.PrintFileTreeByPathMatcher;

import java.io.IOException;
import java.nio.file.*;

/**
 * It shows how {@code PathMatcher}, globs and file visitors can work together for several purposes.
 * For simplicity, it doesn't check if paths exist on the disk
 */
public class PatchMatcherWithGlob {

    public static void main(String[] args) throws IOException {
        checkPathsWithSimplePathMatchers();
        printFileTreeUsingFileVisitorAndPathMatcher();
    }

    private static void checkPathsWithSimplePathMatchers() {
        System.out.println("\n--------------- Matching paths against simple globs ---------------");
        Path path1 = Paths.get("/home/file.txt");
        Path path2 = Paths.get("file.txt");
        System.out.println("path1 = " + path1);
        System.out.println("path2 = " + path2);

        for (Glob glob : Glob.values()) {
            PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher(glob.getGlob());
            System.out.println("\n" + glob.getGlob());
            System.out.println("\u25E6 path1 match: " + pathMatcher.matches(path1));
            System.out.println("\u25E6 path2 match: " + pathMatcher.matches(path2));
        }
    }

    private static void printFileTreeUsingFileVisitorAndPathMatcher() throws IOException {
        System.out.println("\n--------------- Printing of the temporal file tree by file visitor and path matcher ---------------");
        Path tmpDirPath = PathUtilities.createTmpDirStructure();
        String trickyGlob = Glob.TRICKY.getGlob();
        System.out.println("\n" + trickyGlob);
        System.out.println("Follow files and directories that match this glob");
        PrintFileTreeByPathMatcher fileVisitor = new PrintFileTreeByPathMatcher(trickyGlob);
        Files.walkFileTree(tmpDirPath, fileVisitor);
    }
}