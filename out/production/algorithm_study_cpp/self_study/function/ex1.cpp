//call-by-value
//call--by-reference

#include <iostream>
using namespace std;

int fac(int x){
  if(x<2) return 1;
  return x*fac(x-1);
  
}
int main()
{ 
  cout<<fac(5);
}
