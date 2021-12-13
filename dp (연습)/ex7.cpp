#include <iostream>
#include <algorithm>
using namespace std;

int dp[501][501];
int arr[501][501];
int main(){
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  int n;
  cin>>n;
  for(int i=1; i<=n; i++){
    for(int j=1; j<=i; j++){
      cin>>arr[i][j];
    }
  }
  int sum=0;
  for(int i=1; i<=n; i++){
    for(int j=1; j<=i; j++){
      dp[i][j]=arr[i][j]+max(dp[i-1][j-1],dp[i-1][j]);
    }
  }
  for(int j=1; j<=n; j++){
    sum=max(sum, dp[n][j]);
  }
  cout<<sum;

}