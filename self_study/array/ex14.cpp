#include <bits/stdc++.h>
using namespace std;

int cnt = 0;
int a[26];
int main(){
  string s1;
  string s2;
  cin>>s1>>s2;
  for(int i=0; i<s1.length(); i++){
    a[s1[i]-'a']++;
  }
  for(int i=0; i<s2.length(); i++){
    a[s2[i]-'a']--;
  }
  for(int i=0; i<26; i++){
    if(a[i]>=0)cnt+=a[i];
    else cnt-=a[i];
  }
  cout<<cnt;
}