#include <iostream>
using namespace std;

typedef long long ll;
#define Moduler 1000000009

ll dp[1000001];
int main(){
  ios_base::sync_with_stdio(false);
  cin.tie(0);

  int test_case;
  int n;
  cin>>test_case;
  dp[1]=1;
  dp[2]=2;
  dp[3]=4;
  for(int i=0; i<test_case; i++){
    cin>>n;
    for(int j=4; j<=n; j++){
      dp[j]=(dp[j-3]+dp[j-2]+dp[j-1])%Moduler;
    }
    cout<<dp[n]%Moduler<<'\n';
  }
  
}