#include <iostream>
using namespace std;

int main(){
  int n, m;
  int cntFive=0;
  int cntTwo=0;
  int ret;
  cin>>n>>m;
  for(long long i=5; i<=n; i*=5){
    cntFive+=n/i;//5+1
    cntFive-=m/i;//2
    cntFive-=(n-m)/i;//2
  }
  for(long long i=2; i<=n; i*=2){
    cntTwo+=n/i;
    cntTwo-=m/i;
    cntTwo-=(n-m)/i;
  }
  ret=cntFive<cntTwo? cntFive:cntTwo;
  cout<<ret;
}