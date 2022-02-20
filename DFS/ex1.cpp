#include <bits/stdc++.h>
using namespace std;
#define X first
#define Y second
string board[1002];
int dist[1002][1002];
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, -1, 0, 1};
int n,m;
int main(){
  cin>>n>>m;
  for(int i=0; i<n; i++){
    cin>>board[i];
  }
  for(int i=0; i<n; i++){
    for(int j=0; j<m; j++){
      dist[i][j]=-1;
    }
  }
  queue<pair<int, int>> Q;
  Q.push({0,0});
  dist[0][0]=1;
  while(!Q.empty()){
    auto cur = Q.front(); Q.pop();
    for(int dir=0; dir<4; dir++){
      int nx = cur.X + dx[dir];
      int ny = cur.Y + dy[dir];
      if(nx<0||ny<0||nx>=n||ny>=m)continue;
      if(board[nx][ny]==1 || dist[nx][ny]!=-1)continue;
      Q.push({nx, ny});
      dist[nx][ny]=dist[cur.X][cur.Y]+1;
    }
  }
  if(dist[n-1][m-1]==-1){}
  else{
    int f = dist[n-1][m-1];
  }














  int f = dist[n-1][m-1]; // 첫번째 케이스 답
  int s=-1; // 두번째 케이스의 답을 저장할 변수
  for(int i=0; i<n; i++){ //dist 초기화
    for(int j=0; j<m; j++){
      dist[i][j]=-1;
    }
  }
  for(int i=0; i<n; i++){
    for(int j=0; j<m; j++){
      if(board[i][j]==1){
        board[i][j]=0;
        Q.push({0,0});
        dist[0][0]=1;
        while(!Q.empty()){
          auto cur = Q.front(); Q.pop();
          for(int dir=0; dir<4; dir++){
            int nx = cur.X + dx[dir];
            int ny = cur.Y + dy[dir];
            if(nx<0||ny<0||nx>=n||ny>=m)continue;
            if(board[nx][ny]==1 || dist[nx][ny]!=-1)continue;
            Q.push({nx, ny});
            dist[nx][ny]=dist[cur.X][cur.Y]+1;
          }
        }
        s=min(s,dist[n-1][m-1]);
        board[i][j]=1;
      }
    }
  }
}