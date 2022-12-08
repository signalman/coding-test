#include <bits/stdc++.h>
using namespace std;

int R, C, M;
int dx[] = {0, -1, 1, 0, 0};
int dy[] = {0, 0, 0, 1, -1};

/**
 * 위치 속력, 방향, 크기
*/
struct Shark{
    int x, y;
    int s, d, z;
    Shark(int x, int y, int s, int d, int z){
        x = x;
        y = y;
        s = s;
        d = d;
        z = z;
    }
};
int board[102][102];
vector<Shark> shark_list;
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin>>R>>C>>M;
    while(M--){
        int x, y, s, d, z;
        cin>>x>>y>>s>>d>>z;
        shark_list.push_back(Shark(x, y, s ,d ,z));
    }
    sort(shark_list.begin(), shark_list.end());
    int fisher = 0;
    int sum = 0;
    while(fisher < C){
        /**
         * 상어잡기
         * 상어 이동
         * 큰상어가 잡아먹기
         * 낚시꾼 이동
         * 
        */
        for(auto iter = shark_list.begin(); iter != shark_list.end(); iter++){
            if(iter -> y == fisher){
                sum += iter->z;
                shark_list.erase(iter);
                break;
            }
        }
        for(auto shark : shark_list){

            int s;
            if(shark.d == 1 || shark.d == 2){
                s=shark.s % (2 * (R-1));
            }
            else if(shark.d == 3 || shark.d == 4){
                s=shark.s % (2 * (C-1));
            }
            int nx, ny;
            while(s--){
                nx = shark.x + dx[shark.d];
                ny = shark.y + dy[shark.d];

                if(nx < 0 || nx >= R){
                    shark.d = 7 - shark.d;
                }
                if(ny < 0 || ny >= C){
                    shark.d = 3 - shark.d;
                }
                nx = shark.x + dx[shark.d];
                ny = shark.y + dy[shark.d];
            }
            shark.x = nx;
            shark.y = ny;
        }



        
    }
    
}