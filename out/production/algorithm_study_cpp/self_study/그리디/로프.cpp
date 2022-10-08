#include <bits/stdc++.h>
using namespace std;

int n;
int arr[100005];
bool cmp(int a, int b){
  return a>b;
}
int main(){
  cin>>n;
  for(int i=1; i<=n; i++){
    cin>>arr[i];
  }
  sort(arr+1, arr+n+1, cmp);
  int mx = 0;
  for(int i=1; i<=n; i++){
    mx = max(mx, arr[i]*i);
  }
  cout<<mx;
}