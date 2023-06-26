#include <bits/stdc++.h>
using namespace std;

int arr[304];
int d[304];
int main(){
  int n;
  cin>>n;
  for(int i=1; i<=n; i++){
    cin>>arr[i];
  }
  d[1] = arr[1];
  d[2] = arr[1]+arr[2];
  d[3] = max(arr[1]+arr[3], arr[2]+arr[3]);
  for(int i=4; i<=n; i++){
    d[i] = max(arr[i]+arr[i-1]+d[i-3], arr[i]+d[i-2]);
  }
  cout<<d[n];
}