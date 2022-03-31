#include <bits/stdc++.h>
#include <iostream>
using namespace std;

bool belt[202]; //벨트위에 로봇이 있는지 저장
int A[202]; //벨트의 내구성 저장
int n, k;
int cnt;

int main(){
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin>>n>>k;
  for(int i=0; i<2*n; i++){
    cin>>A[i];
  }
  int up = 0;
  int down = n-1;
  while(true){
    cnt++;
    //1번
    if(belt[down]){
      belt[down] = 0;
    }
    down = (down - 1 + 2*n)%(2*n);
    up = (up - 1 + 2*n)%(2*n);
    int move = down;
    while(move!=up){
      if(move == down){belt[move] = 0; move = (move-1+2*n)%(2*n); continue;}
      if(belt[move] == 1 && belt[(move + 1 + 2*n)%(2*n)] == 0 && A[(move + 1 + 2*n)%(2*n)]>=1){
        belt[move] = 0;
        belt[(move + 1 + 2*n)%(2*n)] = 1;
        A[(move + 1 + 2*n)%(2*n)]--;
      }
      move = (move-1+2*n)%(2*n);
    }
    if(A[up] != 0){
      belt[up] = 1;
      A[up]--;
    }
    int t = 0;
    for(int i=0; i<2*n; i++){
      if(!A[i]){
        t++;
      }
    }
    if(t>=k){
      break;
    }

  }
  cout<<cnt;
}
