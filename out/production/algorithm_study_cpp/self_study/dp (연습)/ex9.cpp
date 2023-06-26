#include <iostream>
using namespace std;

int arr[1001];
int dp[1001];
int main(){
  int n;
  cin>>n;
  for(int i=1; i<=n; i++){
    cin>>arr[i];
    dp[i]=1;
  }
  int MAX=0;
  for(int i=1; i<=n; i++){
    for(int j=1; j<i; j++){
      if(arr[i]<arr[j]&&dp[i]<dp[j]+1){
        dp[i]=dp[j]+1;
      }
    }
    MAX=max(dp[i],MAX);
  }
  cout<<MAX;


}