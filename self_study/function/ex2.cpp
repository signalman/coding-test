#include <iostream>
using namespace std;

void printarr(int (*arr)[4]){
  for(int i=0; i<3; i++){
    for(int j=0; j<4; j++){
      arr[i][j]=arr[i][j]*2;
    }
  }

  return;
}
int main(){
  int arr[3][4]= {
    {1, 2, 3, 3},
    {1, 1, 1, 1},
    {4, 3, 2, 1}
    };
  printarr(arr);
  for(int i=0; i<3; i++){
    for(int j=0; j<4; j++){
    cout<<arr[i][j]<<" ";
    }
    cout<<endl;
  }
  return 0;
}