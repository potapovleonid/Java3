package home.des.example.lesson3;

import java.util.Objects;

public class ThreeThreadABC {
    private final Object mon = new Object();
    private volatile String symbol = "A";

    public static void main(String[] args) {
        ThreeThreadABC threadABC = new ThreeThreadABC();

        new Thread(() -> threadABC.printSymbol("A", "B", 5)).start();
        new Thread(() -> threadABC.printSymbol("B", "C", 5)).start();
        new Thread(() -> threadABC.printSymbol("C", "A", 5)).start();

    }

    public void printSymbol(String printSymbol, String nextSymbol, int count){
        synchronized (mon){
            for (int i = 0; i < count; i++) {
                while (!symbol.equals(printSymbol)){
                    try {
                        mon.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(printSymbol);
                symbol = nextSymbol;
                mon.notifyAll();
            }
        }
    }

}
