#include <iostream>
using namespace std;

class Dequeue{
public:
  Dequeue(){Size=0;arr[10005]={0,};}
  bool empty(){
    if(Size==0){
      return 1;
    }
    else return 0;
  }
  void push_front(int X){
    for(int i=Size; i>0; i--){
      arr[i]=arr[i-1];
    }
    arr[0]=X;
    Size++;
  }
  void push_back(int X){
    arr[Size]=X;
    Size++;
  }
  int pop_front(){
    if(!empty()){int front=arr[0]; for(int i=0; i<Size; i++){arr[i]=arr[i+1];} Size--; return front;}
    else return -1;
  }
  int pop_back(){
    if(!empty()){int back=arr[Size-1]; Size--; return back;}
    else return -1;
  }
  int size(){
    if(!empty()){return Size;}
    else return 0;
  }
  int front(){
    if(!empty()){return arr[0];}
    else return -1;
  }
  int back(){
    if(!empty()){return arr[Size-1];}
    else return -1;
  }
  
  int Size;
  int arr[10005];
};

int main(){
  int N;
  string a;
  Dequeue D;
  cin>>N;
  for(int i=0; i<N; i++){
    cin>>a;
    if(a=="push_back"){
      int num;
      cin>>num;
      D.push_back(num);
    }
    else if(a=="push_front"){
      int num;
      cin>>num;
      D.push_front(num);
    }
    else if(a=="pop_front"){
      cout<<D.pop_front()<<"\n";
    }
    else if(a=="pop_back"){
      cout<<D.pop_back()<<"\n";
    }
    else if(a=="size"){
      cout<<D.size()<<"\n";
    }
    else if(a=="empty"){
      cout<<D.empty()<<"\n";
    }
    else if(a=="front"){
      cout<<D.front()<<"\n";
    }
    else if(a=="back"){
      cout<<D.back()<<"\n";
    }
  }

}
