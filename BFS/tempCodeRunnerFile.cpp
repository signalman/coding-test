#include <bits/stdc++.h>
using namespace std;

//board에서 1->익은 토마토, 0->익지않은토마토, -1 -> 토마토가 없음
//dist에서 -1->익지않은토마토, 나머지 0
#define X first
#define Y second
int board[1002][1002];
int dist[1002][1002];
int n,m;
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, -1, 0, 1};
int main(){
  cin>>n>>m;
  queue<pair<int, int>> Q;
  for(int i=0; i<n; i++){
    for(int j=0; j<m; j++){
      cin>>board[i][j];
      if(board[i][j]==1){
        Q.push({i,j});
      }
      if(board[i][j]==0){
        dist[i][j]=-1;
      }
    }
  }
  while(!Q.empty()){
    pair<int,int> cur = Q.front(); Q.pop();
    for(int i=0; i<4; i++){
      int nx = cur.X + dx[i];
      int ny = cur.Y + dy[i];
      if(nx < 0 || ny < 0 || nx >= n || ny >= m)continue;
      if(dist[nx][ny]>=0)continue;
      dist[nx][ny] = dist[cur.X][cur.Y] +1;
      Q.push({nx,ny});
    }
  }
  int ans = 0;
  for(int i=0; i<n; i++){
    for(int j=0; j<m; j++){
      if(dist[i][j] == -1){
        cout<< -1;
        return 0;
      }
      ans = max(ans, dist[i][j]);
    }
  }
  cout<<ans;



}
