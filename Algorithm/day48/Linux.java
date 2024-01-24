package Algorithm.day48;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Linux {
    private Set<String> fileSystem = new HashSet<>();

    public String[] solution(String[] directories, String[] command) {
        // Initialize the file system with given directories
        for (String directory : directories) {
            makeDir(directory);
        }

        // Process each command
        for (String cmd : command) {
            String[] comm = cmd.split(" ");
            switch (comm[0]) {
                case "mkdir":
                    makeDir(comm[1]);
                    break;
                case "cp":
                    copy(comm[1], comm[2]);
                    break;
                case "rm":
                    remove(comm[1]);
                    break;
            }
        }
        // Convert the file system set to an array
        return fileSystem.stream()
                         .sorted()
                         .toArray(String[]::new);
    }

    void makeDir(String directory) {
        fileSystem.add(directory);
    }

    void remove(String directory) {
        fileSystem.remove(directory);
        fileSystem.removeIf(dir -> dir.startsWith(directory + "/"));
    }

    void copy(String source, String dest) {
        // 임시 세트를 사용하여 현재 파일 시스템 상태를 복사합니다.
        Set<String> tempSet = new HashSet<>(fileSystem);

        for (String dir : tempSet) {
            if (dir.startsWith(source)) {
                // 원본 디렉토리 경로를 대상 디렉토리 경로로 변환합니다.
                String newDir = dir.replaceFirst(source, dest + source);
                fileSystem.add(newDir);
            }
        }
    }
    public static void main(String[] args) {
        Linux linux = new Linux();
        String[] answer = linux.solution(new String[]{
            "/",
            "/hello",
            "/hello/tmp",
            "/root",
            "/root/abcd",
            "/root/abcd/etc",
            "/root/abcd/hello",
        }, new String[]{
            "mkdir /root/tmp",
            "cp /hello /root/tmp",
            "rm /hello"
        });
        Arrays.stream(answer).forEach(System.out::println);
    }
}
