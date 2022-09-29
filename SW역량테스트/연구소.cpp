#include <bits/stdc++.h>
using namespace std;
#define X first
#define Y second
int dx[4] = {-1, 1, 0, 0};
int dy[4] = {0, 0, 1, -1};

int n, m;
int board[10][10];
int cpy_board[10][10];

//바이러스 퍼지는 함수
void bfs(){
    queue<pair<int, int>> q;
    for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
            if(cpy_board[i][j] == 2){
                q.push({i, j});
            }
        }
    }

    while(!q.empty()){
        auto cur = q.front();
        q.pop();
        
        for(int dir = 0; dir < 4; dir++){
            int nx = cur.X + dx[dir];
            int ny = cur.Y + dy[dir];

            if(nx < 0 || ny < 0 || nx >=n || ny >= m) continue;
            if(cpy_board[nx][ny] != 0) continue;

            cpy_board[nx][ny] = 2;
            q.push({nx, ny});
        }
    }
}

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin>>n>>m;
    for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
            cin>>board[i][j];
        }
    }


}