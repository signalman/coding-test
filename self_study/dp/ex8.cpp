#include <iostream>
#include <algorithm>
#include <stack>
using namespace std;

int a[1002];
int dp[1002];
stack<int> st;
int main(){
  int n;
  int sum=0;
  cin>>n;
  for(int i=0; i<n; i++){
    cin>>a[i];
    dp[i]=1;
  }
  for(int i=0; i<n; i++){
    for(int j=0; j<i; j++){
      if(a[i]>a[j]){
        dp[i]=max(dp[i],dp[j]+1);
      }
    }
    sum=max(sum,dp[i]);
  }
  cout<<sum<<'\n';
  for(int i=n-1; i>=0; i--){
    if(dp[i]==sum){
      st.push(a[i]);
      sum--;
      continue;
    }
  }
  while(!st.empty()){
    cout<<st.top()<<' ';
    st.pop();
  }



  return 0;
}