#include <bits/stdc++.h>
using namespace std;
#define X first
#define Y second
char board[1002][1002];
int fdist[1002][1002];
int sdist[1002][1002];
bool check;
queue<pair<int, int>> fQ;
queue<pair<int, int>> sQ;
int dx[4] = {-1, 0, 1, 0};
int dy[4] = {0, 1, 0, -1};
int main(){
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  int t;
  cin>>t;
  while(t--){
    int h, w;
    cin>>h>>w;
    for(int i=0; i<w; i++){
      for(int j=0; j<h; j++){
        board[i][j] = ' ';
        fdist[i][j] = 0;
        sdist[i][j] = 0;
      }
    }
    check = false;
    for(int i=0; i<w; i++){
      for(int j=0; j<h; j++){
        cin>>board[i][j];
        if(board[i][j]=='#'){fdist[i][j]=-1; sdist[i][j]=-1;}
        if(board[i][j] == '*'){fdist[i][j]=1; fQ.push({i,j});}
        if(board[i][j] == '@'){sdist[i][j]=1; sQ.push({i,j});}
      }
    }
    while(!fQ.empty()){
      auto cur = fQ.front();
      fQ.pop();
      for(int i=0; i<4; i++){
        int nx = cur.X + dx[i];
        int ny = cur.Y + dy[i];
        if(nx < 0 || ny < 0 || nx >= w || ny >= h)continue;
        if(board[nx][ny] == '#' || fdist[nx][ny] != -1)continue;
        fdist[nx][ny] = fdist[cur.X][cur.Y] + 1;
        fQ.push({nx,ny});
      }
    }
    while(!sQ.empty()){
      auto cur = sQ.front();
      sQ.pop();
      for(int i=0; i<4; i++){
        int nx = cur.X + dx[i];
        int ny = cur.Y + dy[i];
        if(nx < 0 || ny < 0 || nx >= w || ny >= h) {cout<<sdist[cur.X][cur.Y]<<'\n'; check=true; break;}
        if(board[nx][ny] != '.' || sdist[nx][ny] != 0 || (fdist[nx][ny]!=0 &&sdist[cur.X][cur.Y] + 1 >= fdist[nx][ny])) continue;
        sdist[nx][ny] = sdist[cur.X][cur.Y] + 1;
        sQ.push({nx, ny});
      }
      if(check){break;}
    }   
    if(!check){cout<<"IMPOSSIBLE"<<'\n';}
  }
  return 0;
}