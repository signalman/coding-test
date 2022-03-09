//낚시꾼이 오른쪽으로 한칸이동
//낚시꾼이 있는 열 중 땅과 가장 가까운 상어 잡음. 잡은 상어 사라짐
//상어 이동
//한칸에 상어가 두마리 이상일 때 큰상어가 작은상어를 잡아먹음.

//상어는 rcsdz로 표시 -> r,c: 위치/ s: 속력/ d: 이동방향 / z: 크기
//d: 1, 2, 3, 4 -> 위, 아래, 우, 좌
#include <bits/stdc++.h>
using namespace std;

int dx[] = {0, -1, 1, 0, 0};
int dy[] = {0, 0, 0, 1, -1};
struct shark{
  int speed;
  int dir;
  int size;
};
shark board[102][102];
shark board1[102][102];
int R,C,M;

void move(){
  for(int i=1; i<=R; i++){
    for(int j=1; j<=C; j++){
      board1[i][j].size = 0;
      board1[i][j].speed = 0;
      board1[i][j].dir = 0;
    }
  }
  int mod_R = (R*2)-2;
  int mod_C = (C*2)-2;
  for(int i=1; i<=R; i++){
    for(int j=1; j<=C; j++){
      auto cur = board[i][j];
      if(cur.size>0){
        if(cur.dir == 1 ||cur.dir == 2){
          cur.speed %= mod_R;
          int curx = i;
          int cury = j;
          while(cur.speed--){
            int nx = curx + dx[cur.dir];
            int ny = cury + dy[cur.dir];
            if(nx<1||ny<1||nx>R||ny>C){
              nx = curx + dx[3-cur.dir];
              ny = cury + dy[3-cur.dir];
            }
            curx = nx; cury = ny;
          }
          board1[curx][cury].size < board[i][j].size ?  board1[curx][cury] = board[i][j] : board1[curx][cury] = board1[curx][cury];
        }
        else if(cur.dir == 2 || cur.dir == 3){
          cur.speed %= mod_C;
          int curx = i;
          int cury = j;
          while(cur.speed--){
            int nx = curx + dx[cur.dir];
            int ny = cury + dy[cur.dir];
            if(nx<1||ny<1||nx>R||ny>C){
              nx = curx + dx[7-cur.dir];
              ny = cury + dy[7-cur.dir];
            }
            curx = nx; cury = ny;
          }
          board1[curx][cury].size < board[i][j].size ?  board1[curx][cury] = board[i][j] : board1[curx][cury];
        }
        
      }
    }
  }
  for(int i=1; i<=R; i++){
    for(int j=1; j<=C; j++){
      board[i][j] = board1[i][j];
    }
  }
}

int main(){
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin>>R>>C>>M;
  for(int i=1; i<=R; i++){
    for(int j=1; j<=C; j++){
      board[i][j].speed = 0;
      board[i][j].dir = 0;
      board[i][j].size = 0;
    }
  }
  while(M--){
    int r,c,s,d,z;
    cin>>r>>c>>s>>d>>z;
    board[r][c].speed = s;
    board[r][c].dir = d;
    board[r][c].size = z;
  }

  int king = 0;
  int ans = 0;
  while(king<=C){
    king++;
    for(int i=1; i<=R; i++){
      if(board[i][king].size>0){
        ans+=board[i][king].size; 
        board[i][king].size=0;}
    }
    move();
  }
  cout<<ans;
}