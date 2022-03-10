#include <bits/stdc++.h>
using namespace std;
#define X first
#define Y second

int arr[102][102];
int n = 3;
int m = 3;
int r, c, k;

void transArr(){
  int mx = max(n, m);
  for(int i=1; i<=mx; i++){
    for(int j=i+1; j<=mx; j++){
      swap(arr[i][j], arr[j][i]);
    }
  }
  swap(n, m);
}

void sortArr(int arr[]){
  int freqArr[102] = {};
  for(int i=1; i<=n; i++){
    if(!arr[i])continue;
    freqArr[arr[i]]++;
  }
  vector<pair<int, int>> v;
  for(int i=1; i<=100; i++){
    if(!freqArr[i])continue;
    v.push_back({freqArr[i], i});
  }
  sort(v.begin(), v.end());
  int j=0;
  for(auto c: v){
    arr[++j] = c.Y;
    arr[++j] = c.X;
  }
  n = max(n, j);
  fill(arr+j+1, arr+n+1, 0);
}


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
    if(m<n){
      transArr();
      transposed = true;
    }
    for(int i=1; i<=m; i++){
      sortArr(arr[i]);
    }
    if(transposed){
      transArr();
    }
    t++;
  }
  cout<<(t > 100 ? -1 : t);
}