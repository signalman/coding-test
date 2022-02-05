#include <bits/stdc++.h>
using namespace std;

int main(){
  unordered_map<string, int> m;

  m["hi"] = 31;
  m["gogo"] = 123;
  m["hoin"] = 22;

  for(auto e: m)
    cout<< e.first << ' ' << e.second <<'\n';
}