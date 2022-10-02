#include <iostream>
using namespace std;
int main(){
  int T;
  cin>>T;
  for(int i=0;i<T;i++){
    int a, b;
    cin>> a>>b;

    cout<<"Case #"<<i+1<<": "<<a << " + " << b <<" = " << a+b <<'\n';

  }

  return 0;
}