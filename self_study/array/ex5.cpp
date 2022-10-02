#include <iostream>
using namespace std;

int main(){
  int N;
  int max=0;
  int sum=0;
  int test[1000];
  cin>>N;
  for(int i=0; i<N; i++){
    cin>>test[i];
    if(max<test[i]){
      max=test[i];
    }
    sum+=test[i];
  }
  
  cout<<  sum*100/double(max*N) << "\n";
  return 0;
}