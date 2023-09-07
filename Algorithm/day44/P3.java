package Algorithm.day44;

public class P3 {

    public static void main(String[] args) {
        Runnable p2 = new P2();
        Thread thread = new Thread(p2);
        thread.start();

        for(int i=0; i<5; i++){
            System.out.println("띵");
            try {
                Thread.sleep(500);
            } catch (Exception e) {

            }
        }
    }
}
