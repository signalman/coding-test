#include <bits/stdc++.h>
using namespace std;

int dx[] = {1, -1, 0, 0};
int dy[] = {0, 0, 1, -1};

int n;
char board[101][101];

//정상일때
int bfs1(){
    queue<pair<int, int>> q;
    bool vis[101][101] = {0, };
    int cnt = 0;
    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            if(vis[i][j] == 1) continue;
            q.push({i, j});
            vis[i][j] = 1;
            cnt++;
            while(!q.empty()){
                auto cur = q.front();
                q.pop();
                for(int dir = 0; dir < 4; dir++){
                    int nx = cur.first + dx[dir];
                    int ny = cur.second + dy[dir];

                    if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                    if(vis[nx][ny]) continue;
                    if(vis[nx][ny] || board[nx][ny] != board[cur.first][cur.second])continue;
                    vis[nx][ny] = 1;
                    q.push({nx, ny});
                }
            }
        }
    }
    return cnt;
}

//적록색맹일때
int bfs2(){
    queue<pair<int, int>> q;
    bool vis[101][101] = {0, };
    int cnt = 0;
    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            if(vis[i][j] == 1) continue;
            q.push({i, j});
            vis[i][j] = 1;
            cnt++;
            while(!q.empty()){
                auto cur = q.front();
                q.pop();
                for(int dir = 0; dir < 4; dir++){
                    int nx = cur.first + dx[dir];
                    int ny = cur.second + dy[dir];

                    if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                    if(vis[nx][ny]) continue;
                    if(board[nx][ny] == board[cur.first][cur.second] ||  //현재와 다음칸이 같은색일때
                    board[nx][ny]=='R'&& board[cur.first][cur.second]=='G' || //현재칸이 R 다음칸이 G
                    board[nx][ny]=='G' &&board[cur.first][cur.second]=='R') {  // 현재칸이 G 다음칸이 R
                        q.push({nx, ny});
                        vis[nx][ny] = 1;
                    }
                }
            }
        }
    }
    return cnt;
}

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin>>n;
    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            cin>>board[i][j];
        }
    }

    cout<<bfs1()<<' '<<bfs2();
}