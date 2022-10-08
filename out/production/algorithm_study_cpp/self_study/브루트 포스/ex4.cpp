#include <iostream>
#include <algorithm>

using namespace std;

int current=10;
int channel;
int btnNum;
int err;
int cnt;
int arr[500001];
int main(){
  cin>>channel;
  cin>>btnNum;
  for(int i=0; i<btnNum; i++){
    cin>>err;
    arr[err]=1;
    while(err<500000){
      err+=10;
      arr[err]=1;
    }
  }
  if(arr[channel]==0){cnt=0;}
  else{
    while(arr[channel]=0){
      channel++;
      cnt++;
    }
    int count;
    while(arr[channel]=0){
      channel--;
      count++;
    }
    cnt=min(count, cnt);
  }
}
// 현재 채널은 100
// 1. 숫자버튼 보다 + - 로 더 빨리 할 수 있는 경우
// 2. 가능한 숫자버튼에서 +, - 로 조정
// 3. 자릿수 계산