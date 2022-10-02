#include <bits/stdc++.h>
using namespace std;
#define X first
#define Y second

int n, m, k;
int board[41][41]; 
int paper[12][12];
int r, c;

void rotate(){
  int tmp[12][12];

  for(int i=0; i<r; i++){
    for(int j=0; j<c; j++){
      tmp[i][j] = paper[i][j];
    }
  }
  for(int i=0; i<c; i++){
    for(int j=0; j<r; j++){
      paper[i][j] = tmp[r-1-j][i];
    }
  }
  swap(r, c);
}
bool pastable(int x, int y){
  for(int i=0; i<r; i++){
    for(int j=0; j<c; j++){
      if(board[x+i][y+j] == 1 && paper[i][j] == 1) return false;
    }
  }
  for(int i=0; i<r; i++){
    for(int j=0; j<c; j++){
      if(paper[i][j] == 1) {
        board[x+i][y+j] = 1;
      }
    }
  }
  return true;
}

int main(){
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin>>n>>m>>k;
  while(k--){
    cin>>r>>c;
    for(int i=0; i<r; i++){
      for(int j=0; j<c; j++){
        cin>>paper[i][j];
      }
    }
    for(int rot = 0; rot < 4; rot++){
      bool ispaste = false;
      for(int i=0; i<=n-r; i++){
        if(ispaste) break;
        for(int j=0; j<=m-c; j++){
          if(pastable(i, j)){
            ispaste = true;
            break;
          }
        }
      }
      if(ispaste) break;
      rotate();
    }
  }
  int cnt = 0;
  for(int i=0; i<n; i++){
    for(int j=0; j<m; j++){
      cnt += board[i][j];
    }
  }
  cout<< cnt << '\n';
}