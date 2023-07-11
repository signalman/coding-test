package Algorithm.day21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class P2 {
    static String[] wheels = new String[4];
    static int K;
    static String rotate(String str, int dir){
        String ret = "";
        if (dir == 1) {
            ret += str.substring(0, 7);
            ret = str.charAt(7) + ret;
        } else {
            ret += str.substring(1, 8);
            ret = ret + str.charAt(0);
        }
        return ret;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<4; i++){
            wheels[i] = br.readLine();
        }
        K = Integer.parseInt(br.readLine());
        while (K > 0) {
            K--;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int rot = Integer.parseInt(st.nextToken());
            num--;
            //돌려야 할 바퀴 저장.
            if (num == 0) {
                if (wheels[num].charAt(2) != wheels[num+1].charAt(6)) {
                    if (wheels[num + 1].charAt(2) != wheels[num + 2].charAt(6)) {
                        if (wheels[num + 2].charAt(2) != wheels[num + 3].charAt(6)) {
                            wheels[num + 3] = rotate(wheels[num + 3], -1 * rot);
                        }
                        wheels[num + 2] = rotate(wheels[num + 2], rot);
                    }
                    wheels[num+1] = rotate(wheels[num+1], -1 * rot);
                }
                wheels[num] = rotate(wheels[num], rot);
            } else if (num == 1) {
                if (wheels[num].charAt(6) != wheels[num - 1].charAt(2)) {
                    wheels[num - 1] = rotate(wheels[num - 1], rot * -1);
                }
                if (wheels[num].charAt(2) != wheels[num + 1].charAt(6)) {
                    if (wheels[num + 1].charAt(2) != wheels[num + 2].charAt(6)) {
                        wheels[num + 2] = rotate(wheels[num + 2], rot);
                    }
                    wheels[num + 1] = rotate(wheels[num + 1], rot * -1);
                }
                wheels[num] = rotate(wheels[num], rot);
            } else if (num == 2) {
                if (wheels[num].charAt(2) != wheels[num + 1].charAt(6)) {
                    wheels[num + 1] = rotate(wheels[num + 1], rot * -1);
                }
                if (wheels[num].charAt(6) != wheels[num - 1].charAt(2)) {
                    if (wheels[num - 1].charAt(6) != wheels[num - 2].charAt(2)) {
                        wheels[num - 2] = rotate(wheels[num - 2], rot);
                    }
                    wheels[num - 1] = rotate(wheels[num - 1], rot * -1);
                }
                wheels[num] = rotate(wheels[num], rot);
            }
            else {
                if (wheels[num].charAt(6) != wheels[num-1].charAt(2)) {
                    if (wheels[num - 1].charAt(6) != wheels[num - 2].charAt(2)) {
                        if (wheels[num - 2].charAt(6) != wheels[num - 3].charAt(2)) {
                            wheels[num - 3] = rotate(wheels[num - 3], -1 * rot);
                        }
                        wheels[num - 2] = rotate(wheels[num - 2], rot);
                    }
                    wheels[num-1] = rotate(wheels[num-1], -1 * rot);
                }
                wheels[num] = rotate(wheels[num], rot);
            }
        }

        //점수 계산
        int cnt = 0;
        for(int i=0; i<4; i++){
            char c = wheels[i].charAt(0);
            if(i == 0){
                cnt += c == '0' ? 0 : 1;
            } else if (i == 1) {
                cnt += c == '0' ? 0 : 2;
            }
            else if (i == 2) {
                cnt += c == '0' ? 0 : 4;
            }
            else if (i == 3) {
                cnt += c == '0' ? 0 : 8;
            }
        }
        System.out.println(cnt);

    }
}
