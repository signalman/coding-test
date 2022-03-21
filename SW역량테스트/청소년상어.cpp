#include <bits/stdc++.h>
using namespace std;
// #define SHARK -9
int dx[] = {-1, -1, 0, 1, 1, 1, 0, -1};
int dy[] = {0, -1, -1, -1, 0, 1, 1, 1};

struct FISH
{
  int x, y;
  int dir;
};
FISH fish[16];
int board[4][4];
int ans;

void Solve(int board[4][4], FISH fish[16], int shark_x, int shark_y, int sum){
  int copy_board[4][4];
  FISH copy_fish[16];
  for(int i=0; i<4; i++){
    for(int j=0; j<4; j++){
      copy_board[i][j] = board[i][j];
    }
  }
  for(int i=0; i<16; i++){
    copy_fish[i] = fish[i];
  }

  //상어가 (x, y)물고기를 잡아먹는다.
  sum+=(copy_board[shark_x][shark_y]+1);
  if(ans<sum) ans = sum;
  int shark_dir = copy_fish[copy_board[shark_x][shark_y]].dir;
  copy_fish[copy_board[shark_x][shark_y]].x = -1;
  copy_fish[copy_board[shark_x][shark_y]].y = -1;
  copy_fish[copy_board[shark_x][shark_y]].dir = -1;
  copy_board[shark_x][shark_y] = -1;


  //fish move
  // for(int i=0; i<16; i++){
  //   if(copy_fish[i].x == -1) continue;
  // int cx = copy_fish[i].x;
  //   int cy = copy_fish[i].y;
  //   int cd = copy_fish[i].dir;
  //   int nd = cd;
  //   int nx = cx + dx[nd];
  //   int ny = cy = dy[nd];
  //   for(int d = 0; d<8; d++){
  //     nd = (nd + d) % 8;
  //     nx = cx + dx[nd];
  //     ny = cy + dy[nd];
  //     if(nx<0||ny<0||nx>=4||ny>=4 || (nx==shark_x&&ny==shark_y)) continue;
  //     break;
  //   }
  //   int target = copy_board[nx][ny];
  //   copy_fish[i].x = nx;
  //   copy_fish[i].y = ny;
  //   copy_fish[i].dir = nd;
  //   copy_fish[target].x =cx;
  //   copy_fish[target].y =cy;
  //   copy_fish[target].dir =cd;
  //   copy_board[cx][cy] = target;
  //   copy_board[nx][ny] = i;
  // }
  for (int f = 0; f < 16; ++f) { 
    if (copy_fish[f].y == -1) { continue; } 
    int cy = copy_fish[f].y; 
    int cx = copy_fish[f].x; 
    int cd = copy_fish[f].dir; 
    int ny = cy + dy[cd]; 
    int nx = cx + dx[cd]; 
    int nd = cd; 
    while (ny < 0 || ny >= 4 || nx < 0 || nx >= 4 || (ny == shark_y && nx == shark_x)) { 
      nd = (nd + 1) % 8; 
      ny = cy + dy[nd]; 
      nx = cx + dx[nd]; 
    } 
    if (copy_board[ny][nx] != -1) { 
      int target = copy_board[ny][nx]; 
      copy_fish[target].y = cy; 
      copy_fish[target].x = cx; 
      copy_fish[f].y = ny; 
      copy_fish[f].x = nx; 
      copy_fish[f].dir = nd; 
      copy_board[ny][nx] = f; 
      copy_board[cy][cx] = target; 
    } 
    else { 
      copy_fish[f].y = ny; 
      copy_fish[f].x = nx; 
      copy_fish[f].dir = nd; 
      copy_board[ny][nx] = f; 
      copy_board[cy][cx] = -1; 
    } 
  }



  //shark move
  for(int step = 1; step < 4; step++){
    int nx = shark_x + dx[shark_dir] * step;
    int ny = shark_y + dy[shark_dir] * step;
    if(nx<0||ny<0||nx>=4||ny>=4) break;
    if(copy_board[nx][ny] != -1){
      Solve(copy_board, copy_fish, nx, ny, sum);
    }
  }

}

int main(){
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  for(int i=0; i<4; i++){
    for(int j=0; j<4; j++){
      int a, b;
      cin>>a>>b;
      a--;
      b--;
      board[i][j] = a;
      fish[i].x = i;
      fish[i].y = j;
      fish[i].dir = b;
    }
  }
  Solve(board, fish, 0, 0, 0);
  cout<<ans;
}