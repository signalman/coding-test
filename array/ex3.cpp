#include <iostream>
#include <array>
#include <string>
using namespace std;

int main(){
  int a,b,c;
  int count[10]={};
  cin>>a>>b>>c;
  int n=a*b*c;
  string s = to_string(n);
  for(char ch: s){
    count[ch-'0']++;
  }
  for(int v: count){
    cout<< v <<"\n";
  }
  return 0;
}