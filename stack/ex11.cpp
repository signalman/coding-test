#include <bits/stdc++.h>
using namespace std;

#define X first
#define Y second
stack<pair<int, int>> st;
int arr[500001];
int cnt;
int main(){
  int n;
  cin>>n;
  for(int i=0; i<n; i++){
    cin>>arr[i];
  }
  cnt = n-1;
  st.push({arr[0], 0});
  for(int i=1; i<n; i++){
    while(!st.empty()&&st.top().X<=arr[i]){
      if(i-st.top().Y>1)cnt++;
      st.pop();
    }
    if(!st.empty()&&i-st.top().Y>1)cnt++;
    st.push({arr[i], i});
  }
  cout<<cnt;
}