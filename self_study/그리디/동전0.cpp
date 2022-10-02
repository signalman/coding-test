#include <bits/stdc++.h>
using namespace std;

int a[15];
int main(){
  int ans = 0;
  int n, k;
  cin>>n>>k;
  for(int i=0; i<n; i++){cin>>a[i];}
  for(int i=n-1; i>=0; i--){
    ans += k/a[i];
    k %= a[i];
  }
  cout<<ans;
}