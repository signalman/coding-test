#include <bits/stdc++.h>
using namespace std;

int testCase;
int n, m, cabbage;
bool board[51][51];
vector<int> answer;

int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, -1, 1};

queue<pair<int, int>> q;

int bfs(){
    int ret = 0;
    bool vis[51][51] = {0,};

    for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
            if(!board[i][j] || vis[i][j]) continue;
            q.push({i, j});
            ret++;
            vis[i][j] = 1;
            while(!q.empty()){
                auto cur = q.front();
                q.pop();
                for(int dir = 0; dir < 4; dir++){
                    int nx = cur.first + dx[dir];
                    int ny = cur.second + dy[dir];
                    if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                    if(board[nx][ny] == 0 || vis[nx][ny]) continue;
                    q.push({nx, ny});
                    vis[nx][ny] = 1;
                }
            }
        }
    }

    return ret;
}

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin>>testCase;
    while(testCase--){
        cin>>n>>m>>cabbage;
        int x, y;

        //배추 심기
        while(cabbage--){
            cin>>x>>y;
            board[x][y] = 1;
        }

        int cnt = bfs();
        answer.push_back(cnt);

        //board초기화
        for(int i=0; i<51; i++){
            for(int j=0; j<51; j++){
                board[i][j] = 0;
            }
        }
    }

    for(int i: answer){
        cout<<i<<'\n';
    }
}