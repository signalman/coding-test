#include <iostream>
#include <algorithm>
using namespace std;

int dp[31];
int main(){
  int n;
  cin>>n;
  dp[2]=3;
  for(int i=2; i<=15; i++){
    dp[i*2]+=dp[2*(i-1)]+2;
    for(int j=i-1; j>=1; j--){
      dp[i*2]+=(dp[2*j])*2;
    }
  }
  cout<<dp[n];
}