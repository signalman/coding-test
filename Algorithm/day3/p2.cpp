#include <bits/stdc++.h>
using namespace std;

int n;
int ans = 201;
int board[101][101];
bool vis[101][101];
int dist[101][101];

int dx[] = {1, 0, -1, 0};
int dy[] = {0, 1, 0, -1};

int main(){
    cin>>n;
    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            cin>>board[i][j];
        }
    }

    int cnt = 0;
    queue<pair<int, int>> q;
    //각 육지별로 숫자 다르게 부여
    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            if(board[i][j] == 1 && vis[i][j]==0){
                cnt++;
                vis[i][j] = true;
                board[i][j] = cnt;
                q.push({i, j});
                while(!q.empty()){
                    auto cur = q.front();
                    q.pop();
                    for(int dir = 0; dir < 4; dir++){
                        int nx = cur.first + dx[dir];
                        int ny = cur.second + dy[dir];

                        if(nx < 0|| ny < 0|| nx >=n || ny >= n)continue;
                        if(vis[nx][ny] || board[nx][ny]==0)continue;
                        board[nx][ny] = cnt;
                        vis[nx][ny] = 1;
                        q.push({nx, ny});
                    }
                }
            }
        }
    }

    //dist배열을 -1로 초기화
    for(int i=0; i<n; i++) fill(dist[i], dist[i]+n, -1);

    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            if(board[i][j] != 0){
                q.push({i, j});
                dist[i][j] = 0;

                while(!q.empty()){
                    auto cur = q.front();
                    q.pop();

                    for(int dir =0; dir<4; dir++){
                        int nx = cur.first + dx[dir];
                        int ny = cur.second + dy[dir];

                        if(nx < 0|| ny < 0|| nx >=n || ny >= n)continue;
                        if(board[i][j] == board[nx][ny] || dist[nx][ny]>=0)continue;
                        if(board[nx][ny] != 0 && board[nx][ny] != board[i][j]){
                            ans = min(ans, dist[cur.first][cur.second]);
                        }
                        dist[nx][ny] = dist[cur.first][cur.second]+1;
                        q.push({nx, ny});
                    }
                }
                for(int i=0; i<n; i++) fill(dist[i], dist[i]+n, -1);
            }
        }
    }
    cout<<ans;
}