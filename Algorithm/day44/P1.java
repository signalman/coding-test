package Algorithm.day44;

import java.awt.Toolkit;

public class P1 {

    public static void main(String[] args) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        for(int i=0; i<5; i++){
            toolkit.beep();
            try {
                Thread.sleep(5000);
            } catch (Exception e) {

            }
        }

        for(int i=0; i<5; i++){
            System.out.println("띵");
            try {
                Thread.sleep(5000);
            } catch (Exception e) {

            }
        }

    }
}
