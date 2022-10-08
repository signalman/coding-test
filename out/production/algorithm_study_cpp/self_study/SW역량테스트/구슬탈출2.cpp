#include <bits/stdc++.h>
using namespace std;

#define X first
#define Y second

char board[11][11];
pair<int, int> red, blue; //좌표를 담을 변수
int n, m;
int dist[11][11][11][11];
//right, down, left, up
int dx[4] = {0, 1, 0, -1};
int dy[4] = {1, 0, -1, 0};

int bfs(){
  queue<tuple<int, int, int, int>> Q;
  Q.push({red.X, red.Y, blue.X, blue.Y});
  dist[red.X][red.Y][blue.X][blue.Y] = 0;
  while(!Q.empty()){
    int rx, ry, bx, by;
    tie(rx, ry, bx, by) = Q.front();
    Q.pop();
    int cnt = dist[rx][ry][bx][by];
    if(cnt >= 10) return -1;
    for(int i =0 ; i<4; i++){
      int n_rx = rx, n_ry = ry, n_bx = bx, n_by = by;
      while(board[n_bx + dx[i]][n_by + dy[i]] == '.'){
        n_bx += dx[i];
        n_by += dy[i];
      }
      if(board[n_bx + dx[i]][n_by + dy[i]] == 'O') continue;
      while(board[n_rx + dx[i]][n_ry + dy[i]] == '.'){
        n_rx += dx[i];
        n_ry += dy[i];
      }
      if(board[n_rx + dx[i]][n_ry + dy[i]] == 'O') return cnt+1;
      if((n_rx==n_bx) && (n_ry==n_by)){
        if(i==0)       ry < by ? n_ry-- : n_by--;
        else if(i ==1) rx < bx ? n_rx-- : n_bx--;
        else if(i==2)  ry > by ? n_ry++ : n_by++;
        else           rx > bx ? n_rx++ : n_bx++;
      }
      if(dist[n_rx][n_ry][n_bx][n_by] != -1)continue;
      Q.push({n_rx, n_ry, n_bx, n_by});
      dist[n_rx][n_ry][n_bx][n_by] = cnt + 1;
    }
  }
  return -1;
}
int main(void) {
  ios::sync_with_stdio(0);
  cin.tie(0);

  // 거리 배열 초기화
  for(int i = 0; i < 10; i++)
    for(int j = 0; j < 10; j++)
      for(int k = 0; k < 10; k++)
        fill(dist[i][j][k], dist[i][j][k]+10, -1);
  
  cin >> n >> m;
  for (int i = 0; i < n; i++) {
    cin >> board[i];
    for (int j = 0; j < m; j++) {      
      if (board[i][j] == 'B'){
        blue = {i, j};
        board[i][j] = '.';
      }
      else if (board[i][j] == 'R'){
        red = {i, j};
        board[i][j] = '.';
      }
    }
  }
  
  cout << bfs();
}
