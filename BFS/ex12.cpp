#include <bits/stdc++.h>
using namespace std;

#define X first
#define Y second
int n, m;
string board[102];
int dist[101][101];
int dx[4] = {0, 1, -1, 0};
int dy[4] = {1, 0, 0, -1};
int main(){
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  queue<pair<int, int>> Q;
  cin>>n>>m;
  for(int i=0; i<n; i++){
    cin>>board[i];
  }
  for(int i=0; i<n; i++) fill(dist[i], dist[i]+m, -1);
  Q.push({0, 0});
  dist[0][0] = 1;
  while(!Q.empty()){
    pair<int, int> cur = Q.front(); 
    Q.pop();
    for(int i=0; i<4; i++){
      int nx = cur.X + dx[i];
      int ny = cur.Y + dy[i];
      if(nx>= n || ny>=m || nx<0 || ny<0)continue;
      if(dist[nx][ny] != -1 || board[nx][ny]=='0') continue;
      Q.push({nx, ny});
      dist[nx][ny] = dist[cur.X][cur.Y] + 1;
    }
  }

  cout<< dist[n-1][m-1];
}