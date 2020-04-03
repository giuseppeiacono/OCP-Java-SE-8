package nio;

import common.TempDirUtility;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;

public class WatcherServiceSamples {

    public static void main(String[] args) throws IOException {
        registerWatcherOnASinglePath();
        registerWatcherRecursivelyOnAFileTree();
    }

    /**
     * Create not empty temporal directory, register the watcher on it and
     * wait for the manual deletion of java directory
     */
    private static void registerWatcherOnASinglePath() throws IOException {
        System.out.println("\n--------------- Register watcher on a single directory ---------------");

        Path dir = TempDirUtility.createTmpDirStructure();

        // register watcher
        WatchService watcher = FileSystems.getDefault().newWatchService(); // file system-specific code
        dir.register(watcher, ENTRY_DELETE);

        System.out.println("\nThe watcher is looking for the deletion of CHILD directories called 'css'...");
        PathMatcher childDirMatcher = FileSystems.getDefault().getPathMatcher("glob:css");
        processDeleteEvent(watcher, childDirMatcher);
    }

    /**
     * Create not empty temporal directory, register the watcher recursively on it and
     * wait for the manual deletion of .java and .css files (match by {@link PathMatcher})
     */
    private static void registerWatcherRecursivelyOnAFileTree() throws IOException {
        System.out.println("\n--------------- Register watcher recursively on each inner directory ---------------");

        Path dir = TempDirUtility.createTmpDirStructure();

        // register watcher recursively
        WatchService watcher = FileSystems.getDefault().newWatchService(); // file system-specific code
        Files.walkFileTree(dir, new SimpleFileVisitor<>() {
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                dir.register(watcher, ENTRY_DELETE);    // watch each inner directory
                return FileVisitResult.CONTINUE;
            }
        });

        System.out.println("\nThe watcher is looking for the deletion of INNER directories called 'src'...");
        PathMatcher innerDirMatcher = FileSystems.getDefault().getPathMatcher("glob:src");
        processDeleteEvent(watcher, innerDirMatcher);
    }

    private static void processDeleteEvent(WatchService watcher, PathMatcher pathMatcher) {
        while (true) {
            WatchKey key;
            try {
                key = watcher.take();
            } catch (InterruptedException x) {
                return;
            }
            for (WatchEvent<?> event : key.pollEvents()) {
                WatchEvent.Kind<?> kind = event.kind();
                System.out.println("\nEvent details:");
                System.out.println("\u25E6 name: " + kind.name());
                System.out.println("\u25E6 type:" + kind.type());
                System.out.println("\u25E6 context:" + event.context());

                Path path = Paths.get(event.context().toString());
                if (pathMatcher.matches(path)) {
                    System.out.println("\nDeleted dir: " + path + "\nNow we can stop events processing...");
                    return; // stop loop
                }
            }
            key.reset();    // look for the next event
        }
    }
}
