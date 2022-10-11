package home.des.example.lesson7;

import java.util.Arrays;

public class SpiralArray {

    private int[][] array;

    public SpiralArray(int arrayHeight, int arrayLength) {
        assert arrayHeight > 0 : "arrayHeight <= 0";
        assert arrayLength > 0 : "arrayLength <= 0";
        this.array = new int[arrayHeight][arrayLength];
    }

    public void fillArray() {
        int length = 0;
        int height = 0;
        int count = 0;

        while (true) {
            if (length + 1 < array[height].length && array[height][length + 1] == 0) {
                for (int i = length; i < array[height].length; i++) {
                    if (array[height][i] == 0) {
                        array[height][i] = count++;
                        length++;
                        System.out.println(height + " " + length);
                        printArray(array);
                    } else {
                        break;
                    }
                }
                length--;
                height++;
            } else if (height + 1 < array.length
                    && array[height + 1][length] == 0) {
                for (int i = height; i < array.length; i++) {
                    if (array[i][length] == 0) {
                        array[i][length] = count++;
                        height++;
                        System.out.println(height + " " + length);
                        printArray(array);
                    } else {
                        break;
                    }
                }
                height--;
                length--;
            } else if (length - 1 >= 0 && array[height][length - 1] == 0) {
                for (int i = length; i >= 0; i--) {
                    if (array[height][i] == 0) {
                        array[height][i] = count++;
                        length--;
                        System.out.println(height + " " + length);
                        printArray(array);
                    } else {
                        break;
                    }
                }
                length++;
                height--;
            } else if (height - 1 >= 0 && array[height - 1][length] == 0) {
                for (int i = height; i >= 0; i--) {
                    if (array[height][length] == 0) {
                        array[height][length] = count;
                        height--;
                        System.out.println(height + " " + length);
                        printArray(array);
                    } else {
                        break;
                    }
                }
                height++;
                length++;
            }
        }
    }

    private void printArray(int[][] arr){
        for (int[] a: arr) {
            System.out.println(Arrays.toString(a));
        }
    }

    public int[][] getArray() {
        return array;
    }
}
