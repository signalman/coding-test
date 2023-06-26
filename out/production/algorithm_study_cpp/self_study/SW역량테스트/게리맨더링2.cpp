#include<bits/stdc++.h>
using namespace std;

int n;
int A[21][21];
int B[21][21];

int sep(int d1, int d2, int x, int y){
  for(int i=1; i<=n; i++){
    fill(B[i], B[i]+n, 0);
  }
  int mx = -0x7f7f7f7f;
  int mn = 0x7f7f7f7f;
  vector<int> v= {0, };
  v.resize(6);
  for(int i=1; i<=n; i++){
    for(int j=1; j<=n; j++){
      if(i < x + d1 && j <= y && !(i >= x && j >= y - i + x)){
        B[i][j] = 1;
        v[1] += A[i][j];
        continue;
      }
      else if(i <= x + d2 && j > y && !(i >= x && j <= y + i - x)){
        B[i][j] = 2;
        v[2] += A[i][j];
        continue;
      }
      else if(i >= x + d1 && j < y - d1 + d2 && !(i <= x + d1 + d2 && j >= (y - d1 + d2 - (x + d1 + d2 - i)))){
        B[i][j] = 3;
        v[3] += A[i][j];
        continue;
      }
      else if(i > x + d2 && j >= y - d1 + d2 && !(i <= x + d1 + d2 && j <= (y - d1 + d2 + (x + d1 + d2 - i)))){
        B[i][j] = 4;
        v[4] += A[i][j];
        continue;
      }
      else{
        B[i][j] = 5;
        v[5] += A[i][j];
        continue;
      }
    }
  }
  for(int i=1; i<=5; i++){
    mx = max(mx,v[i]);
    mn = min(mn, v[i]);
  }
  return mx-mn;
}
int ans = 0x7f7f7f7f;
int main(){
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin>>n;
  for(int i=1; i<=n; i++){
    for(int j=1; j<=n; j++){
      cin>>A[i][j];
    }
  }
  for(int d1=1; d1<=n; d1++){
    for(int d2=1; d2<=n; d2++){
      for(int x=1; x<=n-d1-d2; x++){
        for(int y=1+d1; y<=n-d2; y++){
          ans = min(ans, sep(d1, d2, x, y));
        }
      }
    }
  }
  cout<<ans;
}