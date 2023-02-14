package challenge;

class worker extends Thread {
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("작업 스레드 : " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("오류 발생!");
        }
    }
}

public class first {
    public static void main(String args[]) {
        int alphabet = 'a';
        worker worker = new worker();
        worker.start();
        try {
            while (worker.isAlive()) {
                System.out.println("메인 스레드 : " + (char) alphabet++);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("오류 발생!");
        }
    }
}