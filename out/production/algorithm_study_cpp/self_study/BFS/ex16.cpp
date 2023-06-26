#include <bits/stdc++.h>
using namespace std;

#define X first
#define Y second
char pic[101][101];
int vis1[101][101];
int vis2[101][101];
int dx[4] ={1, 0, -1, 0};
int dy[4] ={0, 1, 0, -1};
int n;
int cnt1 = 0;
int cnt2 = 0;
queue<pair<int, int>> Q;
int main(){
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin>>n;
  for(int i=0; i<n; i++){
    for(int j=0; j<n; j++){
      cin>>pic[i][j];
    }
  }

//적록색약이 아닌 사람.
  for(int i=0; i<n; i++){
    for(int j=0; j<n; j++){
      if(vis1[i][j] != 0)continue;
      Q.push({i, j});
      vis1[i][j] = 1;
      cnt1++;
      while(!Q.empty()){
        auto cur = Q.front();
        Q.pop();
        for(int i=0; i<4; i++){
          int nx = cur.X + dx[i];
          int ny = cur.Y + dy[i];
          if(nx<0 || ny<0 || nx>=n || ny>=n)continue;
          if(vis1[nx][ny]==1)continue;
          if(pic[nx][ny]!=pic[cur.X][cur.Y])continue;
          vis1[nx][ny] = 1;
          Q.push({nx, ny});
        }
      }
    }
  }
  //적록색약인 사람
  for(int i=0; i<n; i++){
    for(int j=0; j<n; j++){
      if(pic[i][j]=='R'){pic[i][j]='G';}
    }
  }
  for(int i=0; i<n; i++){
    for(int j=0; j<n; j++){
      if(vis2[i][j] != 0)continue;
      Q.push({i, j});
      vis2[i][j] = 1;
      cnt2++;
      while(!Q.empty()){
        auto cur = Q.front();
        Q.pop();
        for(int i=0; i<4; i++){
          int nx = cur.X + dx[i];
          int ny = cur.Y + dy[i];
          if(nx<0 || ny<0 || nx>=n || ny>=n)continue;
          if(vis2[nx][ny]==1)continue;
          if(pic[nx][ny]!=pic[cur.X][cur.Y])continue;
          vis2[nx][ny] = 1;
          Q.push({nx, ny});
        }
      }
    }
  }
  cout<< cnt1 << ' ' <<cnt2;
}