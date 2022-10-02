#include <bits/stdc++.h>
using namespace std;

void insert(int idx, int num, int arr[], int& len){
  len++;
  for(int i=len-1; i>=idx; i--){
    arr[i+1]=arr[i];
  }
  arr[idx] = num;
}
void erase(int idx, int arr[], int& len){
  len--;
  for(int i=idx; i<len; i++){
    arr[i] = arr[i+1];
  }
}
void printArr(int arr[], int& len){
  for(int i=0; i<len; i++){
    cout<<arr[i]<< ' ';
  } 
  cout<<"\n\n";
}
int main(){
  int arr[10] = {10, 50, 40, 30, 70, 20};
  int len = 6;
  insert(3, 60, arr, len);
  erase(4, arr, len);


  insert_test();
  erase_test();
}



void insert_test(){

}
void erase_test(){

}