package home.des.example.lesson5;

public class CheckArray {

    public boolean check(int[] arr){
        boolean one = false;
        boolean four = false;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1 && !one){
                one = true;
            }
            if (arr[i] == 4 && !four){
                four = true;
            }
            if (one && four){
                return true;
            }
        }
        return false;
    }

}
