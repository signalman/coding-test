#include <bits/stdc++.h>
using namespace std;

int n;
string st;
vector<string> v;

bool serial(string& a, string& b){
  int sa=0;
  int sb=0;
  if(a.length() != b.length()) return a.length()<b.length();
  for(int i=0; i<a.length(); i++){
    if(isdigit(a[i])) sa +=(a[i]-'0');
  } 
  for(int i=0; i<b.length(); i++){
    if(isdigit(b[i])) sb +=(b[i]-'0');
  }
  
  if(sa != sb) return sa<sb;
  return a<b;
}
int main(){
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin>>n;
  for(int i=0; i<n; i++){
    cin>>st;
    v.push_back(st);
  }
  sort(v.begin(), v.end(), serial);
  for(auto i: v) cout<<i<<'\n';
}