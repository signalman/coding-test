#include <iostream>
#include <algorithm>
using namespace std;

int dp[31];
int main(){
  int n;
  cin>>n;
  dp[0]=0;
  dp[1]=2;
  dp[2]=3;
  dp[3]=8;
  for(int i=4; i<=n; i++){
    dp[i]=dp[i-2]*3+dp[i-3];
  }
  for(int i=1; i<=n; i++){
  if(i%2!=0){dp[i]=0;}}
  cout<<dp[n];
}