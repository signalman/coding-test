#include <iostream>
#include <algorithm>
using namespace std;

int arr[9];
int sum=0;

int main(){
  ios_base::sync_with_stdio(false);
  cin.tie(0);

  for(int i=0; i<9; i++){
    cin>>arr[i];
    sum+=arr[i];
  }
  int dif=sum-100;
  for(int i=0; i<8; i++){
    for(int j=i+1; j<9; j++){
      if(arr[i]+arr[j]==dif){
        arr[i]=-1;
        arr[j]=-1;
      }
    }
  }
  sort(arr,arr+9);
  for(int i=2; i<9; i++){
    cout<<arr[i]<<'\n';
  }
  return 0;
}