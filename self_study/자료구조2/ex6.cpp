#include <iostream>
#include <string>
#include <vector>

using namespace std;
//97~122
int main(){
  string str;
  vector<int> v(26);
  cin>>str;
  for(int i=0; i<str.length(); i++){
    v[str[i]-'a']++;
  }
  for(int i=0; i<26; i++){
    cout<<v[i]<<" ";
  }
}