#include <iostream>
#include <algorithm>
using namespace std;

int e, s, m;
int main(){
  cin>>e>>s>>m;
  int k=1;
  while(true){
    if((k-e)%15==0&&(k-s)%28==0&&(k-m)%19==0){
      break;
    }
    k++;
  }
  cout<<k;
}