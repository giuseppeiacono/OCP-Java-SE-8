package nio;

import common.TempDirUtility;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NIO2WorkWithFilesAndDirectories {

    public static void main(String[] args) throws IOException {

        // IMPORTANT!!!
        // The code check if directories and files already exist before to create them in order to avoid exceptions

        createPaths();
        createFilesAndDirectoriesOnTheDisk();
        copyMoveDeleteFiles();
        backwardCompatibilitybetweenIOandNIO2();
    }

    private static void createPaths() {
        System.out.println("\n--------------- Created just Path objects in several ways ---------------");

        Path filePath = Paths.get("/tmp/myDoc.txt");
        System.out.println("filePath = " + filePath);

        Path filePathWithoutSlashs = Paths.get("/", "tmp", "Java", "another_doc.java");
        System.out.println("filePathWithoutSlashs = " + filePathWithoutSlashs);

        Path filePathFromDefaultFileSystem = FileSystems.getDefault().getPath("/", "tmp", "default", "fileSystem", "logo.png");
        System.out.println("filePathFromDefaultFileSystem = " + filePathFromDefaultFileSystem);

        Path dirPath = Paths.get("/tmp/my_dir");
        System.out.println("\ndirPath = " + dirPath);

        Path dirPathWithoutSlashs = Paths.get("/tmp/my_dir");
        System.out.println("dirPathWithoutSlashs = " + dirPathWithoutSlashs);

        Path dirPathFromDefaultFileSystem = FileSystems.getDefault().getPath("/tmp/default/file/system");
        System.out.println("dirPathFromDefaultFileSystem = " + dirPathFromDefaultFileSystem);

        // Just for Windows to browse to a folder in Internet Explorer
        // Path windowsFile = Paths.get(URI.create("file///C:/temp"));
    }

    private static void createFilesAndDirectoriesOnTheDisk() throws IOException {
        System.out.println("\n--------------- Created files and directories on the disk ---------------");

        Path emptyTmpDirPath = TempDirUtility.createEmptyTmpDir();
        Path nio2OneByOneDir = Paths.get("NIO2_one_by_one");
        Path nio2OneByOnePath = emptyTmpDirPath.resolve(nio2OneByOneDir);
        Path filesDir = Paths.get("NIO2_one_by_one/files");
        Path filesDirPath = emptyTmpDirPath.resolve(filesDir);
        Path fileTxt = Paths.get("NIO2_one_by_one/files/myDoc.txt");
        Path fileTxtPath = emptyTmpDirPath.resolve(fileTxt);

        Path nio2InOneGoDir = Paths.get("NIO2_in_one_go/other_files/");
        Path nio2InOneGoDirPath = emptyTmpDirPath.resolve(nio2InOneGoDir);
        Path docTxt = Paths.get("NIO2_in_one_go/other_files/another_doc.txt");
        Path docTxtPath = emptyTmpDirPath.resolve(docTxt);

        try {
            createNewDirectoriesOneByOne(fileTxtPath, nio2OneByOnePath, filesDirPath);
            createNewDirectoriesInOneGo(nio2InOneGoDirPath, docTxtPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createNewDirectoriesOneByOne(Path filePath, Path... dirPaths) throws IOException {
        System.out.println("\nCreated new  directories ONE BY ONE");
        for (Path newDirPath: dirPaths) {
            if (Files.notExists(newDirPath)) {
                Files.createDirectory(newDirPath);
                System.out.println("\tnew dir: " + newDirPath);
            }
        }
        if (Files.notExists(filePath)) {
            Files.createFile(filePath);
        }
        System.out.println("\tcreated file " + filePath);
    }

    private static void createNewDirectoriesInOneGo(Path dirPath, Path filePath) throws IOException {
        System.out.println("\nCreated new directories IN ONE GO");
        Files.createDirectories(dirPath);
        System.out.println("\tnew directories: " + dirPath);
        if (Files.notExists(filePath)) {
            Files.createFile(filePath);
        }
        System.out.println("\tnew file: " + filePath.toString());
    }

    private static void copyMoveDeleteFiles() throws IOException {
        System.out.println("\n--------------- Copy, move and delete files on the disk ---------------");

        Path emptyTmpDirPath = TempDirUtility.createEmptyTmpDir();
        Path nio2Dir = Paths.get("NIO2");
        Path nio2DirPath = emptyTmpDirPath.resolve(nio2Dir);
        Path file1 = Paths.get("NIO2/file1.txt");
        Path file1Path = emptyTmpDirPath.resolve(file1);
        Path file2 = Paths.get("NIO2/file2.txt");
        Path file2Path = emptyTmpDirPath.resolve(file2);

        try {
            Files.deleteIfExists(file1Path);
            Files.deleteIfExists(file2Path);

            createNewDirectoriesInOneGo(nio2DirPath, file1Path);

            Files.copy(file1Path, file2Path);
            Path targetName = file2Path.getFileName();
            Path sourceName = file1Path.getFileName();
            System.out.println("\nCOPY > " + file1Path.getFileName() + " was copied on " + file2Path.getFileName() + ": " + Files.exists(file2Path));

            Files.deleteIfExists(file2Path);
            System.out.println("DELETE > " + targetName + " deleted: " + !Files.exists(file2Path));

            Files.move(file1Path, file2Path);
            System.out.println("MOVE > " + sourceName + " moved on " + targetName + ": " + (!Files.exists(file1Path) && Files.exists(file2Path)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void backwardCompatibilitybetweenIOandNIO2() {
        System.out.println("\n--------------- Backward compatibility between I/O and NIO.2 ---------------");
        File file = new File("myDoc.txt");
        System.out.println("File = " + file);

        // to use NIO 2 features on the older File objects
        Path convertedPath = file.toPath();
        System.out.println("Converted File to Path = " + convertedPath);

        // to invoke I/O features on the new Path objects
        File convertedFile = convertedPath.toFile();
        System.out.println("Converted Path to File = " + convertedFile);
    }
}
