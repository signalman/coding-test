#include <iostream>
#include <stack>
#include <string>
using namespace std;

int main(){
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  string str;
  cin>>str;
  
  stack<char> stk;
  for(int i=0; i<str.length(); i++){
    if(str[i]>='A'&& str[i]<='Z'){
      cout<<str[i];
    }
    else if(str[i]=='('){
      stk.push(str[i]);}
    else if(str[i]=='*' || str[i]=='/'){
      while(!stk.empty() && (stk.top()=='*' || stk.top()=='/')){
        cout<<stk.top();
        stk.pop();
      }
      stk.push(str[i]);
    }
    else if(str[i]=='+' || str[i]=='-'){
      while(!stk.empty()&&stk.top()!='('){
        cout<<stk.top();
        stk.pop();
      }
      stk.push(str[i]);
    }
    else if(str[i]==')'){
      while (!stk.empty() && stk.top() != '('){
        cout << stk.top();
        stk.pop();
      }
      stk.pop();
    }
  }
  while(!stk.empty()){
    cout<<stk.top();
    stk.pop();
  }


  return 0;
}