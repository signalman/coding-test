#include <iostream>
#include <algorithm>
using namespace std;

#define Moduler 9901
long long dp[100001][3];

int main(){
  int n;
  cin>>n;
  dp[1][0]=1;
  dp[1][1]=1;
  dp[1][2]=1;
  for(int i=2; i<=n; i++){
    dp[i][0]=(dp[i-1][0]+dp[i-1][1]+dp[i-1][2])%Moduler;
    dp[i][1]=(dp[i-1][0]+dp[i-1][2])%Moduler;
    dp[i][2]=(dp[i-1][1]+dp[i-1][0])%Moduler;
  }
  cout<< (dp[n][0]+dp[n][1]+dp[n][2])%Moduler;

}