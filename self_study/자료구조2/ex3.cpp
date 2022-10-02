#include <iostream>
#include <stack>
#include <vector>
using namespace std;

int main(){
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  
  int N;
  cin>>N;
  vector<int> arr(N);
  vector<int> ret(N);
  stack<int> stk;
  for(int i=0; i<N; i++){
    cin>>arr[i];
  }
  for(int i=N-1; i>=0; i--){
    if(stk.empty()){
      ret[i]=-1;
      stk.push(arr[i]);
    }
    else{
      if(arr[i]<stk.top()){
        ret[i]=stk.top();
        stk.push(arr[i]);
      }
      else{
        while(!stk.empty()&&arr[i]>=stk.top()){
          stk.pop();
        }
        if(stk.empty()){ret[i]=-1;stk.push(arr[i]);}
        else{ret[i]=stk.top();stk.push(arr[i]);}
      }
    }
  }
  for(auto a: ret){
    cout<< a <<" ";
  }
  return 0;
}