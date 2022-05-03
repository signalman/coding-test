#include <bits/stdc++.h>
using namespace std;
#define MAX 20
int dx[4] = {-1, 0, 1, 0};
int dy[4] = {0, -1, 0, 1};
int n;
int board[MAX][MAX];
struct STUDENT
{
  int me;
  int fri[4];
  int row, col;
};
STUDENT st[400];

int getPoint(int x, int y, int i){
  int point  = 0;
  for(int i=0; i<4; i++){
    int nx = x + dx[i];
    int ny = y + dy[i];
    if(nx < 0 || ny < 0 || nx >= n || ny >=n) continue;
    if(board[nx][ny] == 0) point++;
    else{
      for(int j=0; j<4; j++){
        if(board[nx][ny] == st[i].fri[j]) point += 10;
      }
    }
  }
  return point;
}

void setStudent(int px, int py, int i){
  board[px][py] = st[i].me;
  st[i].row = px;
  st[i].col = py;
}

int calcPoint(int s){
  int point = 0;
  int x = st[s].row;
  int y = st[s].col;
  for(int d = 0; d < 4; d++){
    int nx = x + dx[d];
    int ny = y + dy[d];
    if(nx < 0 || ny < 0 || nx >= n || ny >=n) continue;
    for(int f = 0; f < 4; f++){
      if(board[nx][ny] == st[s].fri[f]){
        if(point == 0) point++;
        else{
          point *= 10;
        }
      }
    }
  }

  return point;
}

int main(){
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin>>n;
  for(int i=0; i<n*n; i++){
    cin>>st[i].me>>st[i].fri[0]>>st[i].fri[1]>>st[i].fri[2]>>st[i].fri[3];
  }
  for(int i=0; i<n*n; i++){
    int px = -1; int py = -1; int point = -1;
    for(int x = 0; x < n; x++){
      for(int y = 0; y < n; y++){
        if(board[x][y] == 0){
          int curPoint = getPoint(x, y, i);
          if(point < curPoint){
            px = x; py = y; point = curPoint;
          }
        }
      }
    }
    setStudent(px, py, i);
  }

  int ret = 0;
  for(int i=0; i<n*n; i++){
    ret += calcPoint(i);
  }
  // cout<<ret;


  for(int i=0; i<n; i++){
    for(int j=0; j<n; j++){
      cout<<board[i][j]<< ' ';
    }
    cout<<'\n';
  }
  return 0;
}