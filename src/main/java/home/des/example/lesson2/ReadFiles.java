package home.des.example.lesson2;

import org.postgresql.shaded.com.ongres.scram.common.bouncycastle.pbkdf2.Strings;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class ReadFiles {
}

class ReadOneFileByString {
    public static void main(String[] args) throws IOException {
        Path pathFile = Paths.get("data\\fiftyBytes.txt");
        File file = new File(String.valueOf(pathFile));

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String tmp = reader.readLine();

        while (tmp != null) {
            System.out.println(tmp);
            tmp = reader.readLine();
        }
    }
}

class ReadOneFileByBytes {
    public static void main(String[] args) throws IOException {
        Path pathFile = Paths.get("data/fiftyBytes.txt");
        File file = new File(String.valueOf(pathFile));

        FileInputStream fis = new FileInputStream(file);

        byte[] arr = Files.readAllBytes(pathFile);

        System.out.println(Strings.asCharArray(arr));
    }
}

class UniteFiveFiles {
    public static void main(String[] args) throws IOException {
        String allPath = "data/";
        ArrayList<InputStream> inputStreams = new ArrayList<>();
        inputStreams.add(new FileInputStream(allPath + "fiftyBytes.txt"));
        for (int i = 1; i < 5; i++) {
            inputStreams.add(new FileInputStream(allPath + "fiftyBytes" + i + ".txt"));
        }
        byte[] arr = new byte[4096];
        int count;
        for (InputStream is : inputStreams) {
            while ((count = is.read(arr)) != -1) {
                System.out.print(new String(arr, 0, count));
            }
            System.out.println();
        }
    }
}

class ReadFileByPages {
    public static void main(String[] args) throws IOException {
        String allPath = "data/";
        InputStream is = new FileInputStream(allPath + "fiftyBytes.txt");
        byte[] arr = new byte[1800];
        int count;
        int page = 1;
        while ((count = is.read(arr)) != -1) {
            System.out.println("Page: " + page + "\n");
            System.out.print(new String(arr, 0, count));
            System.out.print("\n\n");
            page++;
        }
        System.out.println();
    }
}


