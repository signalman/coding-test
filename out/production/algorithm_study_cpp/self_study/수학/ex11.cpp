#include <iostream>
#include <vector>
using namespace std;

int gcd(int , int );

int main(){
  int N, S;
  int D;
  cin>>N>>S;
  vector<int> A(N);
  for(int i=0; i<N; i++){
    cin>>A[i];
    A[i]=abs(A[i]-S);
    if(i==0){D=A[0];}
    else{
      D=gcd(D,A[i]);
    }
  }
  cout<<D<<'\n';
  return 0;
}

int gcd(int a, int b){
  if(a>=b){
    if(b==0){return a;}
    else{return gcd(b,a%b);}
  }
  else return gcd(b,a);
}