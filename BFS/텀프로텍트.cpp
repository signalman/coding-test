#include <bits/stdc++.h>
using namespace std;

int board[100001];
bool check[100001];
queue<int> Q;
int cnt;
int d;
int main(){
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  int t;
  cin>>t;
  while(t--){
    int n;
    cin>>n; 
    while(!Q.empty())Q.pop();
    d =0; cnt =0;
    for(int i=1; i<=n; i++){
      cin>>board[i];
      if(board[i]==i){check[i]=true; d++;}
    }
    for(int i=1; i<=n; i++){
      Q.push(i);
      while(!Q.empty()){
        int cur = Q.front();
        Q.pop();
        int nx = board[cur];
        if(nx == i){break;}
        if(check[nx]){cnt++; continue;}
        Q.push(nx);
      }
    }
    cout<< cnt - d << '\n';
  }
}