#include <iostream>
#include <algorithm>
using namespace std;

int p[1004];
int dp[1004];

int main(){
  int n;
  cin>>n;
  for(int i=1; i<=n; i++){
    cin>>p[i];
    }

  for(int i=1; i<=n; i++){
    for(int j=1; j<=i; j++){
      dp[i]=max(p[j]+dp[i-j],dp[i]);
    }
  }
  
  cout<<dp[n]<<'\n';

  return 0;
}