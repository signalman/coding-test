#include <bits/stdc++.h>
using namespace std;

#define X first
#define Y second
int board[10][10];
bool vis[10][10];
int n, m;
queue<pair<int, int>> Q;

int cam1(int x, int y, int dir){
  int cnt = 0;
  //right
  if(dir==0){
    for(int j=y; j<m; j++){if(board[x][j]==6) break;
      if(board[x][j]==0&&!vis[x][j]) {vis[x][j] = true; cnt++;}
    }
  }
  //up
  else if(dir==1){
    for(int i=x; i>=0; i--){if(board[i][y]==6) break;
        if(board[i][y]==0&&!vis[i][y]){vis[i][y]=true; cnt++;}
    }
  }
  //left
  else if(dir==2){
    for(int j=y; j>=0; j--){if(board[x][j]==6) break;
      if(board[x][j]==0&&!vis[x][j]){vis[x][j]=true; cnt++;}
    }
  }
  //down
  else if(dir==3){
    for(int i=x; i<n; i++){if(board[i][y]==6) break;
      if(board[i][y]==0&&!vis[i][y]){vis[i][y]=true; cnt++;}
    }
  }
  return cnt;
}

int cam2(int x, int y, int dir){
  int cnt = 0;
  if(dir == 0 || dir == 2){
    for(int j=y; j<m; j++){if(board[x][j]==6) break;
      if(board[x][j]==0&&!vis[x][j]){vis[x][j]=true; cnt++;}
    }
    for(int j=y; j>=0; j--){if(board[x][j]==6) break;
      if(board[x][j]==0&&!vis[x][j]){vis[x][j]=true; cnt++;}
    }
  }
  else if(dir == 1 || dir == 3){
    for(int i=x; i>=0; i--){if(board[i][y]==6) break;
        if(board[i][y]==0&&!vis[i][y]){vis[i][y]=true; cnt++;}
    }
    for(int i=x; i<n; i++){if(board[i][y]==6) break;
      if(board[i][y]==0&&!vis[i][y]){vis[i][y]=true; cnt++;}
    }
  }
  return cnt;
}
int cam3(int x, int y, int dir){
  int cnt = 0;
  if(cnt == 0){
    for(int j=y; j<m; j++){if(board[x][j]==6) break;
      if(board[x][j]==0&&!vis[x][j]){vis[x][j]=true; cnt++;}
    }   
    for(int i=x; i>=0; i--){if(board[i][y]==6) break;
        if(board[i][y]==0&&!vis[i][y]){vis[i][y]=true; cnt++;}
    }
  }
  else if(cnt == 1){
    for(int j=y; j<m; j++){if(board[x][j]==6) break;
      if(board[x][j]==0&&!vis[x][j]){vis[x][j]=true; cnt++;}
    }
    for(int i=x; i<n; i++){if(board[i][y]==6) break;
      if(board[i][y]==0&&!vis[i][y]){vis[i][y]=true; cnt++;}
    }
  }
  else if(cnt == 2){
    for(int j=y; j>=0; j--){if(board[x][j]==6) break;
      if(board[x][j]==0&&!vis[x][j]){vis[x][j]=true; cnt++;}
    }
    for(int i=x; i<n; i++){if(board[i][y]==6) break;
      if(board[i][y]==0&&!vis[i][y]){vis[i][y]=true; cnt++;}
    }
  }
  else if (cnt == 3){
    for(int j=y; j>=0; j--){if(board[x][j]==6) break;
      if(board[x][j]==0&&!vis[x][j]){vis[x][j]=true; cnt++;}
    }
    for(int i=x; i>=0; i--){if(board[i][y]==6) break;
        if(board[i][y]==0&&!vis[i][y]){vis[i][y]=true; cnt++;}
    }
  }
  return cnt;
}
int cam4(int x, int y, int dir){
  int cnt = 0;
  if(dir == 0){
    for(int j=y; j<m; j++){if(board[x][j]==6) break;
      if(board[x][j]==0&&!vis[x][j]){vis[x][j]=true; cnt++;}
    }
    for(int i=x; i>=0; i--){if(board[i][y]==6) break;
        if(board[i][y]==0&&!vis[i][y]){vis[i][y]=true; cnt++;}
    }
    for(int j=y; j>=0; j--){if(board[x][j]==6) break;
      if(board[x][j]==0&&!vis[x][j]){vis[x][j]=true; cnt++;}
    }
  }
  else if(dir ==1){
    for(int i=x; i>=0; i--){if(board[i][y]==6) break;
        if(board[i][y]==0&&!vis[i][y]){vis[i][y]=true; cnt++;}
    }
    for(int j=y; j<m; j++){if(board[x][j]==6) break;
      if(board[x][j]==0&&!vis[x][j]){vis[x][j]=true; cnt++;}
    }
    for(int i=x; i<n; i++){if(board[i][y]==6) break;
      if(board[i][y]==0&&!vis[i][y]){vis[i][y]=true; cnt++;}
    }
  }
  else if(dir == 2){
    for(int j=y; j<m; j++){if(board[x][j]==6) break;
      if(board[x][j]==0&&!vis[x][j]){vis[x][j]=true; cnt++;}
    }
    for(int j=y; j>=0; j--){if(board[x][j]==6) break;
      if(board[x][j]==0&&!vis[x][j]){vis[x][j]=true; cnt++;}
    }
    for(int i=x; i<n; i++){if(board[i][y]==6) break;
      if(board[i][y]==0&&!vis[i][y]){vis[i][y]=true; cnt++;}
    }
  }
  else if(dir == 3){
    for(int i=x; i>=0; i--){if(board[i][y]==6) break;
        if(board[i][y]==0&&!vis[i][y]){vis[i][y]=true; cnt++;}
    }
    for(int i=x; i<n; i++){if(board[i][y]==6) break;
      if(board[i][y]==0&&!vis[i][y]){vis[i][y]=true; cnt++;}
    }
    for(int j=y; j>=0; j--){if(board[x][j]==6) break;
      if(board[x][j]==0&&!vis[x][j]){vis[x][j]=true; cnt++;}
    }
  }
  return cnt;
}

