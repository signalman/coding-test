#include <bits/stdc++.h>
using namespace std;

int arr[102][102];
int n = 3;
int m = 3;
int r, c, k;

int main(){
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin>>r>>c>>k;
  for(int i=1; i<=3; i++){
    for(int j=1; j<=3; j++){
      cin>>arr[i][j];
    }
  }
  int t = 0; 
  while( t<=100 && arr[r][c] != k){
    bool transposed = false;
    if(n>m){
      transArr();
      transposed = true;
    }
    sortArr();
    if(transposed){
      transArr();
    }
    t++;
  }
  cout<<(t > 100 ? -1 : t);
}