#include <iostream>
using namespace std;

int main(){
  int T;
  int a;
  int b;
  cin>>T;
  for(int i=0; i<T; i++){
    cin>> a >> b;
    int sum = a+b;
    cout<<sum<<endl;
  }

  return 0;
}