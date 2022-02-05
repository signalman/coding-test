#include <bits/stdc++.h>
using namespace std;

#define X first
#define Y second
int board[21][21];
int board1[21][21];
int rot_case[4];
int n;
//(0: left), (1: up), (2: right), (3: down)

void tilt(int k){
  for(int i=0; i<n; i++){
    int temp[21]= {};
    int t=0;
    for(int j=0; j<n; j++){
      if(board[i][j] == 0) continue;
      if(temp[t] == 0) temp[t] = board[i][j];
      else if(temp[t] == board[i][j]) temp[t++] *= 2;
      else temp[++t] = board[i][j];
    }
    for(int j=0; j<n; j++){
      board[i][j] = temp[i];}
  }
}

int func(){
  int mx = 0;
  for(int brute=0; brute<(1<<10); brute++){
    //board1 초기화
    for(int i=0; i<n; i++){
      for(int j=0; j<n; j++){
        board1[i][j] = board[i][j];
      }
    }
    int k = 0;
    int cur = brute;
    for(int i=0; i<5; i++){
      rot_case[i] = cur%4;
      cur /= 4;
    }
    for(int i=0; i<5; i++){
      int now = rot_case[i];
      if(now == 0){

      }
      else if(now == 1){

      }
      else if(now == 2){

      }
      else {

      }
      for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
          k=max(k, board1[i][j]);
        }
      }
    }
    mx = max(mx, k);
  }
  return mx;
}

int main(){
  int b[10] = { 1, 1, 3, 45 ,6, 45, 1, 8, 8, 8};
  int st = 0;
  int en = st+1;
  for(int i=0; i<10; i++){
    if(b[st] == b[en]) {b[st] *= 2; b[en] = 0; en++;}

  }
}