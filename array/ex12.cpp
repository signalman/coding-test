#include <bits/stdc++.h>
using namespace std;

int n, k;
int a[2][7];
int room=0;

int main(){
  cin>>n>>k;
  for(int i=0; i<n; i++){
      int x, y;
      cin>>x>>y;
      a[x][y]++;
    
  }
  for(int i=0; i<2; i++){
    for(int j=0; j<7; j++){
      room+=(a[i][j]+k-1)/k;
    }
  }
  cout<<room;
}