package home.des.example.lesson2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadFiles {

}

class Read1 {
    public static void main(String[] args) {
        Path pathFile = Paths.get("newFile.txt");
        System.out.println("Print info of file");
        System.out.println("\t file name: " + pathFile.getFileName());
        System.out.println("\t root of the path: " + pathFile.getRoot());
        System.out.println("\t parent of the target: " + pathFile.getParent());

        for (Path element : pathFile) {
            System.out.println("\t path element: " + element);
        }
    }
}

class Read2 {
    public static void main(String[] args) throws IOException {
        Path pathFile = Paths.get("newFile.txt");
        Path testPathNormalized = Paths
                .get(pathFile.normalize().toString());
        System.out.println("It's normalized absolute path is: "
                + testPathNormalized.toAbsolutePath());
        System.out.println("It's normalized real path is: "
                + pathFile.toRealPath(LinkOption.NOFOLLOW_LINKS));
    }
}

class Read3 {
    public static void main(String[] args) throws IOException {
        Path pathFile = Paths.get("newFile.txt");
        Files.createFile(pathFile);
        Path oldFile = Paths.get("oldFile.txt");
        Files.createFile(oldFile);
        if (Files.exists(oldFile)) {
            System.out.println("The file/directory " + oldFile.getFileName() + " exists");
            if (Files.isDirectory(oldFile)) {
                System.out.println("The " + oldFile.getFileName() + " is directory");
            } else {
                System.out.println("The " + oldFile.getFileName() + " is file");
            }
        }

        Files.delete(pathFile);
        Files.delete(oldFile);
    }
}

class Read4 {
    public static void main(String[] args) throws IOException {
        Path pathFile = Paths.get("newFile.txt");
        Files.createFile(pathFile);
        Path oldFile = Paths.get("oldFile.txt");
        try {
            Files.copy(pathFile, oldFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Read5{
    public static void main(String[] args) throws IOException {
        Path pathFile = Paths.get("newFile.txt");
        Files.createFile(pathFile);
        Path oldFile = Paths.get("oldFile.txt");
        if (!Files.exists(oldFile)){
            File file = new File(String.valueOf(pathFile));
            file.renameTo(new File(String.valueOf(oldFile)));
        } else {
            System.out.println("File " + oldFile.toAbsolutePath() + " exists");
        }
    }
}