#include <iostream>
#include <string>
using namespace std;


class Stack{
private:  
  int Size;
  int stack[10000];
public:
  Stack(){ Size=0; }


  void push(int data){
    stack[Size] = data;
    Size+=1;
  }
  int pop(){
    if(empty()){
      return -1;
    }
    else{
      int pop;
      pop=stack[Size-1];
      stack[Size-1]=0;
      Size-=1;
      return pop;
    }
  }
  bool empty(){
    if(Size==0){
      return true;
    }
    else{
      return false;
    }
  }
  int size(){
    if(empty()){
      return 0;
    }
    else{
      return Size;
    }
  }
  int top(){  
    if(empty()){
      return -1;
    }
    else{
      return stack[Size-1];
    }
  }
};

int main(){
  int N;
  string cmd;
  Stack st;
  cin>>N;
  for(int i=0; i<N; i++){
    cin>>cmd;
    if(cmd=="push"){
      int n;
      cin>>n;
      st.push(n);
    }
    else if(cmd=="top"){
      cout<<st.top()<<'\n';
    }
    else if(cmd=="size"){
      cout<< st.size() <<'\n';
    }
    else if(cmd=="empty"){
      cout<<st.empty()<<'\n';
    }
    else if(cmd=="pop"){
      cout<<st.pop()<<'\n';
    }
    
  }


  return 0;
}