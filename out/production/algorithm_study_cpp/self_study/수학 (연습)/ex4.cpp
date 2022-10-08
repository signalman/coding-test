#include <iostream>
#include <cmath>
using namespace std;

int main(){
  long a,b,c;
  int n;
  cin>>a>>b>>c;
  n=ceil((c-a)/double(a-b))+1;
  cout<<n;


  return 0;
}