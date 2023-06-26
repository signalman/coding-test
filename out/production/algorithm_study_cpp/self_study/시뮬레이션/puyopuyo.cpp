#include <bits/stdc++.h>
using namespace std;

#define X first
#define Y second
int dx[4] = {-1, 0, 1, 0};
int dy[4] = {0, 1, 0, -1};
char board[15][15];
// 1. .을 만나면 밑으로 이동 
// 2. bfs  -> 4개 이상이면 연쇄
// 3. 연쇄된 뿌요를 .으로 변경
queue<pair<int, int>> Q;
int ans = 0;
bool b;  
void bfs(){
  bool vis[15][15]={0,};
  bool flag = false;
  for(int i=0; i<12; i++){
    for(int j=0; j<6; j++){
      if(board[i][j] == '.') continue;
      int cnt = 0;
      vector<pair<int, int>> v;
      Q.push({i, j});
      v.push_back({i, j});
      while(!Q.empty()){
        auto cur = Q.front();
        Q.pop();
        for(int dir = 0 ; dir < 4; dir++){
          int nx = cur.X + dx[dir];
          int ny = cur.Y + dy[dir];
          if(nx < 0 || ny < 0 || nx >= 12 || ny >= 6) continue;
          if(board[nx][ny] == '.' || board[nx][ny] != board[cur.X][cur.Y]) continue;
          if(vis[nx][ny]) continue;
          Q.push({nx, ny});
          v.push_back({nx, ny});
          vis[nx][ny] = true;
          cnt++;
        }
      }
      if(cnt >= 4){
        for(int i=0; i<v.size(); i++){
          board[v[i].X][v[i].Y] = '.';
          flag = true;
          b= true;
        }
      }
    }
  }
  if(flag){ans++;}
}

void movedown(int x, int y){
  char c = board[x][y];
  for(int i=x+1; i<12; i++){
    if(board[i][y] != '.') {board[x][y] ='.'; board[i-1][y] = c;  break;}
    if(i==11){board[x][y] ='.'; board[i][y] =c; break;}
  }
}


int main(){
  for(int i=0; i<12; i++){
    for(int j=0; j<6; j++){
      cin>>board[i][j];
    }
  }
  b=true;
  while(b){
    b=false;
    bfs();
    for(int i=11; i>=0; i--){
      for(int j=0; j<6; j++){
        if(board[i][j] == '.')continue;
        movedown(i, j);
      }
    }
  }
  cout<<ans;
}