#include <iostream>
using namespace std;

int main(){
  int t;
  cin>>t;

  int a,b;
  for(int i=0; i<t; i++){
    int gcd;
    cin>>a>>b;
    if(a>=b){
      for(int j=1; j<=b; j++){
        if(b%j==0&&a%j==0){gcd=j;}
      }
    }
    else{
      for(int j=1; j<=b; j++){
        if(b%j==0&&a%j==0){gcd=j;}
      }
    }
    cout<<gcd*(a/gcd)*(b/gcd)<<'\n';
  }

}