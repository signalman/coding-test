#include <bits/stdc++.h>
using namespace std;

stack<int> st;
int main(){
  int k;
  cin>>k;
  while(k--){
    int num;
    cin>>num;
    if(num==0){
      st.pop();
    }
    else{
      st.push(num);
    }
  }
  int sum = 0;
  while(!st.empty()){
    sum += st.top();
    st.pop();
  }
  cout<<sum;
}