#include <iostream>
#include <queue>

using namespace std;

int main(){
  int n,k;
  cin>>n>>k;
  queue<int> que1;
  queue<int> que2;
  for(int i=1; i<=n; i++){
    que1.push(i);
  }
  while(!que1.empty()){
    for(int j=0; j<k-1; j++){
      que1.push(que1.front());
      que1.pop();
    }
    que2.push(que1.front());
    que1.pop();
  }
  cout<<"<";
  while(que2.size()-1!=0){
    cout<<que2.front()<<", ";
    que2.pop();
  }
  cout<<que2.front()<<">";

  return 0;
}