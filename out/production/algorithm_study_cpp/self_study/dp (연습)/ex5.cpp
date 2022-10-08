#include <iostream>
#include <algorithm>
using namespace std;

int dp[2][100001];
int arr[2][100001];
int main(){
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  
  int test_case; 
  cin>>test_case;
  for(int i=0; i<test_case; i++){
    int n;
    cin>>n;
    for(int j=0; j<2; j++){
      for(int k=0; k<n; k++){
        cin>>arr[j][k];
      }
    }
    dp[0][0]=arr[0][0];
    dp[1][0]=arr[1][0];
    dp[0][1]=arr[0][1]+arr[1][0];
    dp[1][1]=arr[1][1]+arr[0][0];
    for(int j=0; j<2; j++){
      for(int k=2; k<n; k++){
        dp[0][k]=max(dp[1][k-2]+arr[0][k], dp[1][k-1]+arr[0][k]);
        dp[1][k]=max(dp[0][k-2]+arr[1][k], dp[0][k-1]+arr[1][k]);
      }
    }
    cout<<max(dp[0][n-1],dp[1][n-1])<<'\n';
  }

  
}