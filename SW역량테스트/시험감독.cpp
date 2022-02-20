#include <bits/stdc++.h>
using namespace std;

int n;
int b, c;
long a[1000001];
long cnt;

int main(){
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin>>n;
  for(int i=0; i<n; i++){
    cin>>a[i];
  }
  cin>>b>>c;
  cnt += n;
  for(int i=0; i<n; i++){
    int dif = a[i] - b;
    if(dif < 0) continue;
    else if( dif == 0 )continue;
    else{
      if(dif - c < 0) {cnt += 1; continue;}
      else if(dif - c ==0){cnt += 1; continue;}
      else{
        if(dif % c != 0) cnt += dif/c + 1;
        else{
        cnt += dif / c;}
      }
    }
  }
  cout<<cnt;
}