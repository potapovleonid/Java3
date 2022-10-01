package home.des.example.lesson4;

import java.util.concurrent.CountDownLatch;

public class Car implements Runnable {
    private static int CARS_COUNT;

    static {
        CARS_COUNT = 0;
    }

    private CountDownLatch readyCountDown;
    private CountDownLatch finishCountDown;
    private Race race;
    private int speed;
    private String name;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed, CountDownLatch readyCountDown, CountDownLatch finishCountDown) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        this.readyCountDown = readyCountDown;
        this.finishCountDown = finishCountDown;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            readyCountDown.countDown();
            readyCountDown.await();
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        finishCountDown.countDown();
    }
}