int cam5(int x, int y, int dir){
  int cnt = 0;
  for(int j=y; j<m; j++){if(board[x][j]==6) break;
    if(board[x][j]==0&&!vis[x][j]){vis[x][j]=true; cnt++;}
  }

  for(int i=x; i>=0; i--){if(board[i][y]==6) break;
      if(board[i][y]==0&&!vis[i][y]){vis[i][y]=true; cnt++;}
  }

  for(int j=y; j>=0; j--){if(board[x][j]==6) break;
    if(board[x][j]==0&&!vis[x][j]){vis[x][j]=true; cnt++;}
  }

  for(int i=x; i<n; i++){if(board[i][y]==6) break;
    if(board[i][y]==0&&!vis[i][y]){vis[i][y]=true; cnt++;}
  }
  return cnt;
}

int zcnt = 0;
int ans = 0;
int main(){
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin>>n>>m;
  for(int i=0; i<n; i++){
    for(int j=0; j<m; j++){
      cin>>board[i][j];
    }
  }
  for(int i=0; i<n; i++){
    for(int j=0; j<m; j++){
      if(board[i][j]==0){zcnt++;continue;}
      int m = 0;
      for(int dir=0; dir<4; dir++){
        if(board[i][j]==1){
          m = max(m, cam1(i, j, dir));
        }
        else if(board[i][j]==2){
          m = max(m, cam2(i, j, dir));
          cout<<m<<' ';
        }
        else if(board[i][j]==3){
          m = max(m, cam3(i, j, dir));
        }
        else if(board[i][j]==4){
          m = max(m, cam4(i, j, dir));
          cout<<m<<' ';
        }
        else if(board[i][j]==5){
          m = max(m, cam5(i, j, dir));
          cout<<m<<' ';
        }
      }
      ans += m;
    }
  }
  cout<<zcnt - ans;
  

}