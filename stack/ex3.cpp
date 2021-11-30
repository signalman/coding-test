#include <iostream>
#include <stack>
using namespace std;

int main(){
  int test_case;
  cin >> test_case;

  stack <char> stack;
  string str;
  for(int i=0; i<test_case; i++){
    cin>>str;
    for(int i=0; i<str.length();i++){
      if(str[i]=='('){stack.push(str[i]);}
      else if(str[i]=')'){
        if(!stack.empty()){
          stack.pop();
        }
        else{
          goto a;
        }
      }
    }
    if(stack.empty()){
      cout<<"YES"<<'\n';
    }
    else{
      a: cout<<"NO"<<'\n';
    }
    while(!stack.empty()){
      stack.pop();
    }
  }
  return 0;
}