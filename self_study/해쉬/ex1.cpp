#include <bits/stdc++.h>
using namespace std;


map<string, int> m;
set<int> s;
multiset<int> s2;
set<int>::iterator it1 = s.begin(); 
int main(){
  unordered_map<string, int> m;

  m["hi"] = 31;
  m["gogo"] = 123;
  m["hoin"] = 22;

  for(auto e: m)
    cout<< e.first << ' ' << e.second <<'\n';
}