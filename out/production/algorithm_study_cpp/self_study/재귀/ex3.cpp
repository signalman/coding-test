#include <bits/stdc++.h>
using namespace std;

int func(int N, int r, int c){
  if(N==0)return 0;
  int half = pow(2,N-1); 
  if(r < half && c< half) return func(N-1, r, c);
  if(r < half && c >= half) return half*half + func(N-1, r, c-half);
  if(r >= half && c < half) return 2*half*half + func(N-1, r-half, c);
  return 3*half*half + func(N-1, r-half, c-half);  
}
int main(){
  ios::sync_with_stdio(0);
  cin.tie(0);
  int n, r, c;
  cin>> n>> r>>c;
  cout<<func(n,r,c);
}