#include <bits/stdc++.h>
using namespace std;

#define X first
#define Y second
char board[1001][1001];
int jdist[1001][1001];
int fdist[1001][1001];
int r, c;
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};
queue<pair<int, int>> jQ;
queue<pair<int, int>> fQ;

int main(){
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin>>r>>c;
  for(int i=0; i<r; i++){
    for(int j=0; j<c; j++){
      cin>>board[i][j];
      jdist[i][j] = -1;
      fdist[i][j] = -1;
      if(board[i][j]=='J'){jdist[i][j]=0;fdist[i][j]=-1;jQ.push({i, j});}
      if(board[i][j]=='F'){fdist[i][j]=0;fQ.push({i, j});}
    }
  }
  while(!fQ.empty()){
    auto cur = fQ.front();
    fQ.pop();
    for(int i=0; i<4; i++){
      int nx = cur.X +dx[i];
      int ny = cur.Y +dy[i];
      if(nx>=r||ny>=c||nx<0||ny<0)continue;
      if(board[nx][ny]=='#'||fdist[nx][ny]!=-1)continue;
      fdist[nx][ny] = fdist[cur.X][cur.Y] + 1;
      fQ.push({nx, ny});
    }
  }
  while(!jQ.empty()){
    auto cur = jQ.front();
    jQ.pop();
    for(int i=0; i<4; i++){
      int nx = cur.X +dx[i];
      int ny = cur.Y +dy[i];
      if(nx>=r||ny>=c||nx<0||ny<0) {cout<<jdist[cur.X][cur.Y]+1; return 0;}
      if(board[nx][ny]=='#'||jdist[nx][ny]!=-1)continue;
      if(fdist[nx][ny] != -1 && jdist[cur.X][cur.Y]+1 >= fdist[nx][ny])continue;//
      jdist[nx][ny] = jdist[cur.X][cur.Y] + 1;
      jQ.push({nx, ny});
    }
  }
  cout<<"IMPOSSIBLE";
  return 0;

}