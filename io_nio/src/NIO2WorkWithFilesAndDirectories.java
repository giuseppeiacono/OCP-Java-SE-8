import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NIO2WorkWithFilesAndDirectories {

    public static void main(String[] args) {

        // IMPORTANT!!!
        // The code of this class supposes that all operations are always executed successfully
        // because it has the only purpose to show the features that you will find on the exam

        createPaths();
        createFilesAndDirectoriesOnTheDisk();
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
    }

    private static void createFilesAndDirectoriesOnTheDisk() {
        System.out.println("\n--------------- Created files and directories on the disk ---------------");

        Path newDirPath1 = Paths.get("/home/giuseppe/Desktop/NIO2_one_by_one");
        Path newDirPath2 = Paths.get("/home/giuseppe/Desktop/NIO2_one_by_one/files");
        Path filePath = Paths.get("/home/giuseppe/Desktop/NIO2_one_by_one/files/file.txt");

        Path newDirectoriesPath = Paths.get("/home/giuseppe/Desktop/NIO2_in_one_go/other_files/");
        Path anotherFilePath = Paths.get("/home/giuseppe/Desktop/NIO2_in_one_go/other_files/another_file.txt");

        try {
            createNewDirectoriesOneByOne(newDirPath1, newDirPath2, filePath);
            createNewDirectoriesInOneGo(newDirectoriesPath, anotherFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createNewDirectoriesOneByOne(Path newDirPath1, Path newDirPath2, Path filePath) throws IOException {
        System.out.println("1. Created new  directories ONE BY ONE");
        if (Files.notExists(newDirPath1)) {
            Files.createDirectory(newDirPath1);
            System.out.println("\tCreated directory " + newDirPath1.getName(newDirPath1.getNameCount()-1));
        }
        if (Files.notExists(newDirPath2)) {
            Files.createDirectory(newDirPath2);
            System.out.println("\tCreated directory " + newDirPath2.getName(newDirPath2.getNameCount() - 1));
        }
        if (Files.notExists(filePath)) {
            Files.createFile(filePath);
        }
        System.out.println("\tCreated file " + filePath.toString());
    }

    private static void createNewDirectoriesInOneGo(Path newDirectoriesPath, Path anotherFilePath) throws IOException {
        System.out.println("\n2. Created new  directories IN ONE GO");
        Files.createDirectories(newDirectoriesPath);
        if (Files.notExists(anotherFilePath)) {
            Files.createFile(anotherFilePath);
        }
        System.out.println("\tCreated file " + anotherFilePath.toString());
    }

    private static void backwardCompatibilitybetweenIOandNIO2() {
        File file = new File("file.txt");

        // to use NIO 2 features on the older File objects
        Path convertedPath = file.toPath();

        // to invoke I/O features on the new Path objects
        File convertedFile = convertedPath.toFile();
    }
}
