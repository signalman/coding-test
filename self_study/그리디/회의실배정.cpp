#include <bits/stdc++.h>
using namespace std;
#define X first
#define Y second
int n;
vector<pair<int, int>> v;
vector<pair<int, int>> ans;
int main(){
  cin>>n;
  while(n--){
    int a, b;
    cin>>a>>b;
    v.push_back({b, a});
  }
  sort(v.begin(), v.end());
  int t = 0;
  for(int i=0; i<v.size(); i++){
    if(v[i].Y>=t){ans.push_back({v[i].Y,v[i].X}); t=v[i].X;}
  }
  cout<<ans.size()<<'\n';
}