#include <bits/stdc++.h>
using namespace std;

#define X first
#define Y second
int n,m;
int board[301][301];
int nboard[301][301];
bool vis[301][301];
int year = 0;
bool ice = true;
queue<pair<int, int>> Q;
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};

int main(){
  cin>>n>>m;
  for(int i=0; i<n; i++){
    for(int j=0; j<m; j++){
      cin>>board[i][j];
      nboard[i][j] = board[i][j];
    }
  }

  while(ice){
    int c = 0;
    for(int i=0; i<n; i++){
      for(int j=0; j<m; j++){
        board[i][j] = nboard[i][j];
        vis[i][j] = false;
        while(!Q.empty()){Q.pop();}
      }
    }
    for(int i=0; i<n; i++){
      for(int j=0; j<m; j++){
      if(board[i][j] == 0 || vis[i][j]) continue;
      Q.push({i, j});
      vis[i][j] = true;
      c++;
      if(c==2) {ice = false; break;}
      while(!Q.empty()){
        auto cur = Q.front();
        Q.pop();
        int cnt = 0;
        for(int i=0; i<4; i++){
          int nx = cur.X + dx[i];
          int ny = cur.Y + dy[i];
          if(nx<0 || ny< 0 || nx>=n || ny>= m) continue;
          if(board[nx][ny] == 0) {cnt++; continue;}
          if(vis[nx][ny]) continue;
          Q.push({i, j});
          vis[nx][ny] = 1;
          nboard[cur.X][cur.Y] -= cnt;
        }
      }
    }
      if(!ice)break;
    }
    if(!ice){cout<<c<<'\n';break;}
    year++;
  }
  for(int i=0; i<n; i++){
    for(int j=0; j<m; j++){
      cout<<board[i][j] <<' ';
    }
    cout<<'\n';
  }
  cout << year << '\n';
  return 0;






  // for(int i=0; i<n; i++){
  //   for(int j=0; j<m; j++){
  //     if(board[i][j] != 0) continue;
  //     Q.push({i, j});
  //     vis[i][j] = 1;
  //     while(!Q.empty()){
  //       int cnt = 0;
  //       auto cur = Q.front();
  //       Q.pop();
  //       for(int i=0; i<4; i++){
  //         int nx = cur.X + dx[i];
  //         int ny = cur.Y + dy[i];
  //         if(nx<0||ny<0||nx>=n||ny>=m)continue;
  //         if(board[nx][ny]==0){cnt++;continue;}
  //         if(vis[nx][ny]!=0)continue;
  //         Q.push({nx, ny});
  //         vis[nx][ny] = 1;
  //         nboard[cur.X][cur.Y] -= cnt;
  //       }
  //     }
  //     year++;
  //   }
  // }
}