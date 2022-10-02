#include <bits/stdc++.h>
using namespace std;

int main(){
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  string s;
  cin>> s;
  int m;
  cin>>m;
  list<char> L;
  for(int i = 0; i<s.length(); i++){
    L.push_back(s[i]);
  }
  auto t = L.end();
  for(int i=0; i<m; i++){
    char c, d;
    cin >> c;
    if(c == 'P'){
      cin>>d;
      L.insert(t, d);
      }
    else if(c == 'D'){if(t!=L.end()) t++;}
    else if(c == 'B'){if(t != L.begin()){t--; t = L.erase(t);}}
    else if(c == 'L'){if(t!=L.begin()) t--;}
  }
  for(auto i : L) cout<< i;
}