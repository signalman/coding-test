#include <iostream>
using namespace std;



int hanCnt(int n);
int main(){
  int n;
  cin>>n;
  cout<<hanCnt(n);

  return 0;
}
int hanCnt(int n){
  int cnt=0;
  if(n<100){
    cnt+=n;
  }
  else if( n>=100 && n<=1000){
    cnt=99;
    for(int i=100; i<=n; i++){
      if((i/100+i%10)==2*((i%100)/10)){
        cnt++;
      }
    }

  }
  return cnt;
}