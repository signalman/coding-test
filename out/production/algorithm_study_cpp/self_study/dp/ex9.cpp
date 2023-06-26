#include <iostream>
#include <algorithm>
using namespace std;

int arr[100001];
int dp[100001];
int ans;
int main(){
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  int n;
  cin>>n;

  for(int i=0; i<n; i++){
    cin>>arr[i];
  }
  dp[0]=ans=arr[0];
  for(int i=1; i<n; i++){
    dp[i]=max(arr[i],dp[i-1]+arr[i]);
    ans=max(ans,dp[i]);
  }
  cout<<ans;

  return 0;
}