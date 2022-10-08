#include <iostream>
#include <stack>
#include <string>

using namespace std;

int main(){
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  string str;
  cin>>str;
  stack<char> stack;
  int sum=0;
  for(int i=0; i<str.length(); i++){
    if(str[i]=='('){
      stack.push(str[i]);
    }
    else{
      if(str[i-1]==')'){
        sum+=1;
        stack.pop();
      }
      else if(str[i-1]=='('){
        stack.pop();
        sum+=stack.size();
      }
    }
  }
  cout<<sum<<'\n';
  return 0;
}