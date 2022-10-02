#include <iostream>
using namespace std;

long long arr[201][201];
#define Moduler 1000000000;

int main(){
  int n, k;
  cin>>n>>k;
  for(int i=1; i<=n; i++){
    for(int j=1; j<=k; j++){
      arr[i][1]=1;
      arr[1][j]=j;
    }
  }
  for(int i=2; i<=n; i++){
    for(int j=2; j<=k; j++){
      arr[i][j]=(arr[i-1][j]+arr[i][j-1])%Moduler;
    }
  }
  cout<<arr[n][k]%Moduler;
}