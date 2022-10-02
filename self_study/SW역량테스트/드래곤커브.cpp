#include <bits/stdc++.h>
using namespace std;

bool board[102][102];
int n;

int main(){
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin>>n;
  while(n--){
    int x, y, d, g;
    cin>>x>>y>>d>>g;
    board[y][x] = true;
    vector<int> v;
    v.push_back(d);
    while(g--){
      int vSize = v.size();
      for(int i=vSize-1; i>=0; i--){
        v.push_back((v[i]+1)%4);
      }
    }
    for(int i=0; i<v.size(); i++){
      if(v[i]==0) x++;
      else if(v[i]==1) y--;
      else if(v[i]==2) x--;
      else if(v[i]==3) y++;
      board[y][x] = true;
    }
  }
  int ans = 0;
  for(int i=0; i<=100; i++){
    for(int j=0; j<=100; j++){
      if(!board[i][j])continue;
      if(board[i+1][j]&&board[i][j+1]&&board[i+1][j+1])ans++;
    }
  }
  cout<<ans;
}
