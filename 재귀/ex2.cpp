#include <bits/stdc++.h>
using namespace std;

void func(int a, int b, int n){
  if(n==1){
    cout<<a<< ' ' << b << '\n';
    return;
  }
  func(a, 6-a-b, n-1);
  cout<< a<< ' ' << b << '\n';
  func(6-a-b, b, n-1);

}

int main(){
  ios::sync_with_stdio(0);
  cin.tie(0);
  int k;
  cin>>k;
  int c = pow(2,k);
  cout<< c-1 << '\n';
  func(1, 3, k);
}