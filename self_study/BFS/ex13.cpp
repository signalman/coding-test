#include <bits/stdc++.h>
using namespace std;
#define X first
#define Y second
int m, n;
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};
int board[1001][1001];
int dist[1001][1001];
int main(){
  cin>>m>>n;
  queue<pair<int, int>> Q;
  for(int i=0; i<n; i++){
    for(int j=0; j<m; j++){
      cin>>board[i][j];
      dist[i][j] = board[i][j];
    }
  }
  for(int i=0; i<n; i++){
    for(int j=0; j<m; j++){
      if(board[i][j]!=1)continue;
      Q.push({i, j});
      dist[i][j] = 1;
    }
  }
  while(!Q.empty()){
    auto cur = Q.front();
    Q.pop();
    for(int i=0; i<4; i++){
      int nx = cur.X + dx[i];
      int ny = cur.Y + dy[i];
      if(nx<0||ny<0||nx>=n||ny>=m)continue;
      if(board[nx][ny] != 0 || dist[nx][ny] != 0)continue;
      Q.push({nx, ny});
      dist[nx][ny] = dist[cur.X][cur.Y] + 1;
    }
  }
  int mx =0;
  for(int i=0; i<n; i++){
    for(int j=0; j<m; j++){
      if(dist[i][j] == 0) {cout<< -1 ;  return 0;}
      mx = max(mx, dist[i][j]);
    }
  }
  cout<<mx -1;
}
