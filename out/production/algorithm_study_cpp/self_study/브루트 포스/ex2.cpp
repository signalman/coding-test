#include <iostream>
#include <algorithm>
using namespace std;

char arr[51][51];
int max_length=0;
int ans;
int candy_num;  
void check();
int main(){
  cin>>candy_num;
  for(int i=1; i<=candy_num; i++){
    for(int j=1; j<=candy_num; j++){
      cin>>arr[i][j];
    }
  }
  for(int i=1; i<=candy_num-1; i++){
    for(int j=1; j<=candy_num; j++){
      swap(arr[i][j],arr[i+1][j]);
      check();
      swap(arr[i][j], arr[i+1][j]);
    }
  }
  
  for(int i=1; i<=candy_num; i++){
    for(int j=1; j<=candy_num-1; j++){
      swap(arr[i][j],arr[i][j+1]);
      check();
      swap(arr[i][j],arr[i][j+1]);
    }
  }
  cout<<ans;
}
void check(){
  char c;
  for(int i=1; i<=candy_num; i++){
    int count = 1;
    c = arr[i][0];
    for(int j=1; j<=candy_num; j++){
      if(arr[i][j]==c){
        count++;   }
      else{  
        c=arr[i][j]; 
        count=1;   }
      if(ans<count)ans=count;
    }
  }

  for(int j=1; j<=candy_num; j++){
    int count = 1;
    c = arr[0][j];
    for(int i=1; i<=candy_num; i++){
      if(arr[i][j]==c){
        count++;   }
      else{  
        c=arr[i][j]; 
        count=1;   }
      if(ans<count)ans=count;
    }
  }
}