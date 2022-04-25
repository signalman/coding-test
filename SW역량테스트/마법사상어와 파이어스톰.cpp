#include <bits/stdc++.h>
using namespace std;

//돌리고 인접면이 2개 이하인 칸에대해 1이 줄어든다
int n, q;
int MAP[65][65];
queue<int> level;
int main(){
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin>>n>>q;
  for(int i=0; i<(1<<n); i++){
    for(int j=0; j<(1<<n); j++){
      cin>>MAP[i][j];
    }
  }
  for(int i=0; i<q; i++){
    int t;
    cin>>t;
    level.push(t);
  }

  while(!level.empty()){
    int cur = level.front();
    level.pop();

  }
  return 0;
}