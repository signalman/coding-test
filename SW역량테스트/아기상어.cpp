#include <bits/stdc++.h>
using namespace std;
// 더 이상 먹을 수 있는 물고기가 공간에 없다면 아기 상어는 엄마 상어에게 도움을 요청한다.
// 먹을 수 있는 물고기가 1마리라면, 그 물고기를 먹으러 간다.
// 먹을 수 있는 물고기가 1마리보다 많다면, 거리가 가장 가까운 물고기를 먹으러 간다.
// 거리는 아기 상어가 있는 칸에서 물고기가 있는 칸으로 이동할 때, 지나야하는 칸의 개수의 최솟값이다.
// 거리가 가까운 물고기가 많다면, 가장 위에 있는 물고기, 그러한 물고기가 여러마리라면, 가장 왼쪽에 있는 물고기를 먹는다.
#define X first
#define Y second
int n;
int board[21][21];
int ans;
int dx[4] = {-1, 0, 0, 1};
int dy[4] = {0, -1, 1, 0};
int shark_size = 2;
int cnt;

void shark(int x, int y){
  queue<pair<int, int>> Q;
  bool edible[21][21] = {0,};
  bool flag = false;
  bool vis[21][21] = {0, };
  board[x][y] = 0;
  for(int i=0; i<n; i++){
    for(int j=0; j<n; j++){
      if(board[i][j] != 0 && board[i][j]<shark_size) {edible[i][j] = true; flag = true;}
    }
  }
  if(!flag) return;
  Q.push({x, y});
  vis[x][y] = true;
  while(!Q.empty()){
    auto cur = Q.front();
    Q.pop();
    for(int dir=0; dir<4; dir++){
      int nx = cur.X + dx[dir];
      int ny = cur.Y + dy[dir];
      if(nx<0||ny<0||nx>=n||ny>=n)continue;
      if(vis[nx][ny]) continue;
      if(board[nx][ny]>shark_size) continue;
      Q.push({nx, ny});
      vis[nx][ny] = true;
      ans++;
      if(edible[nx][ny]){
        cnt++; 
        board[nx][ny] = 0;
        if(cnt == shark_size){shark_size++; cnt = 0;}
        shark(nx, ny);
      }
    }
  }
}
int main(){
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin>>n;
  for(int i=0; i<n; i++){
    for(int j=0; j<n; j++){
      cin>>board[i][j];
      if(board[i][j] == 9) { shark(i, j); } 
    }
  }
  for(int i=0; i<n; i++){
    for(int j=0; j<n; j++){
      cout<<board[i][j]<<' ';
    }
    cout<<'\n';
  }
  cout<<ans;
}

