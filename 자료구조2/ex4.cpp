#include <iostream>
#include <stack>
#include <vector>
using namespace std;

int main(){
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  int N;
  cin>>N;
  stack<int> s,d;
  vector<int> A(N), NGF(N), B(1000005);
  for(int i=0; i<N; i++){
    cin>>A[i];
    B[A[i]]++;
  }
  for(int i=N-1; i>=0; i--){
    int cnt=1;
    while(!s.empty()&&s.top()<=B[A[i]]){
      d.push(s.top());
      s.pop();
      cnt++;
    }
    if(s.empty()){NGF[i]=-1;}
    else{NGF[i]=A[i+cnt];}
    while(!d.empty()){s.push(d.top());d.pop();}
    s.push(B[A[i]]);
  }
  for(auto i=0; i<N; i++){
    cout<<NGF[i]<<" ";
  }
}