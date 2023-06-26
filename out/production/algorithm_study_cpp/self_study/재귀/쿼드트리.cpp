#include <bits/stdc++.h>
using namespace std;

string s[100];

bool check(int x, int y, int n){
  bool c = true;
  for(int i=x; i<x+n; i++){
    for(int j=y; j<y+n; j++){
      if(s[x][y] != s[i][j]) {c = false; break;}
    }
  }
  return c;
}
void sol(int x, int y, int n){
  if(check(x, y, n)){cout<<s[x][y]; return;}
  cout<<'(';
  for(int i=0; i<2; i++){
    for(int j=0; j<2; j++){
      sol(x+i*(n/2), y+j*(n/2), n/2);
    }
  }
  cout<<')';
}
int main(){
  int n;
  cin>>n;
  for(int i=0; i<n; i++){
    cin>>s[i];
  }
  sol(0,0,n);
}