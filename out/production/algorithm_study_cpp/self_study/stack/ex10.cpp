#include <bits/stdc++.h>
using namespace std;

stack<int> st;
int n;
int arr[1000001];
vector<int> ans;
int main(){
  cin>>n;
  for(int i=1; i<=n; i++){
    cin>>arr[i];
  }
  st.push(arr[n]);
  ans.push_back(-1);
  for(int i=n-1; i>=1; i--){
    while(!st.empty() && st.top()<=arr[i]){
      st.pop();
    }
    if(st.empty()){ans.push_back(-1); st.push(arr[i]); continue;}
    ans.push_back(st.top());
    st.push(arr[i]);
  }
  for(int i=ans.size()-1; i>=0; i--){
    cout<< ans[i] << ' ';
  }

}