#include <iostream>
#include <string>
#include <stack>

using namespace std;

int main(){
  int test_case;
  cin>>test_case;
  cin.ignore();
  for(int i=0; i<test_case; i++){
    string str;
    getline(cin,str);
    str+=' ';
    stack <char> str_stack;
    for(int i=0; i<str.length();i++){
      str_stack.push(str[i]);
      if(str[i]==' '){
        str_stack.pop();
        while(str_stack.size()>0){
          cout<<str_stack.top();
          str_stack.pop();
        }
        cout<<" ";
      }
    }
    cout<<'\n';
  }
  return 0;
}