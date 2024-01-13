package Algorithm.day45;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class WebSite implements Runnable {

    private final String webSiteName;
    private final WebBrowser webBrowser;

    public WebSite(final String webSiteName, final WebBrowser webBrowser) {
        this.webSiteName = webSiteName;
        this.webBrowser = webBrowser;
    }

    @Override
    public void run() {
        // 메서드 블럭 동기화
//        synchronized (this) {
            while (webBrowser.hasSpace()) {
                try {
                    Thread.sleep(new Random().nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                webBrowser.createNewTab(webSiteName);
            }
//        }
    }
}
