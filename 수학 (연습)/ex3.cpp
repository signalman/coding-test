#include <iostream>
using namespace std;

int main(){
  int X;
  int n;
  int first;
  int last;
  cin>>X;
  for(int i=1;i<5000000;i++){
    if(X<(i*(i-1)/2)+1){
      n=i-1;
      break;
    }
  }
  if(X==1){
    cout<<"1/1";
  }
  else{
    if(n%2==0){
      first=1+ X-(n*(n-1)/2+1);
      last=n-(X-(n*(n-1)/2+1));
    }
    else{
      last=1+ X-(n*(n-1)/2+1);
      first=n-(X-(n*(n-1)/2+1));
    }
  cout<<first<<"/"<<last;
  }
  return 0;
}