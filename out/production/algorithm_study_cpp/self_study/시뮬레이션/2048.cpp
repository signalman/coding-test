#include <bits/stdc++.h>
using namespace std;

#define X first
#define Y second
int dx[4] ={-1, 0, 1, 0};
int dy[4] = {0, 1, 0, -1};
int board1[21][21];
int board2[21][21];
int n;

void moveL(){
  int arr[21] = {};
  for(int i=0; i<n; i++){
    if(board2[i]==0)continue;
    arr[0] = *board2[i];
  }
}
int main(){
  cin>>n;
  for(int i=0; i<n; i++){
    for(int j=0; j<n; j++){
      cin>>board1[i][j];
    }
  }
  for(int tmp =0; tmp<1024; tmp++){
    int brute = tmp;
    for(int i=0; i<5; i++){
      int dir = brute % 4;
      brute /= 4;

    }
  }

}