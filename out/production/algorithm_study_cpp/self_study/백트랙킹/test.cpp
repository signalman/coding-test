#include <bits/stdc++.h>
using namespace std;

#define X first
#define Y second
typedef long long ll;
int n,m;
int board[102][102];
bool vis[102];
int cnt=0;
queue<pair<int, int>> Q;

void bfs(int n){
  
  while(!Q.empty()){

  }

}
int main(){
  cin>>n>>m;
  for(int i=0; i<m; i++){
    int a, b;
    cin>>a>>b;
    board[a][b] = 1;
    board[b][a] = 1;
  }
  bfs(1);
}