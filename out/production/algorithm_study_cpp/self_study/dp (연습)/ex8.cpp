#include <iostream>
#include <algorithm>
using namespace std;

int arr[1001];
int dp[1001];
int main(){
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  int n;
  cin>>n;
  for(int i=0; i<n; i++){
    cin>>arr[i];
  }
  
  for(int i=0; i<n; i++){
    dp[i]=arr[i];
    for(int j=0; j<=i; j++){
      if(arr[i]>arr[j]&&dp[i]<dp[j]+arr[i])
        {  dp[i]=dp[j]+arr[i];  }
    }
  }
  int ans=0;
  for(int i=0; i<n; i++){
    ans=max(dp[i],ans);
  }
  cout<<ans;
}