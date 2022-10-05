package home.des.example.lesson5;

import java.util.Arrays;

public class ArrayCrop {

    public int[] crop(int cropElement, int[] arr){
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 4){
                return Arrays.copyOfRange(arr, i + 1, arr.length);
            }
        }
        throw new RuntimeException();
    }

}
