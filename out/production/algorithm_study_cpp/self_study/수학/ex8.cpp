#include <iostream>
using namespace std;

int fac(int a){
  if(a==0){
    return 1;
  }
  else{
    return a*fac(a-1);
  }
}

int main(){
  int n;
  int cnt=0;
  cin>>n;
  cout<<(n/5)+(n/25)+(n/125);
  return 0;
}