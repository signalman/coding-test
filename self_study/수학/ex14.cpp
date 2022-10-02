#include <iostream>
using namespace std;

void go(int a){
  if(a==0){return;}
  if(a%2==0){
    go(-(a/2));
    cout<<0;
  }
  else{
    if(a>0){go(-(a/2));}
    else{go((-a+1)/2);}
    cout<<1;
  }
}
int main(){
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);

  int n;
  cin>>n;
  if(n==0){cout<<0<<'\n';}
  else {go(n);}
  return 0;
}
