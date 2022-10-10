#include <bits/stdc++.h>
using namespace std;

#define MAX 1001
#define INF 987654321

int dx[] = {0, 0, -1, 1};
int dy[] = {1, -1, 0, 0};

int N, M, K;
int board[MAX][MAX];
bool vis[MAX][MAX][11];

void bfs(int x, int y, int d, int k, int day){
    queue<pair<tuple<int, int, int>, pair<int, int>>> q;
    q.push(make_pair(make_tuple(x, y, d), make_pair(k, day)));
    vis[x][y][k] = true;

    while(!q.empty()){
        auto cur = q.front(); q.pop();
        int curx = get<0>(cur.first);
        int cury = get<1>(cur.first);
        int d = get<2>(cur.first);
        int k = cur.second.first;
        int day = cur.second.second;

        if(curx == N-1 && cury == M-1){cout<<d<<'\n'; return;}
        for(int dir = 0; dir < 4; dir++){
            int nx = curx + dx[dir];
            int ny = cury + dy[dir];

            if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if(board[nx][ny] == 0){
                if(vis[nx][ny][k]) continue;
                vis[nx][ny][k] = true;
                if(day == 0) q.push(make_pair(make_tuple(nx, ny, d+1), make_pair(k, 1)));
                else q.push(make_pair(make_tuple(nx, ny, d+1), make_pair(k, 0)));
            }
            else if(board[nx][ny] == 1){
                if(k >= K) continue;
                if(vis[nx][ny][k+1])continue;
                if(day == 0){
                    vis[nx][ny][k+1] = true;
                    q.push(make_pair(make_tuple(nx, ny, d+1), make_pair(k+1, 1)));
                }
                else {
                    q.push(make_pair(make_tuple(curx, cury, d+1), make_pair(k, 0)));
                }
            }
        }
    }
    cout<< -1;
}


int main(){
    cin>>N>>M>>K;
    for(int i=0; i<N; i++){
        string str;
        cin>>str;
        for(int j=0; j<M; j++){
            board[i][j] = str[j] - '0';
        }
    }

    bfs(0, 0, 1, 0, 0); //x, y,  거리, 부순횟수, day
}

