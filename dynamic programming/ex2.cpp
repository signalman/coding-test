#include <iostream>
#include <algorithm>
using namespace std;

int main(){
  int dp[1005];
  dp[0]=0;
  dp[1]=1;
  dp[2]=2;
  int n;
  cin>>n;
  for(int i=3; i<=n; i++){
    dp[i]=(dp[i-1]+dp[i-2])%10007;
  }
  cout<<dp[n]%10007<<'\n';
  return 0;
}