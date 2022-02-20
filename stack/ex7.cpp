#include <bits/stdc++.h>
using namespace std;

int main(){
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  int n;
  cin>>n;
  stack<int> st;
  string s;
  int cur = 1;
  for(int i=0; i<n; i++){
    int a;
    cin>>a;
    if(st.empty()||st.top()<=a){
      while(cur<=a){
        st.push(cur);
        s+="+\n";
        cur++;
      }
      st.pop();
      s+="-\n";
    }
    else{
      cout<<"NO"; return 0;
    }
  }
  for(auto i: s){cout<< i;}
}
