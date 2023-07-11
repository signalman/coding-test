#include <bits/stdc++.h>
using namespace std;

int n, m;
int board[301][301];
int tmp[301][301];
int dx[] = {0, 0, 1, -1};
int dy[] = {1, -1, 0, 0};
queue<pair<int, int>> q;
bool vis[301][301];

int bfs(){
    int cnt = 0;
    for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
            vis[i][j] = 0;
        }
    }
    while(!q.empty()){
        q.pop();
    }

    for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
            if(board[i][j]==0)continue;
            if(vis[i][j]) continue;
            q.push({i, j});
            vis[i][j] = 1;
            cnt++;

            while(!q.empty()){
                auto cur = q.front();
                q.pop();

                for(int dir = 0; dir < 4; dir++){
                    int nx = cur.first + dx[dir];
                    int ny = cur.second + dy[dir];

                    if(nx<0||nx>=n||ny<0||ny>=m) continue;
                    if(board[nx][ny]==0 || vis[nx][ny]) continue;
                    vis[nx][ny] = 1;
                    q.push({nx,ny});
                }
            }
        }
    }
    return cnt;
}

void melting(){

    for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
            tmp[i][j] = 0;
        }
    }   
    for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
            if(board[i][j] == 0)continue;
            int zeroCnt = 0;
            for(int dir =0; dir <4; dir++){
                int nx = i + dx[dir];
                int ny = j + dy[dir];
                if(nx < 0 || ny < 0 || nx >=n || ny >= m) continue;
                if(board[nx][ny]==0) zeroCnt++;
            }
            if(board[i][j] <= zeroCnt) tmp[i][j] = 0;
            else tmp[i][j] = board[i][j]-zeroCnt;
        }
    }

    for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
            board[i][j] = tmp[i][j];
        }
    }

}

int main(){
    cin>>n>>m;
    for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
            cin>>board[i][j];
        }
    }

    int year = 0; //몇년차? 인지 당해 -> 0
    while(1){
        if(bfs() == 0) break;
        if(bfs() >= 2) {cout<<year; return 0;}
        melting();
        year++;
    }
    cout<<0;
}