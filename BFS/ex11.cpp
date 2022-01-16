#include <bits/stdc++.h>
using namespace std;

#define X first
#define Y second
int board[501][501];
bool vis[501][501];
queue<pair<int, int>> Q;
int n,m;
int cnt = 0;
int sum = 0;
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};
int main(){
  cin>>n>>m;
  for(int i=0; i<n; i++){
    for(int j=0; j<m; j++){
      cin>>board[i][j];
    }
  }
  for(int i=0; i<n; i++){
    for(int j=0; j<m; j++){
      int nsum=0;
      if(board[i][j]==1&&vis[i][j]==0){Q.push({i, j}); vis[i][j]=1; cnt++; nsum++;}
      while(!Q.empty()){
        pair<int, int> cur = Q.front();
        Q.pop();
        for(int i=0; i<4; i++){
          int nx = cur.X + dx[i];
          int ny = cur.Y + dy[i];
          if(nx>=n||ny>=m||nx<0||ny<0)continue;
          if(board[nx][ny]==0||vis[nx][ny]==1)continue;
          Q.push({nx, ny});
          vis[nx][ny] = 1;
          nsum++;
        }
        sum = max(sum, nsum);
      }
    }
  }
  cout<<cnt<<'\n'<<sum;
}