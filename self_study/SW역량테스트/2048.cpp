#include <bits/stdc++.h>
using namespace std;

#define X first
#define Y second
int board[21][21];
int board1[21][21];
int n;
//(0: left), (1: up), (2: right), (3: down)


void rot(){
  int temp[21][21];
  for(int i=0; i<n; i++){
    for(int j=0; j<n; j++){
      temp[i][j] = board1[i][j];
    }
  }
  for(int i=0; i<n; i++){
    for(int j=0; j<n; j++){
      board1[i][j] = temp[n-1-j][i];
    }
  }
}

void tilt(int k){
  while(k--) rot();
  for(int i=0; i<n; i++){
    int temp[21]= {};
    int t=0;
    for(int j=0; j<n; j++){
      if(board1[i][j] == 0) continue;
      if(temp[t] == 0) temp[t] = board1[i][j];
      else if(temp[t] == board1[i][j]) temp[t++] *= 2;
      else temp[++t] = board1[i][j];
    }
    for(int j=0; j<n; j++){
      board1[i][j] = temp[j];}
  }
}

int func(){
  int mx = 0;
  for(int temp=0; temp<(1<<10); temp++){
    //board1 초기화
    for(int i=0; i<n; i++){
      for(int j=0; j<n; j++){
        board1[i][j] = board[i][j];
      }
    }
    int brute = temp;
    for(int i=0; i<5; i++){
      int dir = brute%4;
      brute /= 4;
      tilt(dir);
    }
    
    for(int i=0; i<n; i++){
      for(int j=0; j<n; j++){
        mx=max(mx, board1[i][j]);
      }
    }
  }
  return mx;
}

int main(){
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin>>n;
  for(int i=0; i<n; i++){
    for(int j=0; j<n; j++){
      cin>>board[i][j];
    }
  }
  int ans = func();
  cout<<ans;
}