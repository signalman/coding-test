#include <iostream>
#include <cmath>
#include <algorithm>
using namespace std;

int dp[100001];
int main (){
  int n;
  cin>>n;
  for(int i=1; i<=n; i++){
    dp[i]=100000;
  }
  // for(int i=1; i<=sqrt(n); i++){
  //   int a= pow(i,2);
  //   dp[a]=1;
  // }
  dp[0]=0;
  for(int i=1; i<=n; i++){
    for(int j=1; j<=sqrt(i); j++){
      int a= pow(j,2);
      dp[i]=min(dp[i],dp[i-a]+1);
    }
  }
  cout<<dp[n];

}