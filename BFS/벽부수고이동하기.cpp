#include <bits/stdc++.h>
using namespace std;

#define X first
#define Y second
char board[1001][1001];
int dist[1001][1001][2];
int dx[4] = {1, 0 ,-1, 0};
int dy[4] = {0, -1, 0, 1};
int n, m;
queue<tuple<int, int, int>> Q;
int main(){
  cin>>n>>m;
  for(int i=1; i<=n; i++){
    for(int j=1; j<=m; j++){
      cin>>board[i][j];
    }
  }
  if(n==1 && m==1){cout<<1<<'\n'; return 0;}
  dist[1][1][0] = 1;
  Q.push({1,1,0});
  
  while(!Q.empty()){
    int x, y, b;
    tie(x, y, b) = Q.front();
    Q.pop();
    for(int i=0; i<4; i++){
      int nx = x + dx[i];
      int ny = y + dy[i];
      int nb = b;
      if( nx<=0 || ny<=0 || nx>n || ny>m ) continue;
      if( board[nx][ny] == '1' ){
        if(b==1)continue;
        else {
          nb=1;
          dist[nx][ny][nb] = dist[x][y][b] + 1; 
          Q.push({nx,ny,nb});
          continue;}
      }
      if(dist[nx][ny][nb] != 0) continue;
      dist[nx][ny][nb] = dist[x][y][b] + 1;
      Q.push({nx,ny,b});
      if(nx==n&&ny==m){cout<<dist[nx][ny][b]; return 0;}
    }
  }
  cout<<-1<<'\n';
  // for(int i=1; i<=n; i++){
  //   for(int j=1; j<=m; j++){
  //     cout<<dist[i][j][0]<<' ';
  //   }
  //   cout<<'\n';
  // }
  // for(int i=1; i<=n; i++){
  //   for(int j=1; j<=m; j++){
  //     cout<<dist[i][j][1]<<' ';
  //   }
  //   cout<<'\n';
  // }
  return 0;
  
}