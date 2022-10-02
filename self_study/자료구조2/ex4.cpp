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
  vector<int> input(N), NGF(N), F(1000005);
  for(int i=0; i<N; i++){
    cin>>input[i];
    F[input[i]]++;
  }
  for(int i=N-1; i>=0; i--){
    int cnt=1;
    while(!s.empty()&&s.top()<=F[input[i]]){
      d.push(s.top());
      s.pop();
      cnt++;
    }
    if(s.empty()){NGF[i]=-1;}
    else{NGF[i]=input[i+cnt];}
    while(!d.empty()){s.push(d.top());d.pop();}
    s.push(F[input[i]]);
  }
  for(auto i=0; i<N; i++){
    cout<<NGF[i]<<" ";
  }
}