#include <bits/stdc++.h>
using namespace std;

int board[200000];
int n, k;
queue<int> Q;
void bfs(int n, int k){
  if(n==k){cout<<0; return;}
  board[n] = 1;
  Q.push(n);
  while(!Q.empty()){
    int cur = Q.front();
    int dx[3] = {1, -1, cur};
    Q.pop();
    for(int i=0; i<3; i++){
      int nx = cur + dx[i];
      if(nx==k) {cout<<board[cur]; return;}
      if(nx<0 || nx>200000)continue;
      if(board[nx]>0)continue;
      Q.push(nx);
      board[nx] = board[cur] + 1;
    }
  }
}
int main(){
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin>>n>>k;
  bfs(n, k);
}