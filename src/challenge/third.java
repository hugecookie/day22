package challenge;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class third {
    public static void main(String args[]) {
        int alphabet = 'a';
        ExecutorService exec = Executors.newCachedThreadPool();
        Runnable task = () -> {
            try {
                for (int i = 0; i < 5; i++) {
                    System.out.println("작업 스레드 : " + i);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                System.out.println("오류 발생!");
            }
            exec.shutdown();
        };

        exec.submit(task);

        try {
            while (!exec.isShutdown()) {
                System.out.println("메인 스레드 : " + (char) alphabet++);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("오류 발생!");
        }
    }
}