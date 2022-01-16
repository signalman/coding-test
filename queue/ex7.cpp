#include <bits/stdc++.h>
using namespace std;

deque<int> deq;
int main(){
  int cnt = 0;
  int n, k;
  cin>>n>>k;
  for(int i=1; i<=n; i++){deq.push_back(i);}
  while(k--){
    int num;
    cin>>num;
    int cnt1 = 0;
    int cnt2 = 0;
    deque dq1(deq);
    deque dq2(deq);
    while(1){
      if(dq1.front()==num){break;}
      dq1.push_back(dq1.front());
      dq1.pop_front();
      cnt1+=1;
    }
    while(1){
      if(dq2.front()==num){break;}
      dq2.push_front(dq2.back());
      dq2.pop_back();
      cnt2+=1;
    }
    cnt += min(cnt1, cnt2);
    deq = dq1;
    deq.pop_front();
  }
  cout<< cnt;
}