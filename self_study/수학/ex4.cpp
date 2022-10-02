#include <iostream>
using namespace std;


int gcd(int a, int b){
  if(a%b==0){return b;}
  return gcd(b, a%b);
}
bool num(int a){
  for(int i=1; i<a; i++){
    if(gcd(a,i)!=1){return false;}
  }
  return true;
}

int main(){
  int n;
  cin>>n;
  int a;
  int g;
  int cnt=0;
  for(int i=0; i<n; i++){
    cin>>a;
    if(num(a)&&a!=1){cnt++;};
  }
  cout<<cnt;
  return 0;
}