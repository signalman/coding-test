#include <bits/stdc++.h>
using namespace std;
#define X first
#define Y second

int dx[4] = {0, 1, -1, 0};
int dy[4] = {1, 0, 0, -1};
int n, t;
int board[13][13];
int board1[13][13];
vector<pair<int, int>> core;
void go(int x, int y, int dir){
  int nx = x + dx[dir];
  int ny = y + dy[dir];
  if(nx<0||ny<0||nx>=n||ny>=n) 
}

int main(){
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin>>t;
  while(t--){
    cin>>n;
    core.clear();
    for(int i=0; i<n; i++){
      for(int j=0; j<n; j++){
        cin>>board[i][j];
        board1[i][j] = board[i][j];
        if(board[i][j] == 1) core.push_back({i, j});
      }
    }

    for(int brute = 0; brute<(1<<(2*core.size())); brute++){
      int temp = brute;
      int dir = temp % 4;
      for(int i=0; i<core.size(); i++){
        int x = core[i].X;
        int y = core[i].Y;
        int ny = y + dy[dir];
        int nx = x + dx[dir];
        while(1){
          if(nx<0||ny<0||nx>=n||ny>=n)break;
          if(board1[nx][ny] == 1) break;
        }
      }

    }


  }
}