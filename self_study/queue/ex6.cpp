#include <bits/stdc++.h>
using namespace std;

queue<int> Q;
int n;
int main(){
  cin>>n;
  for(int i=1; i<=n; i++){
    Q.push(i);
  }
  while(true){
    if(Q.size()==1)break;
    Q.pop();
    int a = Q.front();
    Q.push(a);
    Q.pop();
  }
  cout<<Q.front();
}