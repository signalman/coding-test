#include <bits/stdc++.h>
using namespace std;

string s1;
string s2;
int n;

void comp(string s1, string s2){
  int a[26] = {};
  int b[26] = {};
  if(s1.length()!=s2.length()){
    cout<<"Impossible"<<'\n'; 
    return;}
  else{
    for(int i=0; i<s1.length(); i++){
      a[s1[i]-'a']++;
      b[s2[i]-'a']++;}
    for(int i=0; i<26; i++){
      if(a[i]!=b[i]){
        cout<<"Impossible"<<'\n'; 
        return;
      }
    }
    cout<<"Possible"<<'\n';
    return;
  }
}


int main(){
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin>>n;
  for(int i=0; i<n; i++){
    cin>>s1>>s2;
    comp(s1, s2);
  }

}