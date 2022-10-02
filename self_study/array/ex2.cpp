#include <iostream>
using namespace std;

int main(){
  int max(0);
  int cnt(0);
  int count;
  for(int i=0;i<9;i++){
    cnt++;
    int a;
    cin>>a;
    if(max<a){
      max=a;
      count=cnt;
    }
  }
  cout<<max<<'\n';
  cout<<count<<'\n';

  return 0;
}