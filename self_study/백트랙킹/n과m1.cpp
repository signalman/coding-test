#include <bits/stdc++.h>
using namespace std;

int n, m;
int board[10];
bool isused[10];
int ans[10];

void sol(int k){
  if(k==m){
    for(int i=0; i<m; i++){
      cout<<ans[i]<<' ';
  }cout<<'\n';return;
}
int cur = 0;
  for(int i=0; i<n; i++){
    if(cur!=board[i]&&board[i]>=ans[k-1]){
      ans[k] = board[i];
      cur = ans[k];
      sol(k+1);
      
    }
  }
}

int main(){
  cin>>n>>m;
  for(int i=0; i<n; i++){
    cin>>board[i];
  }
  sort(board, board+n);
  sol(0);


}