#include <bits/stdc++.h>
using namespace std;

int dx[] = {-2, -2, -1, 1, 2, 2, 1, -1};
int dy[] = {-1, 1, 2, 2, 1, -1, -2, -2};

int testCase;
int n;
int board[301][301];
int x, y;
int desX, desY;
vector<int> ans;

void bfs(int i, int j, int di, int dj){
    queue<pair<int,int>> q;
    q.push({i, j});
    board[i][j] = 0;
    while(!q.empty()){
        auto cur = q.front();
        q.pop();
        if(cur.first == di && cur.second == dj) {ans.push_back(board[cur.first][cur.second]);return;}
        for(int dir =0; dir<8; dir++){
            int nx = cur.first +dx[dir];
            int ny = cur.second + dy[dir];

            if(nx < 0 || ny <0 || nx >=n || ny >=n)continue;
            if(board[nx][ny] >= 0) continue;
            
            q.push({nx, ny});
            board[nx][ny] = board[cur.first][cur.second] + 1;
        }
    }
}


int main(){
    cin>>testCase;
    while(testCase--){
        cin>>n;
        for(int i=0; i<n; i++) fill(board[i], board[i]+n, -1);
        cin>>x>>y;
        cin>>desX>>desY;
        bfs(x, y, desX, desY);
    }
    for(auto i: ans){
        cout<<i<<'\n';
    }
}