#include <bits/stdc++.h>
using namespace std;
#define X first
#define Y second
int r, c, t;
int board[51][51];
int board1[51][51];
int board2[51][51];
int dx[4] = {-1, 0, 1, 0};
int dy[4] = {0, 1, 0, -1};
vector<pair<int, int>> v;
void diffusion(){
  for(int i=0; i<r; i++){
    fill(board1[i], board1[i]+c, 0);
    fill(board2[i], board2[i]+c, 0);
  }
  for(int i=0; i<r; i++){
    for(int j=0; j<c; j++){
      int cnt = 0;
      if(board[i][j]==0||board[i][j]==-1)continue;
      for(int dir =0 ; dir<4; dir++){
        int nx = i + dx[dir];
        int ny = j + dy[dir];
        if(nx<0||ny<0||nx>=r||ny>=c)continue;
        if(board[nx][ny]==-1)continue;
        board1[nx][ny] += board[i][j]/5;
        cnt++;
      }
      board2[i][j] = board[i][j] - (board[i][j]/5)*cnt;
    }
  }
  for(int i=0; i<r; i++){
    for(int j=0; j<c; j++){
      board[i][j] = board1[i][j] + board2[i][j];
    }
  }
}
void run(int fi, int fj, int si, int sj){
  for(int i=fi-1; i>=1; i--){
    board[i][fj] = board[i-1][fj];
  }
  for(int j=0; j<c-1; j++){
    board[0][j] = board[0][j+1];
  }
  for(int i=0; i<fi; i++){
    board[i][c-1] = board[i+1][c-1];
  }
  for(int j=c-1; j>=2; j--){
    board[fi][j] = board[fi][j-1];
  }  
  board[fi][fj+1] = 0;

  for(int i=si+1; i<r-1; i++){
    board[i][sj] = board[i+1][sj];
  }
  for(int j=0; j<c-1; j++){
    board[r-1][j] = board[r-1][j+1];
  }
  for(int i=r-1; i>si; i--){
    board[i][c-1] = board[i-1][c-1];
  }
  for(int j=c-1; j>=2; j--){
    board[si][j] = board[si][j-1];
  }  
  board[si][sj+1] = 0;
  board[si][sj] = 0;
  board[fi][fj] = 0;

}

int main(){
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin>>r>>c>>t;
  for(int i=0; i<r; i++){
    for(int j=0; j<c; j++){
      cin>>board[i][j];
      if(board[i][j]==-1) v.push_back({i,j});
    }
  }
  while(t--){
    diffusion();
    run(v[0].X, v[0].Y, v[1].X, v[1].Y);
  }
  
  int ans = 0;
  for(int i=0; i<r; i++){
    for(int j=0; j<c; j++){
      if(board[i][j]==-1)continue;
      ans += board[i][j];
    }
  }
  cout<<ans;
}