#include <iostream>
#include <algorithm>
using namespace std;


int p[1005];
int dp[1005];

int main(){
  int n;
  cin>>n;
  for(int i=1; i<=n; i++){
    cin>>p[i];
  }
  dp[0]=0;
  dp[1]=p[1];
  for(int i=1; i<=n; i++){
    dp[i]=10000;
    for(int j=1; j<=i; j++){
      dp[i]=min(dp[i],dp[i-j]+p[j]);
    }
  }
  cout<<dp[n]<<'\n';

  return 0;
}