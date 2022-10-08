#include <iostream>
#include <array>
using namespace std;

int main()
{
  int a; 
  int cnt=0;
  int arr[42]={};
  for (int i = 0; i < 10; i++)
  {
    cin >> a;
    arr[a%42]++;
  }
  for(int i=0; i<42; i++){
    if(arr[i]!=0){
      cnt++;
    }
  }
  cout<<cnt<<"\n";
  
  return 0;
}