#include <bits/stdc++.h>
using namespace std;
#define X first
#define Y second

int dx[] = {-1, 0, 1, 0};
int dy[] = {0, -1, 0, 1};
int n;
int board[21][21];
int dist[21][21];
int shark_size = 2;
int cnt;
int ans;

int main(){
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin>>n;
  int shark_x, shark_y;
  for(int i=0; i<n; i++){
    for(int j=0; j<n; j++){
      cin>>board[i][j];
      if(board[i][j] == 9){
        shark_x = i;
        shark_y = j;
      }
    }
  }
  bool flag = false;
  while(1){
    vector<tuple<int, int, int>> v;
    for(int i=0; i<n; i++){
      fill(dist[i], dist[i]+n, -1);
    }
    if(flag) break;
    dist[shark_x][shark_y] = 0;
    queue<pair<int, int>> Q;
    Q.push({shark_x, shark_y});
    board[shark_x][shark_y] = 0;
    while(!Q.empty()){
      flag = true;
      auto cur = Q.front(); Q.pop();
      for(int i=0; i<4; i++){
        int nx = cur.X + dx[i];
        int ny = cur.Y + dy[i];
        if(nx<0||ny<0||nx>=n||ny>=n) continue;
        if(dist[nx][ny] !=-1 || board[nx][ny] > shark_size) continue;
        dist[nx][ny] = dist[cur.X][cur.Y]+1;
        Q.push({nx, ny});
        if(board[nx][ny] !=0 && board[nx][ny] < shark_size) {
          v.push_back({dist[nx][ny], nx, ny});
        }
      }
    }
    if(!v.empty()){
      sort(v.begin(), v.end());
      ans+= get<0>(v[0]);
      board[get<1>(v[0])][get<2>(v[0])] = 0;
      cnt++;
      if(cnt == shark_size) {shark_size++; cnt = 0;}
      shark_x = get<1>(v[0]);
      shark_y = get<2>(v[0]);
      flag = false;
    }
  }
  cout<<ans;
}