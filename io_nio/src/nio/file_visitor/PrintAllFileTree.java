package nio.file_visitor;

import common.ConsolePrinting;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 *  Custom file visitor to print the name of each file and directory of the file tree
 */
public class PrintAllFileTree extends SimpleFileVisitor<Path> {

    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
        System.out.println(ConsolePrinting.getFileTreeAlignment(dir) + dir.getFileName());
        return FileVisitResult.CONTINUE;
    }

    public FileVisitResult visitFile(Path visitedPath, BasicFileAttributes attrs) {
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
