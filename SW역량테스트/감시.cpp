#include <bits/stdc++.h>
using namespace std;

#define X first
#define Y second
//북, 동, 남, 서
int dx[4] = {-1, 0, 1, 0};
int dy[4] = {0, 1, 0, -1};
int board1[10][10];
int board2[10][10];
int n, m;
vector<pair<int, int>> cctv;

void upd(int x, int y, int dir){
  dir %= 4;
  while(true){
    x += dx[dir];
    y += dy[dir];
    if(x<0||y<0||x>=n||y>=m) return;
    if(board2[x][y] == 6) return;
    if(board2[x][y] != 0) continue;
    board2[x][y]= -1;
  }
}
int mn;
int main(){
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin>>n>>m;
  for(int i=0; i<n; i++){
    for(int j=0; j<m; j++){
      cin>>board1[i][j];
      if(board1[i][j] !=0 && board1[i][j] != 6) cctv.push_back({i,j});
      if(board1[i][j] == 0) mn++;
    }
  }

  for(int tmp=0; tmp<(1<<2*cctv.size()); tmp++){
    for(int i=0; i<n; i++){
      for(int j=0; j<m; j++){
        board2[i][j] = board1[i][j];
      }
    }
    int brute = tmp;
    for(int i=0; i<cctv.size(); i++){
      int dir = brute % 4;
      brute /= 4;
      int x = cctv[i].X;
      int y = cctv[i].Y;
      if(board1[x][y] == 1){
        upd(x, y, dir);
      }
      else if(board1[x][y] == 2){
        upd(x, y, dir);
        upd(x, y, dir+2);
      }
      else if(board1[x][y] == 3){
        upd(x, y, dir);
        upd(x, y, dir+1);
      }
      else if(board1[x][y] == 4){
        upd(x, y, dir);
        upd(x, y, dir+1);
        upd(x, y, dir+2);
      }
      else{
        upd(x, y, dir);
        upd(x, y, dir+1);
        upd(x, y, dir+2);
        upd(x, y, dir+3);
      }
    }
    int cnt = 0;
    for(int i=0; i<n; i++)
      for(int j=0; j<m; j++)
        if(board2[i][j] == 0) cnt++;
    mn = min(mn, cnt);
  }

  cout<<mn;
}