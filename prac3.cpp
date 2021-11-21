#include <iostream>
using namespace std;

int main(){
  int n;

  cin>>n;

  for(int i=0; i<n; i++){
    for(int j=1; j<=i*2+1; j++){
      cout<<j<<" ";
    }
    printf("\n");
  }

  return 0;
}