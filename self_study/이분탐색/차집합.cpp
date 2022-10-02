#include <bits/stdc++.h>
using namespace std;

int n, m;
int a[500001];
int b[500001];
int cnt;
vector<int> v;
int main(){
  cin>>n>>m;
  for(int i=0; i<n; i++){
    cin>>a[i];
  }
  for(int i=0; i<m; i++){
    cin>>b[i];
  }
  sort(a, a+n);
  sort(b, b+m);
  for(int i=0; i<n; i++){
    if(binary_search(b, b+m, a[i]) == 0) {cnt++; v.push_back(a[i]);}
  }
  cout<<cnt<<'\n';
  if(!v.empty()){for(auto i : v) cout<<i<<' ';}
}