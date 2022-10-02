#include <iostream>
#include <algorithm>
using namespace std;

int arr[100001];
int d[100001];
int p[100001];

int dp_max=-1000;
int main(){
  ios_base::sync_with_stdio(false);
  cin.tie(0);

  int n;
  cin>>n;
  for(int i=1; i<=n; i++){
    cin>>arr[i];
  }
  int sum=0;
  for(int i=1; i<=n; i++){
    if(n==1){dp_max=arr[1]; break;}
    int d_max=-1000;
    int p_max=-1000;  
    for(int j=i-1; j>=0; j--){
      d[i]+=arr[j];
      d_max=max(d_max,d[i]);
    }
    for(int j=i+1; j<=n; j++){
      p[i]+=arr[j];
      p_max=max(p_max, p[i]);
    }
    sum+=arr[i];
    dp_max=max(sum,max(dp_max,(p_max+d_max)));
  }
  cout<<dp_max;
  
}