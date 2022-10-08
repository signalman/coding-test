#include <bits/stdc++.h>
using namespace std;

int board[3200][3200];
int ans[3];

bool check(int x, int y, int N){
  bool c = true;
  int first = board[x][y];
  for(int i=x; i<x+N; i++){
    for(int j=y; j<y+N; j++){
      if(first != board[i][j]) {c = false; break;}
    }
  }
  return c;
}
void sol(int x, int y, int N){
  if(check(x, y, N)){ans[board[x][y]+1]++; return;}
  for(int i=0; i<3; i++){
    for(int j=0; j<3; j++){
      sol(x+i*N/3, y+j*N/3, N/3);
    }
  }
}

int main(){
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  int N;
  cin>>N;
  for(int i=0; i<N; i++){
    for(int j=0; j<N; j++){
      cin>>board[i][j];
    }
  }
  sol(0, 0, N);
  for(int i=0; i<3; i++){
    cout<<ans[i]<<'\n';
  }
}