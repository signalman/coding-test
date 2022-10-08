#include <bits/stdc++.h>
using namespace std;

int board[150][150];
int ans[2];

bool check(int x, int y, int N){
  int first = board[x][y];
  bool c = true;
  for(int i=x; i<x+N; i++){
    for(int j=y; j<y+N; j++){
      if(first != board[i][j]) {c = false; break;}
    }
  }
  return c;
}

void sol(int x, int y, int N){
  if(check(x, y, N)) {ans[board[x][y]]++; return;}
  for(int i=0; i<2; i++){
    for(int j=0; j<2; j++){
      sol(x+i*(N/2), y+j*(N/2), N/2);
    }
  }
}

int main(){
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  int n;
  cin>>n;
  for(int i=0; i<n; i++){
    for(int j=0; j<n; j++){
      cin>>board[i][j];
    }
  }
  sol(0, 0, n);
  cout<<ans[0]<<'\n'<<ans[1];
}