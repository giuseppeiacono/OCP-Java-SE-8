package java.nio;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NIO2WorkWithFilesAndDirectories {

    public static void main(String[] args) {

        // IMPORTANT!!!
        // The code check if directories and files already exist before to create them in order to avoid exceptions

        createPaths();
        createFilesAndDirectoriesOnTheDisk();
        copyMoveDeleteFiles();
        backwardCompatibilitybetweenIOandNIO2();
    }

    private static void createPaths() {
        System.out.println("\n--------------- Created just Path objects in several ways ---------------");

        Path filePath = Paths.get("/home/giuseppe/Desktop/file.txt");
        System.out.println("filePath = " + filePath);

        Path filePathWithoutSlashs = Paths.get("/", "home", "giuseppe", "Desktop", "another_file.txt");
        System.out.println("filePathWithoutSlashs = " + filePathWithoutSlashs);

        Path filePathFromDefaultFileSystem = FileSystems.getDefault().getPath("/", "home", "giuseppe", "Desktop", "another_file.txt");
        System.out.println("filePathFromDefaultFileSystem = " + filePathFromDefaultFileSystem);

        Path dirPath = Paths.get("/home/giuseppe/Desktop/my_dir");
        System.out.println("\ndirPath = " + dirPath);

        Path dirPathWithoutSlashs = Paths.get("/home/giuseppe/Desktop/my_dir");
        System.out.println("dirPathWithoutSlashs = " + dirPathWithoutSlashs);

        Path dirPathFromDefaultFileSystem = Paths.get("/home/giuseppe/Desktop/my_dir");
        System.out.println("dirPathFromDefaultFileSystem = " + dirPathFromDefaultFileSystem);

        // Just for Windows to browse to a folder in Iternet Explorer
        // Path windowsFile = Paths.get(URI.create("file///C:/temp"));
    }

    private static void createFilesAndDirectoriesOnTheDisk() {
        System.out.println("\n--------------- Created files and directories on the disk ---------------");

        Path newDirPath1 = Paths.get("/home/giuseppe/Desktop/NIO2_one_by_one");
        Path newDirPath2 = Paths.get("/home/giuseppe/Desktop/NIO2_one_by_one/files");
        Path filePath = Paths.get("/home/giuseppe/Desktop/NIO2_one_by_one/files/file.txt");

        Path newDirectoriesPath = Paths.get("/home/giuseppe/Desktop/NIO2_in_one_go/other_files/");
        Path anotherFilePath = Paths.get("/home/giuseppe/Desktop/NIO2_in_one_go/other_files/another_file.txt");

        try {
            createNewDirectoriesOneByOne(filePath, newDirPath1, newDirPath2);
            createNewDirectoriesInOneGo(newDirectoriesPath, anotherFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createNewDirectoriesOneByOne(Path filePath, Path... newDirPaths) throws IOException {
        System.out.println("Created new  directories ONE BY ONE");
        for (Path newDirPath: newDirPaths) {
            if (Files.notExists(newDirPath)) {
                Files.createDirectory(newDirPath);
                System.out.println("\tCreated directory " + newDirPath.getName(newDirPath.getNameCount()-1));
            }
        }
        if (Files.notExists(filePath)) {
            Files.createFile(filePath);
        }
        System.out.println("\tcreated file " + filePath.toString());
    }

    private static void createNewDirectoriesInOneGo(Path newDirectoriesPath, Path anotherFilePath) throws IOException {
        System.out.println("Created new  directories IN ONE GO");
        Files.createDirectories(newDirectoriesPath);
        if (Files.notExists(anotherFilePath)) {
            Files.createFile(anotherFilePath);
        }
        System.out.println("\tcreated file " + anotherFilePath.toString());
    }

    private static void copyMoveDeleteFiles() {
        System.out.println("\n--------------- Copy, move and delete files on the disk ---------------");

        Path NIO2 = Paths.get("/home/giuseppe/Desktop/NIO2");
        Path source = Paths.get("/home/giuseppe/Desktop/NIO2/file1.txt");
        Path target = Paths.get("/home/giuseppe/Desktop/NIO2/file2.txt");

        try {
            Files.deleteIfExists(source);
            Files.deleteIfExists(target);

            createNewDirectoriesInOneGo(NIO2, source);

            Files.copy(source, target);
            Path targetName = target.getFileName();
            Path sourceName = source.getFileName();
            System.out.println("COPY > ontent of " + sourceName + " copied on " + targetName + ": " + Files.exists(target));

            Files.deleteIfExists(target);
            System.out.println("DELETE > " + targetName + " deleted: " + !Files.exists(target));

            Files.move(source, target);
            System.out.println("MOVE > " + sourceName + " moved on " + targetName + ": " + (!Files.exists(source) && Files.exists(target)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void backwardCompatibilitybetweenIOandNIO2() {
        File file = new File("file.txt");

        // to use NIO 2 features on the older File objects
        Path convertedPath = file.toPath();

        // to invoke I/O features on the new Path objects
        File convertedFile = convertedPath.toFile();
    }
}
