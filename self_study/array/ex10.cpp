#include <bits/stdc++.h>
using namespace std;

int arr[100005];
bool vis[2000003];
int n, x;
int cnt = 0;

int main(){
  ios_base::sync_with_stdio(0);
  cin.tie(0); 
  cin>>n;
  for(int i=0; i<n; i++){
    cin>>arr[i];
  }
  cin>>x;
  for(int i=0; i<n; i++){
    if(x-arr[i]>0 && vis[x-arr[i]]) cnt++;
    vis[arr[i]]=1;
  }
  cout<<cnt;
}