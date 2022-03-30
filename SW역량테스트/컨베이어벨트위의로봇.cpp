#include <bits/stdc++.h>
using namespace std;

vector<int> belt;
vector<int> A;
vector<int> robot;
int n, k;
int up, down;
int main(){
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin>>n>>k;
  for(int i=0; i<2*n; i++){
    int a;
    cin>>a;
    A.push_back(a);
  }
  belt.reserve(2*n);
  int cnt = 0;
  up = 0;
  down = n;
  while(1){
    


    vector<int> temp(2*n);
    cnt++;
    for(int i=0; i<2*n; i++){
      belt[i] = temp[(i+1)%(2*n)];
    }
    belt = temp;
    up= ((up-1)+2*n)%(2*n) , down = ((down-1)+2*n)%(2*n);
    for(int i=0; i<robot.size(); i++){
      if(belt[(robot[i]+1)%(2*n)] == 0 && A[(robot[i]+1)%(2*n)] != 0) {
        robot[i] = (robot[i] + 1) % (2*n);
        A[(robot[i]+1)%(2*n)]--;
      }
    }

    if(A[up] != 0){
      robot.push_back(up);
      belt[up] = 1;
    }
    
    int t = 0;
    for(int i=0; i<2*n; i++){
      if(A[i]==0){
        t++;
      }
    }
    if(t>=k) break;
  }

  cout<<cnt;
  return 0;
}