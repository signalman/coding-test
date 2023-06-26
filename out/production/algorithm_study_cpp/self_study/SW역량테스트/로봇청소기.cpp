#include <bits/stdc++.h>
using namespace std;

#define X first
#define Y second
int n, m;
int dx[4] = {-1, 0, 1, 0};
int dy[4] = {0, 1, 0, -1};
int board1[51][51];
int board2[51][51];
bool vis[51][51];
int cnt = 0;

void robot(int x, int y, int d){
  if(!vis[x][y]){
    board2[x][y] = ++cnt;
    vis[x][y] = true;
  }
  for(int i=0; i<4; i++){
    int nd = (d-i+3)%4;
    int nx= x + dx[nd];
    int ny= y + dy[nd];
    if(board2[nx][ny]!=0 || vis[nx][ny]) continue;
    robot(nx, ny, nd);
  }
  int px = x + dx[(d+2)%4];
  int py = y + dy[(d+2)%4];
  if(board2[px][py] == 2) return;
  robot(px, py, d);
}

int main(){
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin>>n>>m;
  int r, c, d;
  cin>>r>>c>>d;
  int cnt1 = 0;
  for(int i=0; i<n; i++){
    for(int j=0; j<m; j++){
      cin>>board1[i][j];
      if(board1[i][j] == 0) cnt1++;
      board2[i][j] = board1[i][j];
      if(board1[i][j]==1) board2[i][j]=2;
    }
  }
  int cnt2 = 0;
  robot(r, c, d);
  for(int i=0; i<n; i++){
    for(int j=0; j<m; j++){
      // if(board2[i][j]==0) cnt2++;
      cout<<board2[i][j]<<' ';
    }
    cout<<'\n';
  }
  return 0;
  // cout<< cnt1 - cnt2;
}