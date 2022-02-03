#include <bits/stdc++.h>
using namespace std;

int m, n;
vector<int> a(1000001);

int main(){
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin>>m>>n;
  for(int i=0; i<n; i++){
    cin>>a[i];
  }
  sort(a.begin(), a.end(), greater<>());
  do{
    int first = a[0];
    a.push_back(first/2);
    sort(a.begin(), a.end(), greater<>());
  }while(m > n || a[0]/2 > a[m-1]);
  cout<<a[m-1];
}