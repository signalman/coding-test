#include <bits/stdc++.h>
using namespace std;

#define X first
#define Y second
int board1[51][51];
int board2[51][51];
int n,m;
vector<pair<int, int>> chk;
vector<pair<int, int>> house;
int main(){ 
  cin>>n>>m;
  for(int i=0; i<n; i++){
    for(int j=0; j<n; j++){
      cin>>board1[i][j];
      if(board1[i][j] == 1)
        house.push_back({i, j});
      
      if(board1[i][j] == 2)
        chk.push_back({i, j});
    }
  }
  vector<int> brute(chk.size(), 1);
  fill(brute.begin(), brute.begin() + chk.size() - m, 0);
  int mn = 0x7f7f7f7f;
  do{
    int dist = 0;
    for(auto h: house){
      int tmp = 0x7f7f7f7f;
      for(int i=0; i<chk.size(); i++){
        if(brute[i] == 0) continue;
        tmp = min(tmp, abs(chk[i].X - h.X) + abs(chk[i].Y - h.Y));
      }
      dist += tmp;
    }
    mn = min(mn, dist);
  }while(next_permutation(brute.begin(), brute.end()));
  cout<<mn;
}