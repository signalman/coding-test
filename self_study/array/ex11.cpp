#include <bits/stdc++.h>
using namespace std;

int n;
int arr[105];
int v;
int cnt = 0;

int main(){
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin>>n;
  for(int i=0; i<n; i++){
    cin>>arr[i];
  }
  cin>>v;
  for(int i=0; i<n; i++){
    if(arr[i]==v) cnt++;
  }
  cout<<cnt;

}