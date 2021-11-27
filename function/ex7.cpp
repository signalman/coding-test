#include <iostream>
using namespace std;

int d(int);

int main(){
  int arr[10001]={0};
  int temp;
  for(int i=0; i<10000; i++){
    if(d(i)<10000){
      arr[d(i)]=1;
    }
  }
  for(int i=0; i<10000; i++){
    if(!arr[i]){
      cout<<i<<'\n';
    }
  
  }
  return 0;
}

int d(int n){
  return (n+(n/1000)+(n%1000)/100+(n%100)/10+(n%10));
}
