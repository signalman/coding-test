#include <iostream>
#include <string>
#include <stack>

using namespace std;

void print(stack<char> &s){
  while(!s.empty()){
    cout<<s.top();
    s.pop();
  }
  return;
}

int main(){
  string str;
  bool tag=false;
  stack<char> stack;
  getline(cin, str);
  str+=" ";
  for(char ch: str){
    if(ch=='<'){
      print(stack);
      tag=true;
      cout<<ch;
    }
    else if(ch=='>'){
      tag=false;
      cout<<ch;
    }
    else if(ch==' '){
      print(stack);
      cout<<" ";
    }
    else if(tag){
      cout<<ch;
    }
    else{
      stack.push(ch);
    }
  }
  return 0;
}
