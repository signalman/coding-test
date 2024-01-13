package Algorithm.day45;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WebBrowser {

    private static final String SPACE = " ";

    private final List<String> webSiteNames = new ArrayList<>();
    private final int maxWebCount;

    public WebBrowser(final int maxWebCount) {
        this.maxWebCount = maxWebCount;
    }

    // 메서드 동기화
    public synchronized void createNewTab(final String webSiteName) {
        try {
            if (full()) {
                return;
            }
            System.out.println(webSiteName + " 사이트가 켜지는 중입니다...");
            Thread.sleep(new Random().nextInt(1000));
            webSiteNames.add(webSiteName);
            showRunningBrowser();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void showRunningBrowser() {
        if (webSiteNames.size() > maxWebCount) {
            throw new UnsupportedOperationException("현재 브라우저 탭이 6개 이상 활성화 되어 강제 종료합니다...");
        }

        System.out.println(
            "┌───────────────────────────────────────────────────────────────────────────────┐");
        System.out.println(
            "│ ◆ Wilder Web Browser                                                    - □ x │");
        System.out.println(
            "└───────────────────────────────────────────────────────────────────────────────┘");

        StringBuilder browserNameLine = new StringBuilder();
        StringBuilder browserUnderLine = new StringBuilder();

        if (webSiteNames.size() > 0) {
            browserNameLine.append("│");
            browserUnderLine.append("└");
        }

        for (int i = 0; i < webSiteNames.size(); i++) {
            browserNameLine.append(generateWebSiteName(webSiteNames.get(i)))
                           .append(i + 1)
                           .append("   │");
            browserUnderLine.append("───────────────┘");
        }

        System.out.println(browserNameLine);
        System.out.println(browserUnderLine);
    }

    private String generateWebSiteName(final String name) {
        StringBuilder builder = new StringBuilder();

        if (name.length() > 11) {
            return name.substring(0, 11);
        }

        int space = 11 - name.length();
        int interval = space / 2;

        builder.append("   ")
               .append(name)
               .append("   ");

        return builder.toString();
    }

    public boolean hasSpace() {
        return webSiteNames.size() < maxWebCount;
    }

    private boolean full() {
        return !hasSpace();
    }
}
