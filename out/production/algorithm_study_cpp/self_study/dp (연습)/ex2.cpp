#include <iostream>
#include <algorithm>
using namespace std;

int arr[1004][3];
int dp[1004][3];

int main(){
  ios_base::sync_with_stdio(false);
  cin.tie(0);

  int n;
  cin>>n;
  for(int i=0; i<n; i++){
    cin>>arr[i][0];
    cin>>arr[i][1];
    cin>>arr[i][2];
  }
  dp[0][0]=arr[0][0];
  dp[0][1]=arr[0][1];
  dp[0][2]=arr[0][2];
  for(int i=1; i<n; i++){
    dp[i][0]=min(dp[i-1][1]+arr[i][0],dp[i-1][2]+arr[i][0]);
    dp[i][1]=min(dp[i-1][0]+arr[i][1],dp[i-1][2]+arr[i][1]);
    dp[i][2]=min(dp[i-1][0]+arr[i][2],dp[i-1][1]+arr[i][2]);
  }
  cout<<min(min(dp[n-1][0],dp[n-1][1]),dp[n-1][2]);

}