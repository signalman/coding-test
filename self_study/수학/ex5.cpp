#include <iostream>
#include <cmath>

using namespace std;

void primeNum(int a){
  if(a%2==0){return;}
  else{
    for(int i=2; i<=sqrt(a); i++){
      if(a%i==0){return;}
    }
  }
  cout<<a<<'\n';
}

int main(){
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.tie(nullptr);

  int m,n;
  cin>>m>>n;
  for(int i=m; i<=n; i++){
    if(i==1)continue;
    if(i==2)cout<<2<<'\n';
    primeNum(i);
  }

  return 0;
}