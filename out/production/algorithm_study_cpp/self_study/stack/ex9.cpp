#include <bits/stdc++.h>
using namespace std;

#define X first
#define Y second
int arr[80005];
stack<pair<int, int>> st;
long long cnt = 0 ;
int main(){
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  int n;
  cin>>n;
  for(int i=n; i>=1; i--){
    cin>> arr[i];
  }
  st.push({1000000001,0});
  for(int i=1; i<=n; i++){
    while(!st.empty()&&st.top().X<arr[i]){
      st.pop();
    }
    cnt+= i - st.top().Y - 1;
    st.push({arr[i], i});
  }
  cout<<cnt;
}