#include <iostream>

using namespace std;

int main(){
  int SIZE;
  int arr[SIZE];
  cin>>SIZE;
  for(int i=0; i<SIZE; i++){
    cin>>arr[i];
  }
  for(int i=0; i<SIZE; i++){
    cout<<arr[i];
  }

  return 0;
}