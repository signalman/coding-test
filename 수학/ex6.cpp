#include <iostream>
#include <cmath>
#include <string>

using namespace std;

bool primeNum(int a){
  int cnt=0;
  if(a>2&&a%2==0){return false;}
  for(int i=1; i<=sqrt(a); i++){
    if(a%i==0){cnt++;}
  }
  if(cnt==1){return true;}
  return false;
}
int main(){
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.tie(nullptr);

  int n=1;
  while(n){
    cin>>n;
    string s="";
    for(int i=2; i<=n/2; i++){
      if(primeNum(i)&&primeNum(n-i)){
        cout<< n << " = " << i << " + " << n-i <<'\n';
        break;
      }
    }
  }

  // for(int i=1; i<200; i++){
  //   if(primeNum(i)){cout<<i<<": prime"<<'\n';}
  //   else cout<<i<<": no!"<<'\n';
  // }



}