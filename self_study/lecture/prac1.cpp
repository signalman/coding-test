#include <iostream>
using namespace std;

int main()
{
  int n;
  cin>>n;

  for(int i =1;i<=n;i++){
    int a=i%10;
    if(a==3||a==6||a==9){
      cout<< "* ";
    }
    else {
      cout<< i<< ' ';
    }
  }

  return 0;
}