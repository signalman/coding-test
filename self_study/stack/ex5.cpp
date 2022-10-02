#include <iostream>
#include <stack>
#include <string>
using namespace std;

int main(){
  string init;
  cin>>init;
  stack<char> init_stack;
  stack<char> temp_stack;
  for(char ch: init){
    init_stack.push(ch);
  }
  int N= init.length();
  int M;
  cin>>M;
  for(int i=0; i<M; i++){
    char cmd;
    cin>>cmd;
    if(cmd=='L'){
      if(!init_stack.empty()){
        temp_stack.push(init_stack.top());
        init_stack.pop();
      }
    }
    else if(cmd=='D'){
      if(!temp_stack.empty()){
        init_stack.push(temp_stack.top());
        temp_stack.pop();
      }
    }
    else if(cmd=='B'){
      if(!init_stack.empty()){
        init_stack.pop();
      }
    }
    else if (cmd=='P'){
      char ch;
      cin>>ch;
      init_stack.push(ch);
    }
  }
  while(!init_stack.empty()){
    temp_stack.push(init_stack.top());
    init_stack.pop();
  }while(!temp_stack.empty()){
    cout<<temp_stack.top();
    temp_stack.pop();
  }
  
  return 0;
}