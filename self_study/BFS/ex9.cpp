#include <bits/stdc++.h>
using namespace std;
#define X first
#define Y second
string board[102];
int vis[102][102];
int dx[4]={1,0,-1,0};
int dy[4]={0,-1,0,1};
int n,m;
queue<pair<int, int>> Q;
void bfs(){
  Q.push({0,0});
  vis[0][0]=1;
  for(int i=0; i<n; i++){
    for(int j=0; j<m; j++){
      if(board[i][j]=='0'||vis[i][j]!=0)continue;
      while(!Q.empty()){
        auto cur = Q.front(); Q.pop();
        for(int dir =0 ; dir<4; dir++){
          int nx = cur.X + dx[dir];
          int ny = cur.Y + dy[dir];
          if(nx<0 || ny<0 || nx>=n ||ny>=m)continue;
          if(board[nx][ny]=='0'||vis[nx][ny]!=0)continue;
          Q.push({nx,ny});
          vis[nx][ny] = vis[cur.X][cur.Y]+1;
        }
      }
    }
  }
  cout<<vis[n-1][m-1];
}
void input(){
  cin>>n>>m;
  for(int i=0; i<n; i++){
    cin>>board[i];
  }
}
int main(){
  input();
  bfs();
}