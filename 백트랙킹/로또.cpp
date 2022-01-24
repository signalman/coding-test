#include <bits/stdc++.h>
using namespace std;

int n;
int arr[20];
int ans[20];
bool isused[20];

void sol(int k){
  if(k==6){
    for(int i=0; i<6; i++){
      cout<<ans[i]<<' ';
    }
    cout<<'\n';return;
  }
  for(int i=0; i<n; i++){
    if(!isused[i]&&ans[k-1]<arr[i]){
      ans[k] = arr[i];
      isused[i] = true;
      sol(k+1);
      isused[i] = false;
    }
  }
}

int main(){
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  while(true){
    cin>>n;
    if(n==0){break;}
    for(int i=0; i<n; i++){
      cin>>arr[i];
    }
    sol(0);
    cout<<'\n';
    fill(arr, arr+n, 0);
    fill(ans, ans+n, 0);
    fill(isused, isused+n, 0);
  }
  return 0;
}