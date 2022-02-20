#include <bits/stdc++.h>
using namespace std;

int m;

int fi(int n){
  if(n==0){return 0;}
  if(n==1){return 1;}
  return fi(n-1)+fi(n-2);
}
int main(){
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin>>m;
  cout<<fi(m);
}