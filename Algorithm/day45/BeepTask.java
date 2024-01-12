package Algorithm.day45;

import java.awt.Toolkit;

public class BeepTask implements Runnable{

    synchronized void sum(){

    }

    @Override
    public void run() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        for(int i=0; i<5; i++){
            toolkit.beep();
            try {
                Thread.sleep(500);
            } catch (Exception e) {

            }
        }
    }
}
