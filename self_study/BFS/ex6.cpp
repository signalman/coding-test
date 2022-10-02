#include <bits/stdc++.h>
using namespace std;
int board[102][102];
int vis[102];
queue<int> Q;
int n, m;
int ans = 0;
void bfs(int n){
  Q.push(n);
  while(!Q.empty()){
  int cur = Q.front(); Q.pop();
  vis[cur]=1;
  for(int i=1; i<102; i++){   
    if(board[cur][i]==1&&vis[i]==0){Q.push(i); vis[i]=1; ans++;}
  }
  }
}
int main(){
  int a,b;
  cin>>n>>m;
  for(int i=0; i<m; i++){
    cin>>a>>b;
    board[a][b]=board[b][a]=1;
  }
  bfs(1);
  cout<<ans;
}