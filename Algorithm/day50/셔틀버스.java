package Algorithm.day50;

import java.util.Arrays;

//가장 마지막 버스가 타겟
//가장 마지막 버스가 도착하는 시간에 탈 수 없다면
//그 버스에 가장 마지막으로 타는 사람보다 1분 빠르게
public class 셔틀버스 {
        public String solution(int n, int t, int m, String[] timetable) {
            Arrays.sort(timetable);

            //가장 마지막 버스가 도착하는 시간
            int lastBusMinutes = 60 * 9 + t * (n - 1); //분
            return findAnswer(lastBusMinutes, timetable, m, t, n);
        }

        String minutesToString(int lastBusMinutes){
            int minutes = lastBusMinutes % 60;
            int hours = (lastBusMinutes - minutes) / 60;
            return String.format("%02d:%02d", hours, minutes);
        }

        String findAnswer(int lastBusMinutes, String[] timetable, int m, int t, int n){

            int curBusMinutes = 9 * 60;
            int curMember = 0;
            int i = 0;

            while(i < timetable.length && curBusMinutes <= lastBusMinutes){

                //시간 맞는사람 다 넣기
                while(i < timetable.length && totalMin(timetable[i]) <= curBusMinutes && curMember < m){
                    curMember++;
                    //마지막승객까지 타버림
                    if(curBusMinutes == lastBusMinutes && curMember == m){
                        return minutesToString(totalMin(timetable[i]) - 1);
                    }
                    i++;
                }
                curBusMinutes += t;
                curMember = 0;
            }
            return minutesToString(lastBusMinutes);
        }

        int totalMin(String time){
            String[] hm = time.split(":");
            return Integer.parseInt(hm[0]) * 60 + Integer.parseInt(hm[1]);
        }
}
