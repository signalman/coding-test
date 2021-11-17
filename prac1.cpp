#include <iostream>
using namespace std;

int main(){
  int *a;
  int b= 10;
  a=&b;
  cout << *a <<endl;
  cout << a <<endl;
  

  return 0;
}