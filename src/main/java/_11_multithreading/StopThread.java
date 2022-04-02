package _11_multithreading;

import java.time.Duration;
import java.time.LocalTime;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class StopThread {
    private static volatile boolean stopRequestV;
    private static boolean stopRequest;
    private static final AtomicBoolean stopRequestA = new AtomicBoolean();

    public static void main(String[] args) throws InterruptedException {
        int sec = 1;
        extracted1(LocalTime.now(), sec);
        extracted2(LocalTime.now(), sec);
        extracted3(LocalTime.now(), sec);
    }

    //<editor-fold desc="extracted1 with volatile       [741]">
    private static void extracted1(LocalTime start, int sec) throws InterruptedException {
        new Thread(() -> {
            int i = 0;

            while (!stopRequestV) {
                i++;
            }
            printRes(i, start);
        }).start();

        TimeUnit.SECONDS.sleep(sec);
        stopRequestV = true;
    }
    //</editor-fold>

    //<editor-fold desc="extracted2 with synchronized   [18 very slowly]">
    private static void extracted2(LocalTime start, int sec) throws InterruptedException {
        new Thread(() -> {
            int i = 0;
            while (!isStopRequest()) {
                i++;
            }
            printRes(i, start);
        }).start();

        TimeUnit.SECONDS.sleep(sec);
        requestStop();
    }


    private static synchronized void requestStop(){
        stopRequest = true;
    }

    private static synchronized boolean isStopRequest(){
        return stopRequest;
    }
    //</editor-fold>

    //<editor-fold desc="extracted3 with AtomicBoolean  [1053]">
    private static void extracted3(LocalTime start, int sec) throws InterruptedException {
        new Thread(() -> {
            int i = 0;

            while (!stopRequestA.get()) {
                i++;
            }
            printRes(i, start);
        }).start();

        TimeUnit.SECONDS.sleep(sec);
        stopRequestA.set(true);
    }
    //</editor-fold>

    private static void printRes(int i, LocalTime start) {
        System.out.printf("%s%n%s%n", Duration.between(start, LocalTime.now()).getSeconds(), i/1000000);
    }
}

