import java.io.File;
import java.io.IOException;

public class IOWorkWithFilesAndDirectories {

    public static final String IO_NIO = "io_nio";

    public static void main(String[] args) throws IOException {

        // IMPORTANT!!!
        // The code of this class supposes that all operations are always executed successfully
        // because it has the only purpose to show the features that you will find on the exam

        File directory = new File(IO_NIO + "/my_dir");
        directory.mkdir();
        System.out.println("\nCreated directory:  " + directory.getPath());

        File file = new File(directory,"my_file.txt");
        file.createNewFile();
        System.out.println("\nCreated file:  " + file.getPath());

        File renamedDirectory = new File(IO_NIO + "/renamed_dir");
        directory.renameTo(renamedDirectory);
        System.out.println("\nRenamed directory:  " + renamedDirectory.getPath());
        System.out.println("Directory " + directory.getName() + " exsists: " + directory.exists());

        File renamedFile = new File(renamedDirectory,"renamed_file.txt");
        renamedDirectory.listFiles()[0].renameTo(renamedFile);
        System.out.println("\nRenamed file:  " + renamedFile.getPath());
        System.out.println("File " + file.getName() + " exsists: " + file.exists());

        System.out.println("\nDeleted directory: " + renamedDirectory.delete() + "\t<--- you can not delete a not empty directory");
        System.out.println("Deleted file: " + renamedFile.delete());
        System.out.println("Deleted directory: " + renamedDirectory.delete());
    }
}
