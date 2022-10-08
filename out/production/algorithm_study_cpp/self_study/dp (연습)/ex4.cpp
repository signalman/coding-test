#include <iostream>
using namespace std;
#define Moduler 10007;
long long dp[1001][10];
int main(){
  int n;
  cin>>n;
  for(int i=0; i<10; i++){
    dp[0][i]=1;
  }
  for(int i=1; i<n; i++){
    for(int j=0; j<10; j++){
      for(int k=j; k>=0; k--){
        dp[i][j]+=(dp[i-1][k])%Moduler;
      }
    }
  }
  int sum=0;
  for(int i=0; i<10; i++){
    sum=(sum+dp[n-1][i])%Moduler;
  }
  cout<<sum;

}