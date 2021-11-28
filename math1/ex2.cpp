#include <iostream>
#include <cmath>
using namespace std;

int main(){
  int N;
  cin>>N;
  int x;
  x=ceil(((3+sqrt(12*N-3))/6));
  cout<<x;
  for(int i=1; i<1000; i++){
    x=ceil(((3+sqrt(12*i-3))/6));
    cout<<"number: "<<i<< "->" << x <<", ";
  }
  return 0;
}