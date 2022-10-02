#include <bits/stdc++.h>
using namespace std;
#define X first
#define Y second
//0 : 빈칸, 1: 벽, 2: 바이러스
int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, 1, -1};
int n, m;
int board[51][51];
int board1[51][51];
vector<pair<int, int>> v;
int mask[11];
int ans = 0x7f7f7f7f;
void func(){
  do{
    int times= 0;
    queue<pair<int, int>> Q;
    for(int i=0; i<n; i++){
      fill(board1[i], board1[i] + n, -1);}
    for(int i=0; i<n; i++){
      for(int j=0; j<n; j++){
        if(board[i][j] == 1){
          board1[i][j] = -7;
        }
      }
    }
    for(int i=0; i<v.size(); i++){
      if(!mask[i]){
        board1[v[i].X][v[i].Y] = 0;
        Q.push({v[i].X, v[i].Y});
      }
    }
    while(!Q.empty()){
      auto cur = Q.front();
      Q.pop();
      for(int i=0; i<4; i++){
        int nx = cur.X + dx[i];
        int ny = cur.Y + dy[i];
        if(nx<0||ny<0||nx>=n||ny>=n)continue;
        if(board1[nx][ny] == -7 || board1[nx][ny] >= 0) continue;
        board1[nx][ny] = board1[cur.X][cur.Y] + 1;
        Q.push({nx, ny});
        if(board[nx][ny] != 2) times= board1[nx][ny];
      }
    }
      ans = min(ans, times);
    
  }while(next_permutation(mask, mask+v.size()));
}

int main(){
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin>>n>>m;
  for(int i=0; i<n; i++){
    for(int j=0; j<n; j++){
      cin>>board[i][j];
      if(board[i][j] == 2){
        v.push_back({i, j});
      }
    }
  }
  fill(mask, mask+v.size(), 1);
  fill(mask, mask+m, 0);
  func();
  if(ans == 0x7f7f7f7f) cout<<-1;
  else cout<<ans;
}