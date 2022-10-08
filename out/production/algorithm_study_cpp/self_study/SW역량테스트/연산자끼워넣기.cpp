#include <bits/stdc++.h>
using namespace std;

int n;
int a[15];
int oper[4]; // + - * /
vector<int> v;
vector<char> c;

int main(){
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin>>n;
  for(int i=0; i<n; i++){
    cin>>a[i];
  }  
  for(int i=0; i<4; i++){
    cin>>oper[i];
    for(int k=0; k<oper[i]; k++){
      v.push_back(i);
      if(i==0) c.push_back('+');
      else if(i==1) c.push_back('-');
      else if(i==2) c.push_back('*');
      else if(i==3) c.push_back('/');
    }
  }
  int ans;
  int mx = -1000000000;
  int mn = 1000000000;
  do{
    if(v[0]==0) ans = (a[0] + a[1]);
    else if(v[0]==1) ans = (a[0] - a[1]);
    else if(v[0]==2) ans = (a[0] * a[1]);
    else if(v[0]==3) ans = (a[0] / a[1]);

    for(int i=1; i<n-1; i++){
      if(v[i]==0) ans += a[i+1];
      else if(v[i]==1) ans -= a[i+1];
      else if(v[i]==2) ans *= a[i+1];
      else if(v[i]==3) ans /= a[i+1];
    }

    mx = max(mx, ans);
    mn = min(mn, ans);
  }while(next_permutation(v.begin(), v.end()));

  cout<<mx<<'\n'<<mn;
  return 0;
}