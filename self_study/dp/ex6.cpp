#include <iostream>
#include <algorithm>
using namespace std;

#define Moduler 1000000000
typedef long long ll;
long long dp[101][10];

int main(){
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int n;
  cin>>n;


  for (int i = 1; i <= 9; i++)
    {dp[1][i] = 1;}
  dp[1][0] = 0;

  for(int i=2; i<=n; i++){
    for(int j=0; j<=9; j++){
      if(j==0){
        dp[i][j]=(dp[i-1][j+1])%Moduler;
      }
      else if(j==9){
        dp[i][j]=(dp[i-1][j-1])%Moduler;
      }
      else{
        dp[i][j]=(dp[i-1][j+1]+dp[i-1][j-1])%Moduler;
      }
    }
  }
  ll ans=0;
  for(int i=0; i<10; i++){
    ans= ans+dp[n][i];
  }
  cout<<ans%Moduler;

}