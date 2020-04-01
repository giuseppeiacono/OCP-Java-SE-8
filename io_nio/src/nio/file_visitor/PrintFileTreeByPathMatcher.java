package nio.file_visitor;

import common.ConsolePrinting;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 *  Custom file visitor in charge of:
 *      1. print visited file name
 *      2. print visited folder name that match {@code pathMatcher}
 *      3. skip the content of folders that do not match {@code pathMatcher}
 */
public class PrintFileTreeByPathMatcher extends SimpleFileVisitor<Path> {

    private PathMatcher pathMatcher;

    public PrintFileTreeByPathMatcher(String glob) {
        this.pathMatcher = FileSystems.getDefault().getPathMatcher(glob);
    }

    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
        System.out.println(ConsolePrinting.getFileTreeAlignment(dir) + dir.getFileName());
        return FileVisitResult.CONTINUE;
    }

    public FileVisitResult visitFile(Path visitedPath, BasicFileAttributes attrs) {
        if (!pathMatcher.matches(visitedPath)) {
            return FileVisitResult.SKIP_SUBTREE;
        }
        String alignment = ConsolePrinting.getFileTreeAlignment(visitedPath);
        System.out.println(alignment + visitedPath.getFileName());
        return FileVisitResult.CONTINUE;
    }

    public FileVisitResult visitFileFailed(Path visitedPath, IOException exc) {
        return FileVisitResult.CONTINUE;
    }

    public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
        return FileVisitResult.CONTINUE;
    }
}
