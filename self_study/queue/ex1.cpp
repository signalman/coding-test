#include <iostream>
#include <string>
using namespace std;

class queue{
public:
  queue(){Size=0;}
  int Size;
  int q[200000];

  bool empty(){
    if(Size==0){
      return true;
    }
    else{
      return false;
    }
  }
  void push(int x){
    q[Size]=x;
    Size+=1;
    return;
  }
  int pop(){
    if(empty()){
      return -1;
    }
    else{
      int pop=q[0];
      for(int i=0; i<Size; i++){
        q[i]=q[i+1];
      }
      Size-=1;
      return pop;
    }
  }
  int size(){
    return Size;
  }
  int front(){
    if(empty()){
      return -1;
    }
    else{
      return q[0];
    }
  }
  int back(){
    if(empty()){
      return -1;
    }
    else{
      return q[Size-1];
    }
  }
};

int main(){
  int N;
  queue que;
  cin>>N;
  string s="";
  for(int i=0; i<N; i++){
    cin>>s;
    if(s=="push"){
      int x;
      cin>> x;
      que.push(x);
    }
    else if(s=="front"){
      cout<<que.front()<<'\n';
    }
    else if(s=="back"){
      cout<<que.back()<<'\n';
    }
    else if(s=="pop"){
      cout<<que.pop()<<'\n';
    }
    else if (s=="size"){
      cout<<que.size()<<'\n';
    }
    else if (s=="empty"){
      cout<<que.empty()<<'\n';
    }
  }


  return 0;
}