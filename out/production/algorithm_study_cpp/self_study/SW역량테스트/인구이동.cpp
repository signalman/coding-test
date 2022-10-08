#include <bits/stdc++.h>
#include <iostream>
using namespace std;
#define X first
#define Y second
//1. 검사 bfs
//2. 합 저장, 위치저장
int dx[4] ={1, 0, -1, 0};
int dy[4] ={0, 1, 0, -1};
int board[51][51];
int n, l, r;
queue<pair<int, int>> Q;

int main(){
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin>>n>>l>>r;
  for(int i=0; i<n; i++){
    for(int j=0; j<n; j++){
      cin>>board[i][j];
    }
  }
  int ans = 0;
  while(1){
    bool flag = false;
    bool vis[51][51] = {0,};
    for(int i=0; i<n; i++){
      for(int j=0; j<n; j++){
        if(vis[i][j]) continue;
        vis[i][j] = true;
        Q.push({i, j});
        vector<pair<int, int>> v;
        v.push_back({i, j});
        int sum = board[i][j];
        while(!Q.empty()){
          auto cur = Q.front();
          Q.pop();
          for(int dir=0; dir<4; dir++){
            int nx = cur.X + dx[dir];
            int ny = cur.Y + dy[dir];
            if(nx<0||ny<0||nx>=n||ny>=n)continue;
            if(vis[nx][ny])continue;
            int dif = abs(board[cur.X][cur.Y] - board[nx][ny]);
            if(dif < l || dif > r)continue;
            Q.push({nx, ny});
            vis[nx][ny] = true;
            v.push_back({nx, ny});
            sum += board[nx][ny];
            flag = true;
          }
        }

        for(int i=0; i<v.size(); i++){
          int k = sum / v.size();
          board[v[i].X][v[i].Y] = k;
        }
      }
    }
    if(!flag) break;
    ans++;
  }
  cout<<ans;
}