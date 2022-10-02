#include <bits/stdc++.h>
using namespace std;
int board[200000];
queue<int> Q;
int n,k;
int main(){
  cin>>n>>k;
  fill(board,board+100001,-1);
  board[n]=0;
  Q.push(n);
  while(!Q.empty()){
    if(board[k]!=-1){cout<<board[k]; return 0;}
    int dx[3] = {1, -1, Q.front()};
    int cur = Q.front(); Q.pop();
    for(int i=0; i<3; i++){
      int nx = cur + dx[i];
      if(board[nx]>=0 || nx < 0)continue;
      board[nx]=board[cur]+1;
      Q.push(nx);
    }
  }
}