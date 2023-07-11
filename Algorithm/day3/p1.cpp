#include <bits/stdc++.h>
using namespace std;

int n, m, h;
int board[101][101][101];
bool vis[101][101][101];
queue<tuple<int, int, int>> q;

int dx[] ={1, -1, 0, 0, 0, 0};
int dy[] ={0, 0, -1, 1, 0, 0};
int dz[] ={0, 0, 0, 0, 1, -1};

int ans;

void bfs(){
    while(!q.empty()){
        auto cur = q.front();
        q.pop();

        for(int dir = 0; dir < 6; dir++){
            int nx = get<1>(cur) + dy[dir]; //행
            int ny = get<2>(cur) + dz[dir]; //열
            int nz = get<0>(cur) + dx[dir]; //높이
            if(nx <0 || ny <0 || nz < 0 || nx >= m || ny >= n || nz >= h) continue;
            if(board[nz][nx][ny] == -1 || vis[nz][nx][ny]) continue;
            q.push({nz, nx, ny});
            board[nz][nx][ny] = board[get<0>(cur)][get<1>(cur)][get<2>(cur)] + 1;
            vis[nz][nx][ny] = 1;
        }
    }
}

int check(){
    int cnt =0;
    for(int k=0; k<h; k++){
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[k][i][j] == 0) {return -1;}
                cnt = max(cnt, board[k][i][j]);
            } 
        }
    }
    return cnt-1;
}

int main(){
    cin>>n>>m>>h;
    for(int k=0; k<h; k++){ //높이
        for(int i=0; i<m; i++){ //행
            for(int j=0; j<n; j++){ //열
                cin>>board[k][i][j];
                if(board[k][i][j] == 1){
                    q.push({k, i, j});
                    vis[k][i][j] = 1;
                } 
            }
        }
    }

    bfs();
    
    if(check() == -1) cout<< -1;
    else cout<< check();
}

