package home.des.example.lesson5;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {

        ArrayCrop a = new ArrayCrop();
        int[] arr = {1, 2, 4, 4, 2, 3, 4, 1, 7};
        System.out.println(Arrays.toString(a.crop(4, arr)));

    }
}
