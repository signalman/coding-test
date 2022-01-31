#include <bits/stdc++.h>
using namespace std;

int n, m;
int arr[100004];
int d[100004];
int main(){
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin>>n>>m;
  for(int i=1; i<=n; i++){
    cin>>arr[i];
  }
  d[1] = arr[1];
  d[2] = arr[1] + arr[2];
  for(int i=3; i<=n; i++){
    d[i] = arr[i] + d[i-1];
  }
  while(m--){
    int a, b;
    cin>>a>>b;
    cout<<d[b] - d[a-1]<<'\n';
  }
}