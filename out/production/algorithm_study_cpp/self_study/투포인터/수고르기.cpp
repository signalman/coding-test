#include <bits/stdc++.h>
using namespace std;

int a[100005];
int n, m;
int mn = 0x7fffffff;

int main(){
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin>>n>>m;
  for(int i=0; i<n; i++){
    cin>>a[i];
  }
  sort(a, a+n);
  int st, en = 0;

  for(int st = 0; st<n; st++){
    while(en < n && a[en] - a[st] < m) en++;
    if(en == n) break;
    mn = min(mn, a[en] - a[st]);
  }
  cout<<mn;
}