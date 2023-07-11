#include <bits/stdc++.h>
using namespace std;

int dx[4] = {-1, 0, 0, 1};
int dy[4] = {0, -1, 1, 0};

struct Shark{
    int x, y;
    int size;
    int eatCnt;
};
int N;
int board[21][21];

//상어의 위치에 대해 조건에 만족하는 가장가까운 물고기까지의 거리 계산
int hunt(Shark& shark){ 
    int dist[21][21]={0,};
    fill(&dist[0][0], &dist[20][21], -1);
    dist[shark.x][shark.y] = 0;
    queue<pair<int, int>> q;
    vector<tuple<int,int,int>> candi; //거리, x, y
    q.push({shark.x, shark.y});
    while(!q.empty()){
        auto cur = q.front();
        q.pop();

        for(int dir =0 ; dir < 4; dir++){
            int nx = cur.first + dx[dir];
            int ny = cur.second + dy[dir];
            if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if(board[nx][ny] > shark.size || dist[nx][ny] > -1) continue;
            q.push({nx, ny});
            dist[nx][ny] = dist[cur.first][cur.second] + 1;

            if(board[nx][ny] != 0 && board[nx][ny] < shark.size) {
                candi.push_back({dist[nx][ny], nx, ny});
            }
        }
    }
    if(!candi.empty()){
        sort(candi.begin(), candi.end());
        shark.x = get<1>(candi[0]);
        shark.y = get<2>(candi[0]);
        shark.eatCnt += 1;
        if(shark.eatCnt >= shark.size){
            shark.eatCnt = 0;
            shark.size += 1;
        }
        board[get<1>(candi[0])][get<2>(candi[0])] = 0;
        return get<0>(candi[0]);
    }

    return -1;
}

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin>>N;
    Shark shark;
    for(int i=0; i<N; i++){
        for(int j=0; j<N; j++){
            cin>>board[i][j];
            if(board[i][j] == 9){
                shark.x = i;
                shark.y = j;
                shark.size = 2;
                shark.eatCnt =0;
                board[i][j] = 0;
            }
        }
    }

    int times = 0;
    while(true){
        int t = hunt(shark);
        if(t == -1) break;
        times += t;
    }

    cout<<times;
}