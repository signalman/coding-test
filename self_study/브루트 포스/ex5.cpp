#include <iostream>
#include <algorithm>
using namespace std;

int arr[500][500];
int main(){
  int n, m;
  cin>>n>>m;
  for(int i=0; i<n; i++){
    for(int j=0; j<m; j++){
      cin>>arr[i][j];
    }
  }
  int sum=0;
  for(int i=0; i<n; i++){
    for(int j=0; j<m-4; j++){
      sum=max(sum, arr[i][j]+arr[i][j+1]+arr[i][j+2]+arr[i][j+3]);
    }
  }
  for(int i=0; i<n-1; i++){
    for(int j=0; j<m-1; j++){
      sum=max(sum, arr[i][j]+arr[i][j+1]+arr[i+1][j]+arr[i+1][j+1]);
    }
  }
  for(int i=0; i<n-1; i++){
    for(int j=0; j<m-2; j++){
      sum=max(sum, arr[i][j]+arr[i+1][j]+arr[i+2][j]+arr[i+2][j+1]);
      sum=max(sum, arr[i][j]+arr[i][j+1]+arr[i][j+2]+arr[i][j+3]);
      sum=max(sum, arr[i][j]+arr[i][j+1]+arr[i][j+2]+arr[i][j+3]);
    
    }
  }
  for(int i=0; i<n; i++){
    for(int j=0; j<m-4; j++){
      sum=max(sum, arr[i][j]+arr[i][j+1]+arr[i][j+2]+arr[i][j+3]);
      sum = arr[i][j]+arr[i][j+1]+arr[i][j+2]+arr[i][j+3];
    }
  }
  for(int i=0; i<n; i++){
    for(int j=0; j<m-4; j++){
      sum=max(sum, arr[i][j]+arr[i][j+1]+arr[i][j+2]+arr[i][j+3]);
      sum = arr[i][j]+arr[i][j+1]+arr[i][j+2]+arr[i][j+3];
    }
  }  
}