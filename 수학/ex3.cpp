#include <iostream>
#include <cmath>
using namespace std;

int gcd(int x, int y){
  if(x%y==0){  return y;  }
  return gcd(y,x%y);
}
int main(){
  ios_base::sync_with_stdio(false);
  cout.tie(nullptr);
  cin.tie(nullptr);

  int t;
  int GCD;
  cin>>t;
  for(int i=0; i<t; i++){
    int a,b;
    cin>>a>>b;
    if(a>=b){GCD=gcd(a,b);}
    else{GCD=gcd(b,a);}
    cout<<GCD*(a/GCD)*(b/GCD)<<'\n';
  }
}