#include <bits/stdc++.h>
using namespace std;

int n, m;
int board[501][501];
int mask1[3][2];
int mask2[2][3];
int mx;

int mx_cal1(int sum){
  int a = sum - mask1[0][1]- mask1[2][1];
  a= max(a, sum-mask1[0][0]-mask1[2][0]);
  a= max(a, sum-mask1[1][1]-mask1[1][2]);
  a= max(a, sum-mask1[0][1]-mask1[1][1]);
  a= max(a, sum-mask1[1][0]-mask1[2][0]);
  a= max(a, sum-mask1[0][0]-mask1[1][0]);
  a= max(a, sum-mask1[0][0]-mask1[0][1]);
  a= max(a, sum-mask1[2][0]-mask1[2][1]);
  a= max(a, sum-mask1[0][1]-mask1[2][0]);
  a= max(a, sum-mask1[0][0]-mask1[2][1]);
  return a;
}
int mx_cal2(int sum){
  int a = sum - mask2[0][1]- mask2[0][2];
  a= max(a, sum-mask2[0][0]-mask2[0][2]);
  a= max(a, sum-mask2[0][0]-mask2[0][1]);
  a= max(a, sum-mask2[0][2]-mask2[1][2]);
  a= max(a, sum-mask2[0][0]-mask2[1][0]);
  a= max(a, sum-mask2[1][0]-mask2[1][2]);
  a= max(a, sum-mask2[1][0]-mask2[1][1]);
  a= max(a, sum-mask2[1][1]-mask2[1][2]);
  a= max(a, sum-mask2[0][2]-mask2[1][0]);
  a= max(a, sum-mask2[0][0]-mask2[1][2]);
  return a;
}

int main(){
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  int mx1, mx2;
  int mx3, mx4;
  cin>>n>>m;
  for(int i=0; i<n; i++){
    for(int j=0; j<m; j++){
      cin>>board[i][j];
    }
  }
  for(int i=0; i<n-2; i++){
    for(int j=0; j<m-1; j++){
      int sum = 0;
      for(int k=0; k<3; k++){
        for(int l=0; l<2; l++){
          mask1[k][l] = board[i+k][j+l];
          sum += mask1[k][l];
        }
      }
      mx1 = mx_cal1(sum);
    }
  }
  for(int i=0; i<n-1; i++){
    for(int j=0; j<m-2; j++){
      int sum = 0;
      for(int k=0; k<2; k++){
        for(int l=0; l<3; l++){
          mask2[k][l] = board[i+k][j+l];
          sum += mask2[k][l];
        }
      }
      mx2 = mx_cal2(sum);
    }
  }
  mx = max(mx1, mx2);
  cout<<mx;
}