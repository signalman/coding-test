package Algorithm.day45;

public class Main1 {

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                //실행할 작업
            }
        };

        Thread thread1 = new Thread(runnable);
        thread1.start();

        //Thread 클래스를 상속하는 익명 객체 구현
        Thread thread = new Thread() {
            @Override
            public void run() {
                super.run();
            }
        };
        thread.start();

    }
}
