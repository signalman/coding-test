#include <iostream>
using namespace std;

int main(){
  int a,b;
  cin>>a>>b;
  int min;
  if(a>=b){min=b;}
  else {min=a;}
  int gcd=0;
  for(int i=1; i<=min; i++){
    if(a%i+b%i==0){
      gcd=i;
    }
  }
  cout<<gcd<<'\n';
  cout<<gcd*(a/gcd)*(b/gcd);
}