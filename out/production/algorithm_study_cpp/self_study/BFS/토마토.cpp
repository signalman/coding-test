#include <bits/stdc++.h>
using namespace std;
#define X first
#define Y second
#define Z third
int n, m, h;
int board[101][101][101];
int vis[101][101][101];
int dx[6] = {0, 0, 1, -1, 0, 0};
int dy[6] = {1, -1, 0, 0, 0, 0};
int dz[6] = {0, 0, 0, 0, 1, -1};
queue<tuple<int,int,int>> Q;
int day = 0;
int main(){
  cin>>m>>n>>h;
  for(int i=0; i<h; i++){
    for(int j=0; j<n; j++){
      for(int k=0; k<m; k++){
        cin>>board[i][j][k];
      }
    }
  }for(int i=0; i<h; i++){
    for(int j=0; j<n; j++){
      for(int k=0; k<m; k++){
        vis[i][j][k] = -1;
      }
    }
  }
  for(int i=0; i<h; i++){
    for(int j=0; j<n; j++){
      for(int k=0; k<m; k++){
        if(board[i][j][k]!=1)continue;
        Q.push({i,j,k});
        vis[i][j][k]=0;
      }
    }
  }
  while(!Q.empty()){
    auto cur = Q.front();
    Q.pop();
    for(int i=0; i<6; i++){
      int nx = get<0>(cur)+ dx[i];
      int ny = get<1>(cur)+ dy[i];
      int nz = get<2>(cur)+ dz[i];
      if(nx>=n||ny>=m || nz>=h ||nx<0 ||ny <0 || nz<0)continue;
      if(board[nx][ny][nz]==-1 || vis[nx][ny][nz]!=-1)continue;
      vis[nx][ny][nz] = vis[get<0>(cur)][get<1>(cur)][get<2>(cur)] + 1;
      Q.push({nx, ny, nz});
    }
  }

  for(int i=0; i<h; i++){
    for(int j=0; j<n; j++){
      for(int k=0; k<m; k++){
        // if(board[i][j][k]==0&&vis[i][j][k]==-1){cout<< -1<<'\n'; return 0;}
        // day = max(vis[i][j][k], day);
        cout<<vis[i][j][k]<<' ';
      }
      cout<<'\n';
    }
    
  }
  // cout<<day;
  return 0;
}