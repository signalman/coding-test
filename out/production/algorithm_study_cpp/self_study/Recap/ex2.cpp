#include <bits/stdc++.h>
using namespace std;

int arr[26];
int main(){
  string s;
  cin>>s;
  for(int i=0; i<s.length(); i++){
    arr[s[i]-97]++;
  }
  for(int e: arr){
    cout<<e<<' ';
  }
}