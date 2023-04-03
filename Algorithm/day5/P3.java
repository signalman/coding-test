import java.util.ArrayList;
import java.util.LinkedList;
public class P3 {
    // 230330_SWEA_13475
    final int MAP_SIZE = 10000;

    /** 장소 정보 저장 */
    static class Place{
        int r, c; // 위치. 삭제되면 (-1, -1)
        boolean canVisit; // 감염자가 방문한 후, 소독하기 전

        Place(int r, int c){
            this.r = r;
            this.c = c;
            canVisit = true;
        }
    }
    Place[] places;

    /** 방문가능한 장소 저장 */
    LinkedList<Integer>[] hor; // 가로
    LinkedList<Integer>[] ver; // 세로
    LinkedList<Integer>[] dia; // 오른쪽아래  대각선 (r + c)
    LinkedList<Integer>[] rdia; // 오른쪽위 대각선 (r - c) + MAP_SIZE

    /** 감염자가 방문한 장소 */
    ArrayList<Integer>[] infectedList;

    void init() {
        places = new Place[50001];

        hor = new LinkedList[MAP_SIZE];
        for(int i = 0; i < MAP_SIZE; i++) {
            hor[i] = new LinkedList<>();
        }
        ver = new LinkedList[MAP_SIZE];
        for(int i = 0; i < MAP_SIZE; i++) {
            ver[i] = new LinkedList<>();
        }
        dia = new LinkedList[MAP_SIZE<<1];
        for(int i = 0; i < (MAP_SIZE<<1); i++) {
            dia[i] = new LinkedList<>();
        }
        rdia = new LinkedList[MAP_SIZE<<1];
        for(int i = 0; i < (MAP_SIZE<<1); i++) {
            rdia[i] = new LinkedList<>();
        }

        infectedList = new ArrayList[1001];
    }

    void addPlace(int pID, int r, int c) {
        places[pID] = new Place(r, c);

        hor[r].add(pID);
        ver[c].add(pID);
        dia[r+c].add(pID);
        rdia[r-c+MAP_SIZE].add(pID);
    }

    void removePlace(int pID) {
        int r = places[pID].r;
        int c = places[pID].c;

        hor[r].remove((Integer)pID);
        ver[c].remove((Integer)pID);
        dia[r+c].remove((Integer)pID);
        rdia[r-c+MAP_SIZE].remove((Integer)pID);

        places[pID].r = -1;
        places[pID].c = -1;
    }

    void contactTracing(int uID, int visitNum, int moveInfo[], int visitList[]) {
        infectedList[uID] = new ArrayList<>();

        // 시작점
        int cur = moveInfo[0], next = 0;
        infectedList[uID].add(cur);

        // 장소 확인
        for(int i = 1; i < visitNum; i++) {
            // 갈 수 있는 장소 pid
            next = moveNext(cur, moveInfo[i]);

            infectedList[uID].add(next);
            cur = next;
        }

        for(int i = 0; i < infectedList[uID].size(); i++) {
            visitList[i] = infectedList[uID].get(i);
            places[infectedList[uID].get(i)].canVisit = false;
        }
    }

    int moveNext(int cur, int dir) {
        // 현재 위치
        int x = places[cur].r;
        int y = places[cur].c;

        // 이동할 위치 저장
        int next = 0;

        if(dir == 0) {
            for(int i : ver[y]) {
                if(places[i].r < x && places[i].canVisit) {
                    if(next == 0) {
                        next = i;
                    } else if(places[i].r > places[next].r) {
                        next = i;
                    }
                }
            }
        } else if(dir == 4) {
            for(int i : ver[y]) {
                if(places[i].r > x && places[i].canVisit) {
                    if(next == 0) {
                        next = i;
                    } else if(places[i].r < places[next].r) {
                        next = i;
                    }
                }
            }
        } else if(dir == 2) {
            for(int i : hor[x]) {
                if(places[i].c > y && places[i].canVisit) {
                    if(next == 0) {
                        next = i;
                    } else if(places[i].c < places[next].c) {
                        next = i;
                    }
                }
            }
        } else if(dir == 6) {
            for(int i : hor[x]) {
                if(places[i].c < y && places[i].canVisit) {
                    if(next == 0) {
                        next = i;
                    } else if(places[i].c > places[next].c) {
                        next = i;
                    }
                }
            }
        } else if(dir == 1) {
            for(int i : dia[x+y]) {
                if(places[i].r < x && places[i].canVisit) {
                    if(next == 0) {
                        next = i;
                    } else if(places[i].r > places[next].r) {
                        next = i;
                    }
                }
            }
        } else if(dir == 5) {
            for(int i : dia[x+y]) {
                if(places[i].r > x && places[i].canVisit) {
                    if(next == 0) {
                        next = i;
                    } else if(places[i].r < places[next].r) {
                        next = i;
                    }
                }
            }
        } else if(dir == 7) {
            for(int i : rdia[x-y+MAP_SIZE]) {
                if(places[i].r < x && places[i].canVisit) {
                    if(next == 0) {
                        next = i;
                    } else if(places[i].r > places[next].r) {
                        next = i;
                    }
                }
            }
        } else if(dir == 3) {
            for(int i : rdia[x-y+MAP_SIZE]) {
                if(places[i].r > x && places[i].canVisit) {
                    if(next == 0) {
                        next = i;
                    } else if(places[i].r < places[next].r) {
                        next = i;
                    }
                }
            }
        }

        return next;
    }

    void disinfectPlaces(int uID) {
        for(int pID : infectedList[uID]) {
            places[pID].canVisit = true;
        }
        infectedList[uID].clear();
    }
}
