#include <bits/stdc++.h>
using namespace std;


int main(){
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  int test;
  cin>>test;
  while(test--){
    string s;
    cin>>s;
    list<char> L={};
    auto cursor = L.begin();
    for(auto i: s){
      if(i=='<'){
        if(cursor != L.begin()) cursor--;
      }
      else if(i == '>'){
        if(cursor != L.end()) cursor++;
      }
      else if(i == '-'){
        if(cursor != L.begin()){cursor--; cursor = L.erase(cursor);}
      }
      else {
        L.insert(cursor, i);
      }
    }
    for(auto c: L){cout<< c;}
    cout<<'\n';
  }
}