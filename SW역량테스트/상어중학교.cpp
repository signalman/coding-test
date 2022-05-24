#include <bits/stdc++.h>
#define null -7
#define X first
#define Y second
using namespace std;

//검(-1), 무지개(0), 일반(M)
//크기가 가장 큰 블록 그룹 > 무지개가 가장 많은 그룹 > 행 > 열
//그룹의 모든 블록 제거, 개수 제곱만큼 점수획득
//중력, 반시계 90도 회전, 중력
//검은색 블록은 중력x

//findLargestBlock -> 




int N, M;
int MAP[21][21];
int dx[4] = {-1, 0, 1, 0};
int dy[4] = {0, 1, 0, -1};

void checkBlockExist(){
    bool isused[21][21] = {false, };
    queue<pair<int, int>> Q;
    int blockCnt = 0;
    int maxBlockCnt = 0;
    for(int i=0; i<N; i++){
        for(int j=0; j<N; j++){
            if(isused[i][j]) continue;
            Q.push({i, j});
            isused[i][j] = true;
            while(!Q.empty()){
                auto cur = Q.front();
                Q.pop();
                for(int dir = 0 ; dir < 4; dir++){
                    int nx = cur.X + dx[dir];
                    int ny = cur.Y + dy[dir];
                    if(nx<0 || ny < 0 || nx >= N || ny>=N)continue;
                    if(isused[nx][ny]) continue;
                    if(MAP[nx][ny] == MAP[cur.X][cur.Y] || MAP[nx][ny] == 0){
                        blockCnt++;
                        isused[nx][ny] = true;
                    }
                }
            }
        }
    }
}

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    for(int i=0; i<N; i++){
        for(int j=0; j<N; j++){
            cin>>MAP[i][j];
        }
    }

}