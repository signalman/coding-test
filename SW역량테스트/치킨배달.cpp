#include <bits/stdc++.h>
using namespace std;
#define X first
#define Y second
int n, m;
int board[51][51];
vector<pair<int, int>> home;
vector<pair<int, int>> chi;
vector<bool> mask;
vector<int> ans;
int main(){
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin>>n>>m;
  for(int i=0; i<n; i++){
    for(int j=0; j<n; j++){
      cin>>board[i][j];
      if(board[i][j] == 1)home.push_back({i, j});
      else if(board[i][j] == 2)chi.push_back({i, j});
    }
  }
  for(int i=0; i<chi.size(); i++){
    mask.push_back(1);
  }
  for(int i=0; i<m; i++){
    mask[i] = 0;
  }
  int ret = 0x7f7f7f7f;
  do{
    int ans=0;
    for(int i=0; i<home.size(); i++){
      int dis = 1000;
      int hx = home[i].X;
      int hy = home[i].Y;
        for(int j=0; j<chi.size(); j++){
          if(!mask[j]){
            int cx = chi[j].X;
            int cy = chi[j].Y;
            int d = abs(hx-cx)+abs(hy-cy);
            dis = min(d, dis);
          }
        }
      ans+=dis;
    }
    ret = min(ans, ret);
  }while(next_permutation(mask.begin(), mask.end()));
  cout<<ret;
}