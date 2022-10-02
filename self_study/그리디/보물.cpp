#include <bits/stdc++.h>
using namespace std;


int a[51];
int b[51];
bool cmp(int a, int b){
  return a>b;
}
int main(){
  int n;
  cin>>n;
  for(int i=0; i<n; i++){
    cin>>a[i];
  }
  for(int i=0; i<n; i++){
    cin>>b[i];
  }
  sort(a, a+n);
  sort(b, b+n, cmp);
  int ans = 0;
  for(int i=0; i<n; i++){
    int val = a[i] * b[i];
    ans += val;
  }
  cout<<ans;
}