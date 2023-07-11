//dfs 틀린 풀이  (시간초과 찾은 거리가 최단인지 모름으로 다 돌아봐야함)
//4^(NM)

// #include <bits/stdc++.h>
// using namespace std;

// int dx[] = {0, 0, 1, -1};
// int dy[] = {1, -1, 0, 0};

// int n, m;
// char board[1001][1001];
// bool vis[1001][1001];
// int ans = 0x7f7f7f7f;

// void dfs(int x, int y, int cnt, bool isBreak){
//     if(x == n-1 && y == m-1){
//         if(cnt == 1)  return;
//         ans = min(ans, cnt);
//         return;
//     }

//     for(int dir = 0; dir < 4; dir++){
//         int nx = x + dx[dir];
//         int ny = y + dy[dir];
//         if(nx < 0 || ny < 0 || nx >=n || ny >=m) continue;
//         if(vis[nx][ny]) continue;
//         if(board[nx][ny] == '1' && isBreak == false){
//             vis[nx][ny] = true;
//             dfs(nx, ny, cnt+1, true);
//             vis[nx][ny] = false;
//         }
//         if(board[nx][ny] == '0'){
//             vis[nx][ny] = true;
//             dfs(nx, ny, cnt+1, isBreak);
//             vis[nx][ny] = false;
//         }
//     }
// }


// int main(){
//     ios_base::sync_with_stdio(0);
//     cin.tie(0);

//     cin>>n>>m;
//     for(int i=0; i<n; i++){
//         for(int j=0; j<m; j++){
//             cin>>board[i][j];
//         }
//     }
//     if(n==1 && m==1) {cout<<1; return 0;}
//     //처음과 끝을 카운트 하라고 했으므로 시작시 cnt를 1로 대입함.
//     vis[0][0] = 1;
//     dfs(0, 0, 1, 0);
//     if(ans == 0x7f7f7f7f) ans = -1;
//     cout<<ans;
// }



#include <bits/stdc++.h>
using namespace std;
#define X first
#define Y second

int dx[4] = {0,1,0,-1};
int dy[4] = {1,0,-1,0};

char board[1000][1000];
int dist[1000][1000][2];
int n, m;

bool OOB(int x, int y){
    return x < 0 || x >= n || y < 0 || y >= m;
}

int bfs() {
    for (int i = 0; i < n; ++i)
        for (int j = 0; j < m; ++j)
        dist[i][j][0] = dist[i][j][1] = -1;
    dist[0][0][0] = dist[0][0][1] = 1;
    queue<tuple<int, int, int>> q;
    q.push({0,0,0});
    while (!q.empty()) {
        int x, y, broken;
        tie(x, y, broken) = q.front();
        if(x == n-1 && y == m-1) return dist[x][y][broken];
        q.pop();
        int nextdist = dist[x][y][broken] + 1;
        for (int dir = 0; dir < 4; ++dir) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if(OOB(nx, ny)) continue;      
            if (board[nx][ny] == '0' && dist[nx][ny][broken] == -1) {
                dist[nx][ny][broken] = nextdist;
                q.push({nx, ny, broken});
            }      
            // (nx, ny)를 부수는 경우
            if (!broken && board[nx][ny] == '1' && dist[nx][ny][1] == -1) {
                dist[nx][ny][1] = nextdist;
                q.push({nx, ny, 1});
            }      
        }
    }
  return -1;
}

int main(void) {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cin >> n >> m;
  for (int i = 0; i < n; ++i)
    for (int j = 0; j < m; ++j)
      cin >> board[i][j];
  cout << bfs();
  return 0;
}