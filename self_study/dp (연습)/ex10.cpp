#include <iostream>
#include <algorithm>
using namespace std;

int arr[1001];
int d[1001];
int p[1001];
int main(){
  int n;
  cin>>n;
  for(int i=1; i<=n; i++){
    cin>>arr[i];
    d[i]=p[i]=1;
  }
  for(int i=1; i<n; i++){
    for(int j=1; j<=i; j++){
      if(arr[i]>arr[j]&&d[i]<d[j]+1){
        d[i]=d[j]+1;
      }
    }
  }
  for(int i=n; i>=1; i--){
    for(int j=n; j>i; j--){
      if(arr[i]>arr[j]&&p[i]<p[j]+1){
        p[i]=p[j]+1;
      }
    }
  }
  int ans=0;
  for(int i=1; i<=n; i++){
    ans=max(ans,d[i]+p[i]);
  }
  cout<<ans-1;
}