#include <bits/stdc++.h>
using namespace std;
int dx[8] = {-1, -1, 0, 1, 1, 1, 0, -1};
int dy[8] = {0, -1, -1, -1, 0, 1, 1, 1};
struct FISH
{
  int x, y;
  int dir;
};
int board[4][4];
FISH fish[16];
int ans;

void solve(int board[4][4], FISH fish[16], int shark_x, int shark_y, int sum){
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
  //eat
  int fish_num = copy_board[shark_x][shark_y];
  int shark_dir = copy_fish[fish_num].dir;
  copy_fish[fish_num].x = -1;
  copy_fish[fish_num].y = -1;
  copy_fish[fish_num].dir = -1;
  copy_board[shark_x][shark_y] = -1;
  sum += (fish_num + 1);
  if(ans < sum) ans = sum;

  //copy_fish move
  for(int f=0; f<16; f++){
    if(copy_fish[f].x == -1) continue;
    int cx = copy_fish[f].x;
    int cy = copy_fish[f].y;
    int cd = copy_fish[f].dir;
    int nx = cx + dx[cd];
    int ny = cy + dy[cd];
    int nd = cd;
    while(nx<0||ny<0||nx>=4||ny>=4 || (nx==shark_x && ny==shark_y)){
      nd = (nd + 1) % 8;
      nx = cx + dx[nd];
      ny = cy + dy[nd];
    }

    if(copy_board[nx][ny] != -1){
      int target = copy_board[nx][ny];
      copy_fish[target].x = cx;
      copy_fish[target].y = cy;
      copy_fish[f].x = nx;
      copy_fish[f].y = ny;
      copy_fish[f].dir = nd;
      copy_board[nx][ny] = f;
      copy_board[cx][cy] = target;
    }
    else{
      copy_board[nx][ny] = f;
      copy_fish[f].x = nx;
      copy_fish[f].y = ny;
      copy_fish[f].dir = nd;
      copy_board[cx][cy] = -1;
    }
  }
    //shark move
    for(int step =1; step<4; step++){
      int x = shark_x + dx[shark_dir] * step;
      int y = shark_y + dy[shark_dir] * step;
      if(x<0||x>=4||y<0||y>=4) break;
      if(copy_board[x][y] == -1) continue;
      solve(copy_board, copy_fish, x, y, sum);
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
      fish[a].x = i;
      fish[a].y = j;
      fish[a].dir = b;
    }
  }
  solve(board, fish, 0, 0, 0);
  cout<<ans;
}
